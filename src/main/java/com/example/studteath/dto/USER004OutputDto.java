package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class USER004OutputDto extends OutputBaseDto{
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

}
