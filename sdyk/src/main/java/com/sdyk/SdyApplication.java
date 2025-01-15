package com.sdyk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sdyk.mapper")
public class SdyApplication {
    public static void main(String [] args){
        SpringApplication.run(SdyApplication.class,args);
    }
}
