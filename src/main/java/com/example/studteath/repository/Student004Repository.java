package com.example.studteath.repository;

import com.example.studteath.dao.StudentMapper;
import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.entity.User;
import org.springframework.beans.BeanUtils;
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
        BeanUtils.copyProperties(inputDto, student);
       LocalDateTime dateTime = LocalDateTime.now();
        student.setUpdateDate(dateTime);
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
