package com.example.studteath.modelform;

import lombok.Data;

import java.io.Serializable;

/**
 * 主任情報 検索用リクエストデータ
 */
@Data
public class Director003Request implements Serializable {

    /**
     * 主任ID
     */
    private String id;
    /**
     * 主任名前
     */
    private String name;

}


