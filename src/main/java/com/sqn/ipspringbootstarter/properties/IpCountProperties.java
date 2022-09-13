package com.sqn.ipspringbootstarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//自定义bean的名称
@Component("ipCountProperties")
@ConfigurationProperties(prefix = "tools.ip")
@Data
public class IpCountProperties {
    /**
     * 日志打印周期
     */

    private Integer logCycle = 5;
    /**
     * 是否周期内重置
     */
    private Boolean cycleReset = false;
    /**
     * 日志模式 detail:详细模式 simple:极简模式
     */

    private String model = LogModel.DETAIL.value;

    //    枚举
    public enum LogModel {
        SIMPLE("simple"),
        DETAIL("detail");

        String value;

        LogModel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
