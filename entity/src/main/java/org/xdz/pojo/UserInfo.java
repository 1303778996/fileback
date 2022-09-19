package org.xdz.pojo;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2022-08-08 14:56:07
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 610918837517768312L;
    
    private Integer userId;
    
    private String userAccount;
    
    private String userPwd;
    
    private String userName;
    /**
     * �û�����
     */
    private Integer userScore;
    /**
     * �ϴ��ļ�������
     */
    private Integer uploadCount;
    /**
     * �����ļ�������
     */
    private Integer downCount;
    
    private String userImg;
    
    private Date userCtime;
    
    private Date userMtime;
    
    private String userTel;
    /**
     * ְҵ
     */
    private Integer careerId;
    
    private Integer eduId;
    
    private String userEmail;
    
    private Integer userSex;
    
    private Integer userState;


}

