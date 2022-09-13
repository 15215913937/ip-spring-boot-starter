package com.sqn.ipspringbootstarter.autoconfig;

import com.sqn.ipspringbootstarter.properties.IpCountProperties;
import com.sqn.ipspringbootstarter.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties(IpCountProperties.class)
public class IpAutoConfig {
    @Bean
    public IpCountService ipCountService() {
        return new IpCountService();
    }
}
