package com.example.studteath.modelform;

import com.example.studteath.dto.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class USER003Response {
    /**
    * ユーザリスト
    */
    private List<UserInfo> userInfoList;
}
