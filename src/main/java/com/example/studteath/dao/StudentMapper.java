package com.example.studteath.dao;

import com.example.studteath.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生情報 Mapper
 */
@Mapper
public interface StudentMapper {
    /**
     * 学生情報検索
     *
     * @param student 学生検索用リクエストデータ
     * @return 学生情報
     */
    Student searchStudent(Student student);
    /**
     * 学生情報検索
     *
     * @return 学生一覧情報
     */
    List<Student> searchStudentList(Student student);
    /**
     * 学生情報検索
     *
     * @return 学生一覧情報更新
     */
   Integer updateStudents(Student student);
    /**
     * 学生削除
     */
    Integer delete(Integer id);



}
