package com.example.Project1.Service;


import com.example.Project1.Model.Users;
import com.example.Project1.Repository.Usersrepo;
import com.example.Project1.Service.DTOs.LoginDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsersService {
    @Autowired
    Usersrepo usersrepo;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;



    public List<Users> getUsers(){
        return usersrepo.findAll();
    }
    public Users getUsersById(int id){
        return usersrepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));
    }
    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public LoginMessage LoginUser(LoginDTO loginDTO) {
        Users userOptional = usersrepo.findByphonenumber(Long.parseLong(loginDTO.getphonenumber()));
        if (userOptional!=null) {
            Users user = userOptional;
            // Check if the provided password matches the stored password
            String storedPassword = user.getPassword(); // Encoded password from the database
            String providedPassword = loginDTO.getPassword(); // Plain text password from the login form
            Boolean isPwdRight = passwordEncoder.matches(providedPassword, storedPassword);
            if (isPwdRight) {
                String token = jwtService.generateToken(user.getphonenumber().toString()); // Generate JWT token
                return new LoginMessage("Login Success", true,token);
            } else {
                return new LoginMessage("Password does not match", false,null);
            }
        } else {
            return new LoginMessage("Phone number does not exist", false,null);
        }
    }


    public void addUsers(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersrepo.save(user);
    }

    public void updateUsers(Users user){
        usersrepo.save(user);
    }

    public void deleteUser(int id){
        usersrepo.deleteById(id);
    }


    public boolean isphonenumberInUse(Long phonenumber) {
        try {
            return usersrepo.findByphonenumber(phonenumber)!=null;
        } catch (Exception e) {
            // Log the error (optional, depending on your logging framework)
            System.err.println("Error checking phone number in database: " + e.getMessage());
            return false; // Consider returning false or rethrowing the exception based on your needs
        }
    }
    public Users getUsersByphonenumber(String phonenumber) {
        return usersrepo.findByphonenumber(Long.parseLong(phonenumber));
    }
}