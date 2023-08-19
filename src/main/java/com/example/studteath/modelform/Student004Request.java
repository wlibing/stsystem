package com.example.studteath.modelform;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class Student004Request implements Serializable {

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
