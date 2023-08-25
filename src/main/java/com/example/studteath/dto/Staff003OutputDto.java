package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class Staff003OutputDto extends InputBaseDto{
    /**
     * 従業員リスト
     */
    private List<StaffInfo> StaffInfoList;
}
