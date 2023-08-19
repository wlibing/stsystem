package com.example.studteath.repository;

import com.example.studteath.dao.StudentMapper;
import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * ユーザー更新 リポジトリ
 */
@Repository
public class Student004Repository {
    /**
     * 学生 Mapper
     */
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository studentRepository;
    /**
     * 学生更新
     * @param inputDto
     * @return 検索結果
     */
    public StudentInfo searchstudent(Student004InputDto inputDto) {
       StudentInfo studentInfo = new StudentInfo();
        Student student = new Student();
        Long id = inputDto.getId();
        Long userId = inputDto.getUserId();
        String staffId = inputDto.getStaffId();
        String name = inputDto.getName();
        String age = inputDto.getAge();
        String sex = inputDto.getSex();
        String tel = inputDto.getTel();
        String maileAddress =  inputDto.getMaileAddress();
        String grade = inputDto.getGrade();
        String studentClass = inputDto.getStudentClass();
        String guardianTel = inputDto.getGuardianTel();
        String guardianMaileAddress = inputDto.getGuardianMaileAddress();
        String guardianName = inputDto.getGuardianName();
        String disableFlag = inputDto.getDisableFlag();

       LocalDateTime dateTime = LocalDateTime.now();
        student.setAge(age);
        student.setName(name);
        student.setSex(sex);
        student.setGrade(grade);
        student.setStudentClass(studentClass);
        student.setDisableFlag(disableFlag);
        student.setUpdateDate(dateTime);
        student.setId(id);
        student.setUserId(userId);
        student.setStaffId(staffId);
        student.setTel(tel);
        student.setMaileAddress(maileAddress);
        student.setGuardianTel(guardianTel);
        student.setGuardianMaileAddress(guardianMaileAddress);
        student.setGuardianName(guardianName);
        Integer integer = studentMapper.updateStudents(student);
        if (integer > 0 ){
            Student003InputDto student003InputDto = new Student003InputDto();
            student003InputDto.setId(inputDto.getId().toString());
            List<StudentInfo> list = studentRepository.searchAllStudent(student003InputDto);
            studentInfo = list.get(0);

        }
              return studentInfo;


    }
}
