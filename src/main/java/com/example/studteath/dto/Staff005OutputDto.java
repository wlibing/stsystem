package com.example.studteath.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Staff005OutputDto {
    /**
     * 従業員ID
     */
    private Long id;

    /**
     * ユーザーID
     */
    private Long userId;

    /**
     * 従業員名前
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
     * 職階フラグ
     */
    private String shikiFlag;

    /**
     * 担当グレード
     */
    private String workGrade;

    /**
     * 担当クラス
     */
    private String workClass;

    /**
     * 有効フラグ
     */
    private String disableFlag;

    /**
     * 作成時間
     */
    private LocalDateTime createDate;

    /**
     * 作成者
     */
    private Long createUser;

    /**
     * 更新日時
     */
    private LocalDateTime updateDate;

    /**
     * 更新者
     */
    private Long updateUser;

    /**
     * 削除日時
     */
    private Date deleteDate;

    /**
     * 削除者
     */
    private Long deleteUser;
}
