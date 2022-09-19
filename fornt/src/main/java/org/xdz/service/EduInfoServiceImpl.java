package org.xdz.service;

import org.springframework.stereotype.Service;
import org.xdz.mapper.EduInfoMapper;
import org.xdz.pojo.EduInfo;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EduInfoServiceImpl implements EduInfoService{
    @Resource
    private EduInfoMapper eduInfoMapper;
    @Override
    public List<EduInfo> selList() {
        return eduInfoMapper.selList();
    }
}
