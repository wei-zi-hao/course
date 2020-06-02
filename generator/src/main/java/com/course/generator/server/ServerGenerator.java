package com.course.generator.server;

import com.course.generator.util.FreemarkerUtil;

import java.util.HashMap;
import java.util.Map;

public class ServerGenerator {
    static String MODULE = "business";
    static String toDtoPath = "server\\src\\main\\java\\com\\course\\server\\dto\\";
    static String toServicePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    static String toControllerPath = MODULE + "\\src\\main\\java\\com\\course\\" + MODULE + "\\controller\\admin\\";
    static String generatorConfigPath = "server\\src\\main\\resources\\generator\\generatorConfig.xml";

    public static void main(String[] args) throws Exception {
        String Domain = "Section";
        String domain = "section";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("Domain", Domain);
        map.put("domain", domain);


        // 生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Domain + "Service.java", map);

    }


}
