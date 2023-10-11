package br.com.eduardoalves.todolist.user;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Modificadores
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){

        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {
            System.out.println("Usuário já cadastrado!");
            // Mensagem de erro
            // Status Code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }

        var userCreated =  this.userRepository.save(userModel);
        System.out.println(userCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
