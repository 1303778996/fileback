package org.xdz.mapper;


import org.xdz.pojo.CareerInfo;

import java.util.List;

/**
* @author x'd'z
* @description 针对表【career_info】的数据库操作Mapper
* @createDate 2022-08-15 10:01:20
* @Entity generator.domain.CareerInfo
*/
public interface CareerInfoMapper  {
    List<CareerInfo> selList();


}
