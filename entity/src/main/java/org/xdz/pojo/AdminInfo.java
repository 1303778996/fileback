package org.xdz.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (AdminInfo)实体类
 *
 * @author makejava
 * @since 2022-07-28 11:27:52
 */
public class AdminInfo implements Serializable {
    private static final long serialVersionUID = 117650637145420551L;
    
    private Integer adminId;
    
    private String adminName;
    
    private String adminPwd;
    
    private Integer roleId;
    
    private Date adminCtime;
    
    private Integer adminState;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getAdminCtime() {
        return adminCtime;
    }

    public void setAdminCtime(Date adminCtime) {
        this.adminCtime = adminCtime;
    }

    public Integer getAdminState() {
        return adminState;
    }

    public void setAdminState(Integer adminState) {
        this.adminState = adminState;
    }

}

