package org.xdz.qo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.xdz.pojo.AdminInfo;
@Data
@NoArgsConstructor
public class AdminQo extends AdminInfo {
    private int lim;
    private int off;
    private Integer roleId;
}
