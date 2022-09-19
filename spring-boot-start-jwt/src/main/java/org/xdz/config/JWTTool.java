package org.xdz.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTool<T> {
    // 1.初始化头部信息
    private final static Map<String, Object> headers = new HashMap<>();
    static {
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");
    }
    // 2.设置加密的秘钥，这是加密的一个秘钥，到时候解析也是用这个秘钥来进行
    private final static String CODE = "moo";
    // 3.设置过期的时间长短：
    private final static Long EXP = 30*60*1000L;
    // 4.设置签发的人员信息
    private final static String ISS = "moo";
    // 3.因为保存我需要的数据使用的key，通过key能够找到对应的值
    // 因为是替换session，我们保存在session中的数据：验证码，用户信息
    // 所以key有两个：验证码、登录用户
    private final static String VALI_CODE = "code";
    private final static String ADMIN_CODE = "adminInfo";

    /**
     * 用来生成管理员的token信息
     * @param
     * @return
     */
    public static <T> String createToken(T t) {
        // 1.初始化当前时间和过期时间
        Date nowDate = new Date();
        Date expDate = new Date(nowDate.getTime() + EXP);
        // 2.初始化保存的数据
        Map<String, Object> datas = new HashMap<>();
        datas.put(ADMIN_CODE, JSONObject.toJSONString(t));
        // 3.设置签名和加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 3.1.这里的abc123是盐
        byte[] encodeKey = Base64.getDecoder().decode(CODE);
        SecretKey key = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        String jwtStr = Jwts.builder()
                .setClaims(datas) // 设置参数
                .setHeader(headers) // 设置头部信息
                .setExpiration(expDate)  // 设置过期时间
                .setIssuedAt(nowDate) // 设置签发时间
                .setIssuer(ISS)
                .signWith(signatureAlgorithm,key)  // 设置签名
                .compact();  // 生成token
//        System.out.println(jwtStr);
        return jwtStr;
    }

    /**
     * 用来解析管理员的token信息
     * @param
     * @return
     */
    public static <T>T parseToken(String token, Class<T> clazz) {
        byte[] encodeKey = Base64.getDecoder().decode(CODE);
        SecretKey key = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        String str = (String)claims.get(ADMIN_CODE);
        return JSON.parseObject(str, clazz);
    }

    /**
     * 生成验证码的方法
     * @param code
     * @return
     */
    public static String createCodeToken(String code) {
        // 1.初始化当前时间和过期时间
        Date nowDate = new Date();
        Date expDate = new Date(nowDate.getTime() + EXP);
        // 2.初始化保存的数据
        Map<String, Object> datas = new HashMap<>();
        datas.put(VALI_CODE, code);
        // 3.设置签名和加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 3.1.这里的abc123是盐
        byte[] encodeKey = Base64.getDecoder().decode(CODE);
        SecretKey key = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        String jwtStr = Jwts.builder()
                .setClaims(datas) // 设置参数
                .setHeader(headers) // 设置头部信息
                .setExpiration(expDate)  // 设置过期时间
                .setIssuedAt(nowDate) // 设置签发时间
                .setIssuer(ISS)
                .signWith(signatureAlgorithm,key)  // 设置签名
                .compact();  // 生成token
        System.out.println(jwtStr);
        return jwtStr;
    }
    /**
     * 解析验证码
     * @param token
     * @return
     */
    public static String parseCode4Token (String token) {
        byte[] encodeKey = Base64.getDecoder().decode(CODE);
        SecretKey key = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        return (String)claims.get(VALI_CODE);
    }

//    public static void main(String[] args) {
//        UserInf userInf = new UserInf();
//        userInf.setUserAcc("林炜");
//        String jwtStr = JWTTool.createAdminInfoToken(userInf);
//        System.out.println(jwtStr);
//        UserInf user = JWTTool.parseToken2AdminInfo(jwtStr);
//        System.out.println(user.getUserAcc());
//    }
}