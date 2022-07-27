package com.example.studteath.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
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
     * 登録日時
     */
    private Date createDate;

    /**
     * 削除日時
     */
    private Date deleteDate;

}
