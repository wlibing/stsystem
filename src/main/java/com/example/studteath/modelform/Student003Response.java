package com.example.studteath.modelform;

import com.example.studteath.dto.OutputBaseDto;
import com.example.studteath.dto.StudentInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper=true)
public class Student003Response extends OutputBaseDto {
    /**
     * 学生リスト
     */
    private List<StudentInfo> studentInfoList;
}
