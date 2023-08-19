package com.example.studteath.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
public class Student004InputDto {

    /**
     * 学生ID
     */
    private Long id;

    /**
     * ユーザーID
     */
    private Long userId;

    /**
     * 従業員ID
     */
    private String staffId;
    /**
     * 名前
     */
    private String name;
    /**
     * 年齢
     */
    private String age;
    /**
     * 性別
     */
    private String sex;
    /**
     * 電話番号
     */
    private String tel;
    /**
     * メールアドレス
     */
    private String maileAddress;

    /**
     * グレード
     */
    private String grade;

    /**
     * クラス
     */
    private String studentClass;

    /**
     * 保護者電話番号
     */
    private String guardianTel;

    /**
     * 保護者メールアドレス
     */
    private String guardianMaileAddress;

    /**
     * 保護者名前
     */
    private String guardianName;
    /**
     * 有効フラグ
     */
    private String disableFlag;

}
