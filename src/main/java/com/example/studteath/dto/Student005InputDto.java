package com.example.studteath.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 学生情報 検索用リクエストデータ
 */
@Getter
@Setter
public class Student005InputDto extends InputBaseDto {

    /**
     * 学生ID
     */
    private String id;

}
