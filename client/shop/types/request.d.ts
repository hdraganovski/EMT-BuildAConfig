interface LogInRequest {
    username: string;
    password: string;
}

interface SignUpRequest {
    email: string;
    password: string;
    fullName: string;
    imageUrl?: string;
}