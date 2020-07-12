package com.dbshard.util;

import com.dbshard.bean.Card;
import com.dbshard.bean.DbConfig;
import com.dbshard.bean.User;
import com.dbshard.connect.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName SqlUtil
 * @Description TODO
 * @Author chenshuai
 * @Date 2020/7/9 11:12
 * @Version 1.0
 */
@Component
public class SqlUtil implements Proxy {
    @Autowired
    private DbConnect dbConnect;
    @Autowired
    private DbConfig dbConfig;
    @Autowired
    private User user;
    @Autowired
    private Card card;

    public String sqlChange(String sql) throws Exception {
        if (sql == null && "".equals(sql)) {
            return null;
        }
        String db;
        String s = sql.toLowerCase();
        if (s.trim().startsWith("insert")) {
            String[] split = s.split("\\s+");
            db = split[2];
            String[] split1 = db.split("\\(");
            DbConfig dbConfig = selectDBMessage(split1[0]);
            Statement statement = getStatement(dbConfig);
            Object o = dbSelect(dbConfig, statement);
        }
        if (s.trim().startsWith("select")) {

        }
        if (s.trim().startsWith("delete")) {

        }
        if (s.trim().startsWith("update")) {

        }
        return null;
    }
    /**
     * @Author chenshuai
     * @Description 查询表所属库及其分表信息
     * @Date 14:10 2020/7/9
     * @Param [dbname]
     * @return com.dbshard.bean.DbConfig
     **/
    private DbConfig selectDBMessage(String dbname) throws Exception {
        DataSource dbNameConnection = dbConnect.getDBNameConnection();
        Connection connection = dbNameConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from dbconfig where dbname = " + dbname);
        if (resultSet == null) {
            return null;
        }
        String dnname = resultSet.getString("dbname");
        String dbbelong = resultSet.getString("dbbelong");
        String dblong = resultSet.getString("dblong");
        dbConfig.setDbbelong(dbbelong);
        dbConfig.setDblong(Integer.parseInt(dblong));
        dbConfig.setDbname(dnname);
        return dbConfig;
    }
    /**
     * @Author chenshuai
     * @Description 返回分库分表查询结果
     * @Date 14:11 2020/7/9
     * @Param [dbConfig]
     * @return java.lang.Object
     **/
    private Object dbSelect(DbConfig dbConfig, Statement statement) throws SQLException {
        int dblong = dbConfig.getDblong();
        String dbname = dbConfig.getDbname();
        String dbbelong = dbConfig.getDbbelong();
        try {
            //todo 表添加对应的实体类
            //todo 获取对应的字段封装结果
            Object o = Class.forName("").newInstance();
            Proxy object = getObject(Proxy.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= dblong; i++) {
            ResultSet resultSet = statement.executeQuery("select * from " + dbbelong + "." + dbname + "_" + i);


        }
        return null;
    }
    /**
     * @Author chenshuai
     * @Description 获取查询statement
     * @Date 14:26 2020/7/9
     * @Param [dbConfig]
     * @return java.sql.Statement
     **/
    private Statement getStatement(DbConfig dbConfig) throws Exception {
        String dbbelong = dbConfig.getDbbelong();
        if (dbbelong == null && "".equals(dbbelong)) {
            return null;
        }
        if (dbbelong.equals("db1")) {
            return dbConnect.getDB1Connection().getConnection().createStatement();
        }
        if (dbbelong.equals("db2")) {
            return dbConnect.getDB2Connection().getConnection().createStatement();
        }
        return null;
    }

    @Override
    public <T> T getObject(Class<T> type) {

        //通过动态代理生成了一个实现类，我们重点关注，动态代理的实现，它是一个 InvocationHandler，传入参数是 this，就是 sqlSession 的一个实例。
        InvokeHandlerImpl invokeHandler = new InvokeHandlerImpl(this);
        //给我一个接口，还你一个实现类
        return (T) java.lang.reflect.Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},invokeHandler);
    }

}
