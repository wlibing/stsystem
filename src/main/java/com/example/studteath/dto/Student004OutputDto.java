package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
public class Student004OutputDto {

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
}
