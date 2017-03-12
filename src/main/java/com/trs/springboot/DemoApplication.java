package com.trs.springboot;

import com.trs.springboot.service.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by yuanwenjie on 2016/11/23.
 */
@SpringBootApplication
public class DemoApplication {

    @Bean
    CommandLineRunner runner(StudentRepository sr) {
        return args -> {
            sr.findByAddress("address26").stream().forEach(System.out::println);
        };
    };
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
