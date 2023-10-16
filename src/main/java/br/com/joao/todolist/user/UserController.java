package br.com.joao.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.todolist.providers.HttpJsonResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller - It can return templates and objects for example

@RestController // This decorator is used to build API's
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody UserModel userModel){

        UserModel user = this.userService.create(userModel);
        if(user == null){
            var resp = new HttpJsonResponseMessage(400, "This user already exists!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }   

    @GetMapping("/")
    public String getMethodName() {
        return "Working fine";
    }
}
