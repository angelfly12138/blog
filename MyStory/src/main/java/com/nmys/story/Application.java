package com.nmys.story;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

    /**
     * Description:启动类
     * Author:hongfei.zhang
     * Param
     * Return
     * Date 2019/4/1 9:38
     */
    @SpringBootApplication
    @MapperScan("com.nmys.story.mapper")
    @EnableScheduling
    @ServletComponentScan
    public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

}