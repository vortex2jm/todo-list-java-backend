package br.com.joao.todolist.providers;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.joao.todolist.user.interfaces.IUSerRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TaskFilter extends OncePerRequestFilter{

    @Autowired
    private IUSerRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        var servletPath = request.getServletPath();
        
        if(servletPath.equals("/tasks/")){
            var auth = request.getHeader("Authorization");
            auth = auth.substring("Basic".length()).trim();
            byte[] decodedAuth = Base64.getDecoder().decode(auth);
            String decodedString = new String(decodedAuth);
            String[] credentials = decodedString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            var user = this.userRepo.findByUsername(username);
            if(user == null){
                response.sendError(401);
            }
            else{
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                
                if(passwordVerify.verified){
                    filterChain.doFilter(request, response);
                } 
                else{
                    response.sendError(401);
                }
            }
        } 
        else{
            filterChain.doFilter(request, response);
        }
    }
}
