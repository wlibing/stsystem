package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class USER003OutputDto extends OutputBaseDto{
    /**
     * ユーザリスト
     */
    private List<UserInfo> userInfoList;
}
