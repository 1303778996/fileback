package org.xdz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PACKAGE_NAME: com.zjm.subjecttest.pojo
 * @PROJECT_NAME: SpringBoot-Test
 * @description: 公共返回对象
 * @author: ZhuJM
 * @create: 2022/3/6 23:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicResponseObject {
    private Long code;
    private String message;
    private Object object;
    
    /** 
    * @Description: success 200成功返回结果200不包括Object
    * @Param: [message] 
    * @return:  
    * @Author: ZhuJM 
    * @Date: 2022/3/6 
    */ 
    public static PublicResponseObject success(String message){
        return new PublicResponseObject(200L,message,null);
    }

    /**
    * @Description: success 成功返回结果200包括Object
    * @Param: [message, object]
    * @return:
    * @Author: ZhuJM
    * @Date: 2022/3/6
    */
    public static PublicResponseObject success(String message, Object object){
        return new PublicResponseObject(200L,message,object);
    }

    /**
     * @Description: successNull 成功处理但是获取的内容是空的204
     * @Param: [message, object]
     * @return:
     * @Author: ZhuJM
     * @Date: 2022/3/21
     */
    public static PublicResponseObject successNull(String message){
        return new PublicResponseObject(204L,message,null);
    }

    /** 
    * @Description: successError 处理成功但是请求体内某些处理要求无效
    * @Param: [message] 
    * @return:  
    * @Author: ZhuJM 
    * @Date: 2022/3/21 
    */ 
    public static PublicResponseObject successError(String message){
        return new PublicResponseObject(20404L,message,null);
    }

    /** 
    * @Description: error 失败返回结果500不包括Object
    * @Param: [message] 
    * @return:  
    * @Author: ZhuJM 
    * @Date: 2022/3/6 
    */ 
    public static PublicResponseObject error(String message){
        return new PublicResponseObject(500L,message,null);
    }

    /**
    * @Description: error 失败返回结果500包括Object
    * @Param: [message, object]
    * @return:
    * @Author: ZhuJM
    * @Date: 2022/3/6
    */
    public static PublicResponseObject error(String message, Object object){
        return new PublicResponseObject(500L,message,object);
    }

}
