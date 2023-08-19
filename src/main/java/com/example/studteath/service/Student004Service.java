package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.repository.Student004Repository;
import com.example.studteath.repository.User004Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ユーザー更新 Service
 */
@Service
public class Student004Service {
    /**
     * 学生更新 リポジトリ
     */
    @Autowired
    private Student004Repository student004Repository;

    /**
     * ユーザー一覧情報検索
     *
     * @return 検索結果
     */
    public Student004OutputDto updateStudent(Student004InputDto inputDto) {
        Student004OutputDto outputDto = new Student004OutputDto();
        StudentInfo info = student004Repository.searchstudent(inputDto);
        Long id = info.getId();
        Long userId = info.getUserId();
        String staffId = info.getStaffId();
        String tel = info.getTel();
        String maileAddress =  info.getMaileAddress();
        String guardianTel = info.getGuardianTel();
        String guardianMaileAddress = info.getGuardianMaileAddress();
        String guardianName = info.getGuardianName();
        String age = info.getAge();
        String name = info.getName();
        String sex = info.getSex();
        String grade = info.getGrade();
        String  studentClass = info.getStudentClass();
        String disableFlag = info.getDisableFlag();
        Date updateDate = info. getUpdateDate();
        outputDto.setId(id);
        outputDto.setUserId(userId);
        outputDto.setStaffId(staffId);
        outputDto.setTel(tel);
        outputDto.setMaileAddress(maileAddress);
        outputDto.setGuardianTel(guardianTel);
        outputDto.setGuardianMaileAddress(guardianMaileAddress);
        outputDto.setGuardianName(guardianName);

        outputDto.setAge(age);
        outputDto.setName(name);
        outputDto.setSex(sex);
        outputDto.setGrade(grade);
        outputDto.setStudentClass(studentClass);
        outputDto.setDisableFlag(disableFlag);
        outputDto.setUpdateDate(updateDate);
        return outputDto;
    }


}
