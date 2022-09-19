package org.xdz.util;

import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NoteUtil {
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    private String appId = "111967";
    private String appSecret = "71d94054-b7f5-4d22-965f-3b1b25ae9178";
//    @Resource
//    private SystemService systemService;
//    @Resource
//    private RedisTool redisTool;

    public String sendNote(String userAcc, String code) {
        String result = "";
        try {
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("number", userAcc);
            params.put("templateId", "9813");
            String[] templateParams = new String[2];
            templateParams[0] = code;
            templateParams[1] = "2分钟";
            params.put("templateParams", templateParams);
            result = client.send(params);
            System.out.println(result);
            // 将随机生成的code 存入到redis中 时间为120s
            //redisTool.saveExpireVal("loginCode",code,120l, TimeUnit.SECONDS);
            // redisTool.saveExpireVal("hello","hahaha",120l,TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
