package com.dbshard.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Created by ASUS on 2020/7/8.
 */
@Data
@ToString
@Component
public class User {
    private int id;
    private String name;
    private String password;
}
