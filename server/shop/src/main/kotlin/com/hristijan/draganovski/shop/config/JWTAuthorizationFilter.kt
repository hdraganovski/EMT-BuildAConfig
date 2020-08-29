package com.hristijan.draganovski.shop.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.hristijan.draganovski.shop.config.JWTAuthenticationFilter.Companion.AUTHORITIES_KEY
import com.hristijan.draganovski.shop.config.JWTAuthenticationFilter.Companion.HEADER_STRING
import com.hristijan.draganovski.shop.config.JWTAuthenticationFilter.Companion.SECRET
import com.hristijan.draganovski.shop.config.JWTAuthenticationFilter.Companion.TOKEN_PREFIX
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTAuthorizationFilter(authenticationManage: AuthenticationManager) : BasicAuthenticationFilter(authenticationManage) {
    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(req: HttpServletRequest,
                                  res: HttpServletResponse,
                                  chain: FilterChain) {
        val header = req.getHeader(HEADER_STRING)
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res)
            return
        }
        val authentication = getAuthentication(req)
        SecurityContextHolder.getContext().authentication = authentication
        chain.doFilter(req, res)
    }

    private fun getAuthentication(request: HttpServletRequest): UsernamePasswordAuthenticationToken? {
        val rawToken = request.getHeader(HEADER_STRING)
        if (rawToken != null) {
            // parse the token.
            val token = JWT.require(Algorithm.HMAC512(SECRET.toByteArray()))
                    .build()
                    .verify(rawToken.replace(TOKEN_PREFIX, ""))

            val authorities = token
                    .getClaim(AUTHORITIES_KEY)
                    .asString()
                    .split(",")
                    .map { SimpleGrantedAuthority(it) }

            return if (token.subject != null) {
                UsernamePasswordAuthenticationToken(
                        token.subject,
                        null,
                        authorities)
            } else null
        }
        return null
    }
}