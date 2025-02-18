package com.verdolaganation.Verdolaga_Nation.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AuthResponse {
    private final String token;
    private final Integer userId; // Cambié el tipo a Integer
    private final String username; // Añadí el username

    private AuthResponse(String token, Integer userId, String username) {
        this.token = token;
        this.userId = userId;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;
        private Integer userId;
        private String username;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(this.token, this.userId, this.username);
        }
    }
}
