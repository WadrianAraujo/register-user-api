package br.com.wax.registeruserapi.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DTOUser(
        @Size(min = 5, max =  100, message = "The username need from 5 to 100 characters")
        @NotBlank(message = "The username is necessary")
        String login,

        @Email
        String email,

        @Size(max = 15, message = "The cell phone number cannot exceed 15 characters")
        String phoneNumber) {
}
