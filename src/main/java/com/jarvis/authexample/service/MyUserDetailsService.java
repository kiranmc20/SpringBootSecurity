package com.jarvis.authexample.service;

import com.jarvis.authexample.model.MyUserDetails;
import com.jarvis.authexample.model.Student;
import com.jarvis.authexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository stuRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student stud = stuRepo.findByUsername(username);
        if(null == stud){
            System.out.println("User not found" + username);
            throw new UsernameNotFoundException("User not found");
        }
        MyUserDetails myUserDetails = new MyUserDetails(stuRepo.findByUsername(username));
        return myUserDetails;
    }
}
