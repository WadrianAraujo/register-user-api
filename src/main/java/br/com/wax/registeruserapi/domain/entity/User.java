package br.com.wax.registeruserapi.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max =  100, message = "The username need from 5 to 100 characters")
    @NotBlank(message = "The username is necessary")
    private String login;

    @Email
    private String email;

    @Size(max = 15, message = "The cell phone number cannot exceed 15 characters")
    private String phoneNumber;



}
