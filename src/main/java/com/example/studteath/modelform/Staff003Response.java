package com.example.studteath.modelform;

import com.example.studteath.dto.OutputBaseDto;
import com.example.studteath.dto.StaffInfo;
import com.example.studteath.dto.StudentInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class Staff003Response extends OutputBaseDto {
    /**
     * 従業員リスト
     */
    private List<StaffInfo> staffInfoList;
}
