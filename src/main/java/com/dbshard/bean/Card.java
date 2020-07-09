package com.dbshard.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * @ClassName Card
 * @Description TODO
 * @Author chenshuai
 * @Date 2020/7/9 10:03
 * @Version 1.0
 */
@Component
@Data
@ToString
public class Card {
    private int id;
    private String message;
    private Date birthday;
}
