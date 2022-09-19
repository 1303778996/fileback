package org.xdz.service;

import org.springframework.stereotype.Service;
import org.xdz.mapper.MgrLogMapper;

import javax.annotation.Resource;

@Service
public class MgrLogMapperServiceImpl implements MgrLogMapperService{
   @Resource
    private MgrLogMapper mgrLogMapper;

    @Override
    public int insert(int id, String url) {
        return mgrLogMapper.insert(id, url);
    }
}
