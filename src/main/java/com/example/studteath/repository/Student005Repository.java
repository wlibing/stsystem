package com.example.studteath.repository;

import com.example.studteath.dao.StudentMapper;
import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生情報 リポジトリ
 */
@Repository
public class Student005Repository {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentInfo> searchAllStudent(Student003InputDto student003InputDto) {
        List<StudentInfo> studentInfoList=new ArrayList<>();
        Student studentSearch = new Student();
        String id = student003InputDto.getId();
        Long studentId = null;
        if (id != "" && id != null){
            studentId = Long.parseLong(id);
            studentSearch.setId(studentId);
        }

        studentSearch.setDisableFlag("1");
        List<Student> students = studentMapper.searchStudentList(studentSearch);
        if (students.size()>0){
            for (Student student: students){
                StudentInfo studentInfo = new StudentInfo();
                BeanUtils.copyProperties(student, studentInfo);
                studentInfoList.add(studentInfo);
            }
        }
        return studentInfoList;
    }

    /**
     * 学生削除
     *
     * @return 検索結果
     */
    public Student005OutputDto delete(Student005InputDto inputDto) {
        String id=inputDto.getId();
        Integer addNum=studentMapper.delete(Integer.parseInt(id));
        Student005OutputDto student005OutputDto=new Student005OutputDto();
        student005OutputDto.setStudentInfoList(searchAllStudent(new Student003InputDto()));
        return student005OutputDto;
    }

}
