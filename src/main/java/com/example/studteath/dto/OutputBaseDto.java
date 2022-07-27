package com.example.studteath.dto;

import lombok.Data;

import java.util.List;

@Data
public abstract class OutputBaseDto {
    /**
     * 結果コード
     */
    private String resultCode;

    /**
     * エラーコード
     */
    private String errorCode;

    /**
     * エラーリスト
     */
    private List<String> errorList;
}
