package com.example.studteath.modelform;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class USER001SearchRequest  implements Serializable {

    /**
     * ユーザーID
     */
    @NotEmpty(message = "IDを入力してください")
    private String id;
}
