package org.xdz.service;

import org.springframework.stereotype.Service;
import org.xdz.mapper.UserInfoMapper;
import org.xdz.pojo.UserInfo;

import javax.annotation.Resource;
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.login(userInfo);
    }

    @Override
    public int reg(UserInfo userInfo) {
        return userInfoMapper.reg(userInfo);
    }

    @Override
    public UserInfo sleByAcc(String acc) {
        return userInfoMapper.sleByAcc(acc);
    }
}
