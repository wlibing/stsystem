package com.example.studteath.controller;

import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.modelform.Student003Request;
import com.example.studteath.modelform.Student003Response;
import com.example.studteath.modelform.USER003Request;
import com.example.studteath.modelform.USER003Response;
import com.example.studteath.service.Student003Service;
import com.example.studteath.service.USER003Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class Student003Controller {
    /**
     * 学生情報 Service
     */
    @Autowired
    Student003Service student003Service;
    @Autowired
    protected MessageSource messageSource;

    /**
     * 学生情報検索
     *
     * @param student003Request リクエストデータ
     * @param model          Model
     * @return 学生情報一覧画面
     */
    @PostMapping("/student/search")
    public String search(@Validated @ModelAttribute Student003Request student003Request, Model model) {
        Student003Response from = new Student003Response();

        // ユーザーサービス入力dtoを定義
        Student003InputDto inputDto = new Student003InputDto();
        BeanUtils.copyProperties(student003Request, inputDto);
        //ユーザーサービスを呼び出し
        Student003OutputDto student003OutputDto = student003Service.searAllchStudent(inputDto);
        List<StudentInfo> studentInfoListOut = student003OutputDto.getStudentInfoList();
        from.setStudentInfoList(studentInfoListOut);
        model.addAttribute("studentinfolist", from.getStudentInfoList());
        return "student/search";
    }
}
