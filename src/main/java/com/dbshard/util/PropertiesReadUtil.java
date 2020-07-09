package com.dbshard.util;

        import org.springframework.stereotype.Component;

        import java.io.File;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Properties;

/**
 * @ClassName PropertiesReadUtil
 * @Description TODO
 * @Author chenshuai
 * @Date 2020/7/9 10:17
 * @Version 1.0
 */
@Component
public class PropertiesReadUtil {
    public  Map<String, String> readProperties(String db, String file) {
        Properties properties = new Properties();
        Map<String, String> hashMap = new HashMap();
        InputStream resourceAsStream = PropertiesReadUtil.class.getClassLoader().getResourceAsStream(file);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = properties.getProperty(db + "." + "driver");
        String url = properties.getProperty(db + "." + "url");
        String username = properties.getProperty(db + "." + "username");
        String password = properties.getProperty(db + "." + "password");
        hashMap.put("driver", driver);
        hashMap.put("url", url);
        hashMap.put("username", username);
        hashMap.put("password", password);
        return hashMap;
    }
}
