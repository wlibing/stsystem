package com.example.studteath.entity;

import java.util.Date;

import lombok.Data;


/**
 * ユーザー情報 Entity
 */
@Data
public class User {

    /**
     * ID
     */
    private Long id;

    /**
     * ユーザーNo
     */
    private String userNo;

    /**
     * パスワード
     */
    private String password;

    /**
     * 権限フラグ
     */
    private String power_flag;

    /**
     * 更新日時
     */
    private Date updateDate;

    /**
     * 登録日時
     */
    private Date createDate;

    /**
     * 削除日時
     */
    private Date deleteDate;
}