package com.example.studteath.modelform;

import com.example.studteath.dto.DirectorInfo;
import com.example.studteath.dto.OutputBaseDto;
import com.example.studteath.dto.StaffInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class Director003Response extends OutputBaseDto {
    /**
     * 従業員リスト
     */
    private List<DirectorInfo> directorInfoList;
}
