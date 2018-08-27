package com.wangxiao.web.controller;

import com.wangxiao.DemoApplication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * Created by WangXiao on 2017/12/21.
 */
@RestController
public class CallMe {
    @Autowired
    Environment env;
    private final Logger logger = Logger.getLogger(CallMe.class);
    @RequestMapping(value = "/index")
    public String inviteMe(HttpServletRequest request){
        logger.info("outer access /index");
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        }catch (Exception e){
            System.out.println("异常。。。" + e.getMessage());
            logger.error("异常:" + e.getMessage());
        }
        logger.info("outer access /index---result:" + address.getHostAddress());
        return "local ip is:" + address.getHostAddress() + " new version\n";
    }

    @RequestMapping(value = "/env")
    public String getEnvTest(HttpServletRequest request){
        logger.info("outer access /env");
        String temp = "";
        try {
            temp = env.getProperty("wang.test");
        }catch (Exception e){
            temp = e.getMessage();
            logger.error("异常:" + e.getMessage());
        }
        logger.info("outer access /env---result:" + temp);
        return "我们配置的换进变量是:" + temp;
    }
}
