package org.xdz.dto;

import java.util.HashMap;
import java.util.Map;


/**
  * @Description:  用于传输数据
  * @Param:
  * @return:
  * @Author: cc
  * @Date: 2022/5/12
  */


public class JSONDto {
    // 判断状态：0-成功；其他都代表失败
    private  int id;
    // 返回的内容信息
    private String message;
    // 跳转的路径
    private String location;
    // 如果是分页需要传输很多数据，那么这里就用来保存分页数据用的
    private Map<String, Object> data = new HashMap<>();

    public JSONDto() {
    }

    public JSONDto(int id, String message, String location, Map<String, Object> data) {
        this.id = id;
        this.message = message;
        this.location = location;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
