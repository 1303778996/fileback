package org.xdz.mapper;
import org.apache.ibatis.annotations.Param;
import org.xdz.pojo.UserInfo;

public interface UserInfoMapper {
    UserInfo login(UserInfo userInfo);
     int reg(UserInfo userInfo);
     UserInfo sleByAcc(@Param("acc") String acc);
}
