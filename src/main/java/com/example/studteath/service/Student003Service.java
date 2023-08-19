package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生情報 Service
 */
@Service
public class Student003Service {
    /**
     * 学生情報 リポジトリ
     */
    @Autowired
private StudentRepository studentRepository;
    /**学生覧情報検索
     *
     * @return 検索結果
     */
    public Student003OutputDto searAllchStudent(Student003InputDto inputDto){
        Student003OutputDto outputDto = new Student003OutputDto();
        List<StudentInfo> studentInfoList = studentRepository.searchAllStudent(inputDto);
        outputDto.setStudentInfoList(studentInfoList);
        return outputDto;

    }

}
