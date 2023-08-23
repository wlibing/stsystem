package com.example.studteath.modelform;

import lombok.Data;

import java.io.Serializable;

/**
 * 学生情報 検索用リクエストデータ
 */
@Data
public class Student003Request implements Serializable {

    /**
     * 学生ID
     */
    private String id;
    /**
     * 学生名前
     */
    private String name;

}


