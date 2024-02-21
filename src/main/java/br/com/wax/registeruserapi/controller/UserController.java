package br.com.wax.registeruserapi.controller;

import br.com.wax.registeruserapi.domain.entity.User;
import br.com.wax.registeruserapi.domain.repository.UserRepository;
import br.com.wax.registeruserapi.domain.user.DTOUser;
import br.com.wax.registeruserapi.domain.user.DTOUserListing;
import br.com.wax.registeruserapi.domain.user.DTOUserUpdate;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DTOUser data){
        userRepository.save(new User(data));
    }

    @GetMapping
    public List<DTOUserListing> getUser(){
        return userRepository.findAll().stream().map(DTOUserListing::new).toList();
    }

    @PutMapping
    @Transactional
    public void updateUser(@RequestBody @Valid DTOUserUpdate data){
        var user = userRepository.getReferenceById(data.id());
        user.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
