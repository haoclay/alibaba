package com.example.alibaba.test.uitls;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Author : sgq
 * Date : 2021/1/19 17:29
 */
public class NacosProperties {
    public static void main(String[] args) throws NacosException {
        String serverAddr = "http://localhost:8848";
        String namespace = "7ff52a93-a0b0-4a11-87fa-5136a408de49";
        String dataId = "sun-moon-payService.yaml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace",namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId,group,5000);
        System.out.println(config);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });
     while (true){
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }
}
