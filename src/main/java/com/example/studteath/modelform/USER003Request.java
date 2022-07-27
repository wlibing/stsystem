package com.example.studteath.modelform;

import lombok.Data;

import java.io.Serializable;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class USER003Request implements Serializable {

    /**
     * ユーザーID
     */
    private String id;

    /**
     * ユーザーNo
     */
    private String userNo;

}
