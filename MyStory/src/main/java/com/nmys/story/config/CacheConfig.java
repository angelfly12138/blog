package com.nmys.story.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: 缓存以及线程配置类
 *
 * @Author hongfei.zhang
 *
 */
@Configuration
public class CacheConfig {

    /**
     * Description: 邮件发送线程池，可扩大
     * Author:hongfei.zhang
     */
    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(5);
    }

}
