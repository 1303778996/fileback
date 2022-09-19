package org.xdz.service;

import org.apache.ibatis.annotations.Param;

public interface MgrLogMapperService {
    int insert(int id, String url);
}
