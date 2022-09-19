package org.xdz.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (EduInfo)实体类
 *
 * @author makejava
 * @since 2022-08-15 10:37:05
 */
public class EduInfo implements Serializable {
    private static final long serialVersionUID = 590559480889722470L;
    
    private Integer eduId;
    
    private String eduName;
    
    private Date eduCtime;


    public Integer getEduId() {
        return eduId;
    }

    public void setEduId(Integer eduId) {
        this.eduId = eduId;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public Date getEduCtime() {
        return eduCtime;
    }

    public void setEduCtime(Date eduCtime) {
        this.eduCtime = eduCtime;
    }

}

