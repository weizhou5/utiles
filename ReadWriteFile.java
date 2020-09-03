package com.envisioniot.eap.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.*;

/**
 * Created by wzhou4 on 2017/3/24.
 */
public class ReadWriteFile {
    private static Logger logger = LoggerFactory.getLogger(ReadWriteFile.class);
    public static String readFile(@NotNull String fileName) {
        StringBuffer fileContent = new StringBuffer();
        BufferedReader br = null;
        String data = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while ((data = br.readLine()) != null) {
                fileContent.append(data);
            }
            return fileContent.toString();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
