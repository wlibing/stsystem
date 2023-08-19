package com.example.studteath.repository;

import com.example.studteath.dao.StudentMapper;
import com.example.studteath.dto.Student003InputDto;
import com.example.studteath.dto.StudentInfo;
import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.entity.Student;
import com.example.studteath.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    /**
     * 学生情報 Mapper
     */
    @Autowired
    private StudentMapper studentMapper;

/**
 *学生一覧情報検索
 *
 * @return 検索結果
 */
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

}
