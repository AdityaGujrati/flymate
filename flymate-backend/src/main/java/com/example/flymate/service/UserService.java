package com.example.flymate.service;

import com.example.flymate.entity.UserEntity;
import com.example.flymate.model.UserRequest;
import com.example.flymate.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public void addUser(UserRequest userRequest){
        UserEntity userEntity = UserEntity.builder()
                                           .userName(userRequest.getUserName())
                                            .emailId(userRequest.getEmailId())
                                            .phoneNumber(userRequest.getPhoneNumber())
                                           .build();
       userRepository.save(userEntity);
    }

}
