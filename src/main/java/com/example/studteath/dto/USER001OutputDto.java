package com.example.studteath.dto;

import lombok.Data;

import java.util.Date;

@Data
public class USER001OutputDto {
    /**
     * ID
     */
    private Long id;

    /**
     * 名前
     */
    private String name;

    /**
     * 住所
     */
    private String address;

    /**
     * 電話番号
     */
    private String phone;

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
