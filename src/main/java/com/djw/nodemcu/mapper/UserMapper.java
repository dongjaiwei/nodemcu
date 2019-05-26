package com.djw.nodemcu.mapper;

import com.djw.nodemcu.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Insert("insert into user (user_name,password) values(#{userName},#{password})")
    void insert(UserInfo userInfo);

    @Select("select * from user where user_name= #{name}")
    UserInfo getUserForName(String name);

    @Select("select * from user where user_name= #{name} password =#{password}")
    UserInfo getUserForNP(String userName, String password);

    @Update("update user set token=#{token} where user_name=#{userName}")
    void upDateToken(String token,String userName);
}
