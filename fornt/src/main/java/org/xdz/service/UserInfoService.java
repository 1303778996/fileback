package org.xdz.service;


import org.apache.ibatis.annotations.Param;
import org.xdz.pojo.UserInfo;

public interface UserInfoService  {
    //登录
  UserInfo login(UserInfo userInfo);
  int reg(UserInfo userInfo);
    UserInfo sleByAcc(String acc);
}
