package com.example.demo.config;

import com.example.demo.aspect.AnalysisTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AOPConfig
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/11/13 18:02
 */
@Configuration
public class AOPConfig {

    @Bean
    public AnalysisTimes analysisTimes(){ return new AnalysisTimes(); }
}
