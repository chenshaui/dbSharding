package com.dbshard.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @ClassName DbConfig
 * @Description TODO
 * @Author chenshuai
 * @Date 2020/7/9 10:06
 * @Version 1.0
 */
@ToString
@Data
@Component
public class DbConfig {
    private String dbname;
    private String dbbelong;
    private int dblong;
    private String dbentity;
}
