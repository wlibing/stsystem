package com.example.studteath.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper=true)
public class Student003OutputDto extends InputBaseDto{
    /**
     * 学生リスト
     */
    private List<StudentInfo> StudentInfoList;
}
