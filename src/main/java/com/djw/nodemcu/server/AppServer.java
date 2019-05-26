package com.djw.nodemcu.server;

import com.djw.nodemcu.Bean.RDate;
import com.djw.nodemcu.entity.UserInfo;
import com.djw.nodemcu.mapper.UserMapper;
import com.djw.nodemcu.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class AppServer {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/register")
    public RDate<String> register(UserInfo userInfo){
        UserInfo userForName = userMapper.getUserForName(userInfo.userName);
        if(userForName != null)return new RDate<>("用户名被占用,请重新输入");
        userInfo.token = CommonUtils.makeToken();
        userMapper.insert(userInfo);
        return new RDate<>(userInfo.token);
    }
}
