package com.envision.eap.gatewayparent.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
/**
 * @author ：wei.zhou
 * @date ：Created in 2020/4/29 16:06
 */
public class PropertiesUtil {
    private static Logger logger = LogManager.getLogger(PropertiesUtil.class.getSimpleName());

    private static Properties prop = new Properties();

    /**
     * 读取配置文件
     * @param stream
     */
    public static void readProperties(InputStream stream){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(stream));
            prop.load(bf);
        }catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    /**
     * 根据key读取对应的value
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}