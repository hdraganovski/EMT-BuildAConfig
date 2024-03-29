package com.hristijan.draganovski.shop.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm.HMAC512
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import java.util.stream.Collectors
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TMPUser {
    var username: String
    var password: String

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }

    constructor() {
        this.username = ""
        this.password = ""
    }
}

class JWTAuthenticationFilter(private val mAuthenticationManager: AuthenticationManager) : UsernamePasswordAuthenticationFilter() {
    init {
        authenticationManager = mAuthenticationManager
    }

    override fun attemptAuthentication(req: HttpServletRequest, res: HttpServletResponse): Authentication {
        return try {
            val creds: TMPUser = ObjectMapper().readValue(req.inputStream, TMPUser::class.java)
            authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(
                            creds.username,
                            creds.password,
                            ArrayList())
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(req: HttpServletRequest?,
                                          res: HttpServletResponse,
                                          chain: FilterChain?,
                                          auth: Authentication) {
        val authorities = auth.authorities.joinToString(",", transform = GrantedAuthority::getAuthority)
        val token: String = JWT.create()
                .withSubject((auth.principal as User).username)
                .withClaim(AUTHORITIES_KEY, authorities)
                .withExpiresAt(Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.toByteArray()))
        res.addHeader(HEADER_STRING, TOKEN_PREFIX.toString() + token)
    }

    companion object {
        const val SECRET = "SecretKeyToGenJWTs"
        const val EXPIRATION_TIME: Long = 864000000 // 10 days
        const val TOKEN_PREFIX = "Bearer "
        const val HEADER_STRING = "Authorization"
        const val SIGN_UP_URL = "/user"
        const val AUTHORITIES_KEY = "AUTHORITIES_KEY"
    }
}