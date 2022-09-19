package org.xdz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (MgrLog)实体类
 *
 * @author makejava
 * @since 2022-08-02 15:07:15
 */
@Data
@NoArgsConstructor

public class MgrLog implements Serializable {
    private static final long serialVersionUID = -44198214713659194L;
    
    private Integer logId;
    /**
     * ���Ǳ���ajax��url�����Һ��ֻҪ������ɾ����Ϣ
     */
    private String logUrl;
    
    private Integer adminId;
    
    private Date logCtime;

    public MgrLog(String logUrl, Integer adminId) {
        this.logUrl = logUrl;
        this.adminId = adminId;
    }
}

