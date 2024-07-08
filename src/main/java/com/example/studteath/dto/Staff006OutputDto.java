package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class Staff006OutputDto extends OutputBaseDto{
    /**
     * 従業員リスト
     */
    private List<StaffInfo> staffInfoList;
}
