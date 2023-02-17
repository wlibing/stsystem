package com.example.studteath.modelform;

import lombok.Data;

import java.util.Date;

@Data
public class USER004Response {
    /**
     * ID
     */
    private String id;

    /**
     * ユーザーNo
     */
    private String userNo;

    /**
     * パスワード
     */
    private String passWord;

    /**
     * 権限フラグ
     */
    private String powerFlag;

    /**
     * 有効フラグ
     */
    private String disableFlag;

    /**
     * 更新日時
     */
    private Date updateDate;

}
