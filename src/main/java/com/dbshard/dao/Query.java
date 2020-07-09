package com.dbshard.dao;

import com.dbshard.connect.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Query
 * @Description TODO
 * @Author chenshuai
 * @Date 2020/7/9 11:10
 * @Version 1.0
 */
@Component
public class Query {
    @Autowired
    private DbConnect dbConnect;
    public void query() {

    }
}
