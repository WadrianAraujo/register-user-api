package br.com.wax.registeruserapi.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max =  100, message = "The name need from 5 to 100 characters")
    @NotBlank(message = "The name is necessary")
    private String name;

    @Email
    private String email;

    @Size(min = 8, max = 25, message = "The password need from 5 to 25 characters")
    @NotBlank(message = "the password is necessary")
    private String password;
}
