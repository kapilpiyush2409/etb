package com.example.ETB.controller;

import com.example.ETB.model.UserData;
import com.example.ETB.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/")
    public String Home() {
        return "redirect:/userInfoAdd";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userInfoAdd")
    public String signup(Model model) {
        UserData userData = new UserData();
        model.addAttribute("userData", userData);
        return "/userInfoAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userInfoAdd")
    public String signupUser(UserData user) {
        userDataService.addUser(user);
        return "redirect:/userInfoDisplay";
    }

    @RequestMapping(value = "/userInfoDisplay")
    public String Home(Model model) {
        List<UserData> data = userDataService.getAllData();
        model.addAttribute("allData", data);
        return "userInfoDisplay";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public String deleteuser(@RequestParam(name = "userId") Integer userId) {
        userDataService.deleteuser(userId);
        return "redirect:/userInfoDisplay";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userInfoUpdate")
    public String getData(@RequestParam(name = "userId") Integer userId, Model model) {
        UserData data = userDataService.getusrData(userId);
        model.addAttribute("data", data);
        return "userInfoUpdate";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/userInfoUpdate")
    public String updateImage(@RequestParam(name = "userId") Integer userId, UserData newData) {
        newData.setId(userId);
        userDataService.updateNewData(newData);
        return "redirect:/userInfoDisplay";
    }
}
