package br.com.wax.registeruserapi.domain.user;

import jakarta.validation.constraints.NotNull;

public record DTOUserUpdate(@NotNull Long id, String login, String phoneNumber) {
}
