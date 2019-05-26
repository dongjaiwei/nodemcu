package com.djw.nodemcu.mapper;

import com.djw.nodemcu.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into users(user_name,password) values(#{userName},#{password})")
    void insert(UserInfo userInfo);

    @Select("select * from user where user_name= #{name}")
    UserInfo getUserForName(String name);

}
