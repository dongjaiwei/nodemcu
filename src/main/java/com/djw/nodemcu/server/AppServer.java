package com.djw.nodemcu.server;

import com.djw.nodemcu.Bean.RDate;
import com.djw.nodemcu.entity.UserInfo;
import com.djw.nodemcu.mapper.UserMapper;
import com.djw.nodemcu.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class AppServer implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/register")
    public RDate<String> register(UserInfo userInfo) {
        if (userInfo.getUserName() == null) return new RDate<>("请输入用户名");
        if (userInfo.getPassword() == null) return new RDate<>("请输入密码");
        UserInfo userForName = userMapper.getUserForName(userInfo.getUserName());
        if (userForName != null) return new RDate<>("用户名被占用,请重新输入");
        userInfo.setToken(CommonUtils.makeToken());
        userMapper.insert(userInfo);
        return new RDate<>(userInfo.getToken());
    }

    @RequestMapping("/login")
    public RDate<String> login(UserInfo userInfo) {
        if (userInfo.getUserName() == null) return new RDate<>("请输入用户名");
        if (userInfo.getPassword() == null) return new RDate<>("请输入密码");
        UserInfo userForName = userMapper.getUserForName(userInfo.getUserName());
        if (userForName == null) return register(userInfo);
        UserInfo checkUser = userMapper.getUserForNP(userInfo.getUserName(), userInfo.getPassword());
        if (checkUser == null) return new RDate<>("密码错误");
        String token = CommonUtils.makeToken();
        checkUser.setToken(token);
        userMapper.upDateToken(token, checkUser.getUserName());
        return new RDate<>(token);
    }
    

}
