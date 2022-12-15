package com.example.studteath.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
public class USER005InputDto extends InputBaseDto {

    /**
     * ユーザーID
     */
    private String id;

}
