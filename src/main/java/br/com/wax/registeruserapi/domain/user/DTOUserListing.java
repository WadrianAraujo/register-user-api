package br.com.wax.registeruserapi.domain.user;

import br.com.wax.registeruserapi.domain.entity.User;

public record DTOUserListing(Long id, String login, String email, String phoneNumber) {

    public DTOUserListing(User user){
        this(user.getId(), user.getLogin(), user.getEmail(), user.getPhoneNumber());
    }

}
