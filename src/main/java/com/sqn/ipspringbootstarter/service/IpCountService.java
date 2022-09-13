package com.sqn.ipspringbootstarter.service;

import com.sqn.ipspringbootstarter.properties.IpCountProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    IpCountProperties ipCountProperties;

    public void ipCount() {
        String ip = httpServletRequest.getRemoteAddr();
        map.merge(ip, 1, Integer::sum);

    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void print() {
        if (ipCountProperties.getModel().equals(IpCountProperties.LogModel.DETAIL.getValue())) {
            System.out.println("                ip访问监控              ");
            System.out.println("+-----ip-address-----+---num---+");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.printf("|%18s  |%5d    |%n", entry.getKey(), entry.getValue());
            }
            System.out.println("+-----ip-address-----+---num---+");
        } else if (ipCountProperties.getModel().equals(IpCountProperties.LogModel.SIMPLE.getValue())) {
            System.out.println("           ip访问监控         ");
            System.out.println("+-----ip-address-----+");
            for (String value : map.keySet()) {
                System.out.printf("|%18s  |%n", value);
            }
            System.out.println("+-----ip-address-----+");
        }

//清空
        if (ipCountProperties.getCycleReset()) {
            map.clear();
        }
    }

    public static void main(String[] args) {
        new IpCountService().print();
    }
}
