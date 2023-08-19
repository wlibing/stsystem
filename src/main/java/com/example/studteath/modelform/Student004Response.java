package com.example.studteath.modelform;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Student004Response {
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
    private LocalDateTime updateDate;

    /**
     * 更新者
     */
    private Long updateUser;

    /**
     * 登録日時
     */
    private LocalDateTime createDate;

    /**
     * 登録者
     */
    private Long createUser;

    /**
     * 削除日時
     */
    private Date deleteDate;

    /**
     * 削除者
     */
    private Long deleteUser;

}
