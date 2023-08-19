package com.example.studteath.service;

import com.example.studteath.dto.Student005InputDto;
import com.example.studteath.dto.Student005OutputDto;
import com.example.studteath.repository.Student005Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生情報 Service
 */
@Service
public class Student005Service {
    /**
     * 学生情報 リポジトリ
     */
    @Autowired
    private Student005Repository student005Repository;



    /**
     * 学生一覧情報検索
     *
     * @return 検索結果
     */
    public Student005OutputDto delete(Student005InputDto inputDto) {

        Student005OutputDto out = student005Repository.delete(inputDto);
        return out;
    }


}
