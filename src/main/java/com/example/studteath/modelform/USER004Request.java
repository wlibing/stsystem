package com.example.studteath.modelform;

import lombok.Data;

import java.io.Serializable;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class USER004Request implements Serializable {

    /**
     * ユーザーID
     */
    private String id;

    /**
     * ユーザー権限フラグ
     */
    private String powerFlag;

    /**
     * パスワード
     */
    private String passWord;

}
