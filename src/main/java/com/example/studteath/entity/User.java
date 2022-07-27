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

    /**
     * 更新者
     */
    private Long updateUser;

    /**
     * 登録日時
     */
    private Date createDate;

    /**
     * 登録者
     */
    private Long createUser;

    /**
     * 削除日時
     */
    private Date deleteDate;

    /**
     * 削除者
     */
    private Long deleteUser;
}