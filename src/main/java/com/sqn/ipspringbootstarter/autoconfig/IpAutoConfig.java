package com.sqn.ipspringbootstarter.autoconfig;

import com.sqn.ipspringbootstarter.properties.IpCountProperties;
import com.sqn.ipspringbootstarter.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//放弃配置属性创建bean方式（@EnableConfigurationProperties），改为手工控制（@Import）
//@EnableConfigurationProperties(IpCountProperties.class)
@Import(IpCountProperties.class)
public class IpAutoConfig {
    @Bean
    public IpCountService ipCountService() {
        return new IpCountService();
    }
}
