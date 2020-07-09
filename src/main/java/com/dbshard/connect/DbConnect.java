package com.dbshard.connect;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.dbshard.util.PropertiesReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName DbConnect
 * @Description 创建数据库连接
 * @Author chenshuai
 * @Date 2020/7/9 10:14
 * @Version 1.0
 */
@Component
public class DbConnect {
    @Autowired
    private PropertiesReadUtil propertiesReadUtil;

    public DataSource getDB1Connection() throws Exception {
        Properties properties = new Properties();
        Map<String, String> db1 = propertiesReadUtil.readProperties("db1", "com/dbshard/util/PropertiesReadUtil.java");
        properties.put("driverClassName", db1.get("driver"));
        properties.put("url", db1.get("url"));
        properties.put("username", db1.get("username"));
        properties.put("password", db1.get("password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    public DataSource getDB2Connection() throws Exception {
        Properties properties = new Properties();
        Map<String, String> db1 = propertiesReadUtil.readProperties("db2", "com/dbshard/util/PropertiesReadUtil.java");
        properties.put("driverClassName", db1.get("driver"));
        properties.put("url", db1.get("url"));
        properties.put("username", db1.get("username"));
        properties.put("password", db1.get("password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    public DataSource getDBNameConnection() throws Exception {
        Properties properties = new Properties();
        Map<String, String> db1 = propertiesReadUtil.readProperties("dbname", "com/dbshard/util/PropertiesReadUtil.java");
        properties.put("driverClassName", db1.get("driver"));
        properties.put("url", db1.get("url"));
        properties.put("username", db1.get("username"));
        properties.put("password", db1.get("password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }
}
