package br.com.joao.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.joao.todolist.user.interfaces.IUSerRepository;

@Service
public class UserService {
    
    @Autowired
    private IUSerRepository userRepository;

    public UserModel create(UserModel user){

        var foundUser = this.userRepository.findByUsername(user.getUsername());

        if(foundUser != null)  //If user already exists
            return null;

        var hashPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashPassword);

        return this.userRepository.save(user);
    }    
}
