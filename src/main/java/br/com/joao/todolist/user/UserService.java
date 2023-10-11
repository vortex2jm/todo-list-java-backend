package br.com.joao.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.todolist.IUSerRepository;

@Service
public class UserService {
    
    @Autowired
    private IUSerRepository userRepository;

    public UserModel create(UserModel user){

        UserModel foundUser = this.userRepository.findByUsername(user.getUsername());

        if(foundUser != null)  //If user already exists
            return null;

        foundUser = this.userRepository.save(user);
        return user;
    }    

}