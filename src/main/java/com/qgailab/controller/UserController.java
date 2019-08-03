package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.User;
import com.qgailab.service.UserService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:36
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult login(@RequestBody User user, HttpServletRequest request) {
        ServiceResult result = userService.login(user);
        if(result.getStatus()==200){
            User login= (User) result.getData();
            request.getSession().setAttribute("login",login);
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult login(HttpServletRequest request) {
        try {
            request.getSession().removeAttribute("login");
            request.getSession().invalidate();
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success);
    }
}
