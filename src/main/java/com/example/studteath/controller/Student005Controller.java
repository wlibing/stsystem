package com.example.studteath.controller;


import com.example.studteath.dto.Student005InputDto;
import com.example.studteath.dto.Student005OutputDto;
import com.example.studteath.dto.USER005InputDto;
import com.example.studteath.dto.USER005OutputDto;
import com.example.studteath.entity.Student;
import com.example.studteath.service.Student005Service;
import com.example.studteath.service.USER005Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 学生情報削除コントローラー
 */
@Controller
public class Student005Controller {
    /**
     * 学生情報 Service
     */
    @Autowired
    Student005Service service;
    @Autowired
    protected MessageSource messageSource;

    /**
     * 学生削除
     *
     * @param id リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("/student/delete")
    public String delete(String id, Model model) {
        // ユーザーサービス入力dtoを定義
       Student005InputDto inputDto = new Student005InputDto();
        inputDto.setId(id);
        //ユーザーサービスを呼び出し
        Student005OutputDto student005OutputDto = service.delete(inputDto);
        model.addAttribute("studentinfolist", student005OutputDto.getStudentInfoList());
        return "student/search";
    }
}
