package org.xdz.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (CareerInfo)实体类
 *
 * @author makejava
 * @since 2022-08-15 10:05:42
 */
public class CareerInfo implements Serializable {
    private static final long serialVersionUID = 605814212847657345L;
    
    private Integer careerId;
    
    private String careerName;
    
    private Date careerCtime;


    public Integer getCareerId() {
        return careerId;
    }

    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public Date getCareerCtime() {
        return careerCtime;
    }

    public void setCareerCtime(Date careerCtime) {
        this.careerCtime = careerCtime;
    }

}

