package com.example.studteath.modelform;

import lombok.Data;

import java.io.Serializable;

/**
 * 従業員情報 検索用リクエストデータ
 */
@Data
public class Staff003Request implements Serializable {

    /**
     * 従業員ID
     */
    private String id;
    /**
     * 従業員名前
     */
    private String name;

}


