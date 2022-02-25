package com.example.studteath.modelform;

import lombok.Data;

import java.util.Date;

@Data
public class USER001ResponseForm {
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

    /**
     * 結果コード
     */
    private String resultCode;

}
