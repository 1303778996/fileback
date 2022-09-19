package org.xdz.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (MenuInfo)实体类
 *
 * @author makejava
 * @since 2022-08-01 10:45:39
 */
public class MenuInfo implements Serializable {
    private static final long serialVersionUID = -37766645250390144L;
    
    private Integer menuId;
    
    private String menuName;
    
    private String menuUrl;
    
    private Date menuCtime;
    
    private Integer menuState;
    
    private Integer menuPid;
    
    private String menuIcon;


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Date getMenuCtime() {
        return menuCtime;
    }

    public void setMenuCtime(Date menuCtime) {
        this.menuCtime = menuCtime;
    }

    public Integer getMenuState() {
        return menuState;
    }

    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

}

