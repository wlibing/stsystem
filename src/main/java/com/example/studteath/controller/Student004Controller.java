package com.example.studteath.controller;


import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.modelform.Student004Request;
import com.example.studteath.modelform.Student004Response;
import com.example.studteath.modelform.USER004Request;
import com.example.studteath.modelform.USER004Response;
import com.example.studteath.service.Student003Service;
import com.example.studteath.service.Student004Service;
import com.example.studteath.service.USER003Service;
import com.example.studteath.service.USER004Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 * ユーザー情報更新コントローラー
 */
@Controller
public class Student004Controller {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    Student004Service service;

    /**
     * ユーザー情報検索 Service
     */
    @Autowired
    Student003Service serviceEdit;

    /**
     * 学生情報更新
     *
     * @param student004Request リクエストデータ
     * @param model          Model
     * @return 学生情報一覧画面
     */
    @PostMapping("/student/update")
    public String update(@Validated @ModelAttribute Student004Request student004Request, Model model) {
        Student004Response student004Response = new Student004Response();
        Student004InputDto inputDto = new Student004InputDto();
        BeanUtils.copyProperties(student004Request, inputDto);
        Student004OutputDto outputDto = service.updateStudent(inputDto);
        BeanUtils.copyProperties(outputDto, student004Response);
        model.addAttribute("studentData", student004Response);
        return "/student/info";
    }

    /**
     * 学生情報編集
     *
     * @param id    ユーザID
     * @param model Model
     * @return ユーザー情報編集画面
     */
    @GetMapping("/student/edit")
    public String edit(String id, Model model) {
       Student004Response from = new Student004Response();

        // ユーザーサービス入力dtoを定義
       Student003InputDto inputDto = new Student003InputDto();
        inputDto.setId(id);
        //ユーザーサービスを呼び出し
        Student003OutputDto student003OutputDto = serviceEdit.searchchStudent(inputDto);
        List<StudentInfo> studentInfoListOut = student003OutputDto.getStudentInfoList();
        StudentInfo studentInfo = studentInfoListOut.get(0);
        BeanUtils.copyProperties(studentInfo, from);
        from.setId(studentInfo.getId());
        model.addAttribute("studentData", from);
        return "student/edit";
    }

}
