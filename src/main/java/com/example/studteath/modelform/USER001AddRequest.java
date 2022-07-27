package com.example.studteath.modelform;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * ユーザー情報 登録用リクエストデータ
 */
@Data
public class USER001AddRequest {

    /**
     * ID
     */
    @NotEmpty
    private String id;

    /**
     * ユーザーNo
     */
    @NotEmpty
    @Size(min = 8,max = 8)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{validation.include-lower-case-number}")
    private String userNo;

    /**
     * パスワード
     */
    @NotEmpty
    @Size(min = 8,max = 8)
    @Pattern(regexp = "^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$", message = "{validation.include-lower-icon-case-number}")
    private String passWord;

    /**
     * 権限フラグ
     */
    @NotEmpty
    @Size(min = 1,max = 1)
    @Pattern(regexp = "^[0-9]+$", message = "{validation.include--number}")
    private String powerFlag;
}
