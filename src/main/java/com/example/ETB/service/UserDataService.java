package com.example.ETB.service;

import com.example.ETB.model.UserData;
import com.example.ETB.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public UserData getusrData(Integer userId) {
        return userDataRepository.getUserData(userId);
    }

    public void updateNewData(UserData newData) {
        userDataRepository.updateusrData(newData);
    }

    public void addUser(UserData user) {
        userDataRepository.addUser(user);
    }

    public List<UserData> getAllData() {
        return userDataRepository.addAllData();
    }

    public void deleteuser(Integer userId) {
        userDataRepository.deleteuser(userId);
    }
}
