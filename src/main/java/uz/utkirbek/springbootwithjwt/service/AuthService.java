package uz.utkirbek.springbootwithjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: utkirbek.
 * Time: 21:33:52
 * Date: July 14, 2023, Friday
 */
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList=new ArrayList<>(
                Arrays.asList(
                        new User("utkirbek", passwordEncoder.encode("1"), new ArrayList<>()),
                        new User("utkir", passwordEncoder.encode("2"), new ArrayList<>()),
                        new User("bek", passwordEncoder.encode("3"), new ArrayList<>())
                )
        );
        for (User user: userList){
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UsernameNotFoundException("User not found!");
    }
}
