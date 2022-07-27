package com.example.studteath.modelform;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * ユーザー登録用model
 */
@Data
public class USER002Request {
    /**
     * ユーザーNo
     */
    @NotEmpty
    private String userNo;

    /**
     * パスワード
     */
    @NotEmpty
    private String passWord;
}
