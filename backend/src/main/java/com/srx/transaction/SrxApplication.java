package com.srx.transaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 这段代码是一个Spring Boot应用程序的入口类，它配置了MyBatis的Mapper扫描和Spring的任务调度功能，
 * 并实现了ApplicationContextAware接口以获取ApplicationContext对象。
 * 它的主要作用是启动应用程序并进行必要的配置。
 */

@SpringBootApplication
@MapperScan("com.srx.transaction.Mapper")
@EnableScheduling
public class SrxApplication implements ApplicationContextAware {
    public static void main(String[] args) {
        SpringApplication.run(SrxApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}


