package org.xdz;

import com.sun.deploy.net.HttpUtils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.xdz.mapper")
public class ForntBoot {
    public static void main(String[] args) {
        SpringApplication.run(ForntBoot.class,args);

    }
}
