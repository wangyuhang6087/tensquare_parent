package com.zhiyou100.base;

import com.zhiyou100.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author:Rain
 * @date 2019/10/31 11:42
 * @desc
 */
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }

   @Bean
    public IdWorker getId(){

      return  new IdWorker();
    }
}
