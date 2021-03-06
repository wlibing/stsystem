package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
public class USER001OutputDto extends OutputBaseDto{
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
