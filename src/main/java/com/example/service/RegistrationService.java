package com.example.service;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    private DataProcessingService dataProcessingService;

    private UserService userService ;

    private NotificationService notificationService;

    public String processRegistration(String name, int age, String email){
    User newUser = userService.createUser(name, age, email);
    dataProcessingService.addUserToList(newUser);
    return notificationService.sendNotification(newUser);

    }
}