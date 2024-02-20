package br.com.wax.registeruserapi.domain.entity;

import br.com.wax.registeruserapi.domain.user.DTOUser;
import br.com.wax.registeruserapi.domain.user.DTOUserUpdate;
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
    private String login;
    private String email;
    private String phoneNumber;

    public User(DTOUser data) {
        this.email = data.email();
        this.login = data.login();
        this.phoneNumber = data.phoneNumber();
    }

    public void updateData(DTOUserUpdate data) {
        if (data.login() != null){
            this.login = data.login();
        }
        if (data.phoneNumber() != null){
            this.phoneNumber = data.phoneNumber();
        }

    }
}
