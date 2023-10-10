package br.com.eduardoalves.todolist.user;

import org.apache.catalina.connector.Request;
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
    /*
     * String (texto)
     * Integer (int) numeros inteiros
     * Double (double) números 0.0000
     * Float (float) números 0.000
     * char (caractere único) A B C
     * void (vazio) não retorna nada 
     */

    /*
     * Body
     */

    @PostMapping("/")
    public void create(@RequestBody UserModel userModel){
        System.out.println(userModel.getClass());
    }
}
