package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class Director003OutputDto extends InputBaseDto{
    /**
     * 主任リスト
     */
    private List<DirectorInfo> DirsectorInfoList;
}
