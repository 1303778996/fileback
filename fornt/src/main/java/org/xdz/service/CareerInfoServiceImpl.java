package org.xdz.service;

import org.springframework.stereotype.Service;
import org.xdz.mapper.CareerInfoMapper;
import org.xdz.pojo.CareerInfo;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CareerInfoServiceImpl implements CareerInfoService{
    @Resource
    private CareerInfoMapper careerInfoMapper;

    @Override
    public List<CareerInfo> selList() {
        return careerInfoMapper.selList();
    }
}
