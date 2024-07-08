package com.example.studteath.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 従業員情報検索用リクエストデータ
 */
@Getter
@Setter
public class Staff006InputDto extends InputBaseDto {

    /**
     * 従業員ID
     */
    private String id;

}
