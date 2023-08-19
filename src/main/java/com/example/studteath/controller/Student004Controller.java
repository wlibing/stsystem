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

        Long id = student004Request.getId();
        Long userId = student004Request.getUserId();
        String staffId = student004Request.getStaffId();
        String tel = student004Request.getTel();
        String maileAddress = student004Request.getMaileAddress();
        String guardianTel = student004Request.getGuardianTel();
        String guardianMaileAddress = student004Request.getGuardianMaileAddress();
        String guardianName = student004Request.getGuardianName();
        String name = student004Request.getName();
        String age =  student004Request.getAge();
        String sex = student004Request.getSex();
        String grade = student004Request.getGrade();
        String studentClass = student004Request.getStudentClass();
        String disableFlag = student004Request.getDisableFlag();
        LocalDateTime dateTime = LocalDateTime.now();
        inputDto.setAge(age);
        inputDto.setName(name);
        inputDto.setSex(sex);
        inputDto.setGrade(grade);
        inputDto.setStudentClass(studentClass);
        inputDto.setDisableFlag(disableFlag);
        inputDto.setId(id);
        inputDto.setUserId(userId);
        inputDto.setStaffId(staffId);
        inputDto.setTel(tel);
        inputDto.setMaileAddress(maileAddress);
        inputDto.setGuardianTel(guardianTel);
        inputDto.setGuardianMaileAddress(guardianMaileAddress);
        inputDto.setGuardianName(guardianName);
        inputDto.setDisableFlag(disableFlag);
        Student004OutputDto outputDto = service.updateStudent(inputDto);
        Long studentId = outputDto.getId();
        Long userId2 = outputDto.getUserId();
        String staffId2 = outputDto.getStaffId();
        String tel2 = outputDto.getTel();
        String maileAddress2 = outputDto.getMaileAddress();
        String guardianTel2 = outputDto.getGuardianTel();
        String guardianMaileAddress2 = outputDto.getGuardianMaileAddress();
        String guardianName2 = outputDto.getGuardianName();
        String name2 = outputDto.getName();
        String age2 = outputDto.getAge();
        String sex2 = outputDto.getSex();
        String grade2 = outputDto.getGrade();
        String studentClass2 = outputDto.getStudentClass();
        String disableFlag2 =outputDto.getDisableFlag();
        student004Response.setName(name2);
        student004Response.setAge(age2);
        student004Response.setSex(sex2);
        student004Response.setGrade(grade2);
        student004Response.setStudentClass(studentClass2);
        student004Response.setDisableFlag(disableFlag2);
        student004Response.setId(studentId);
        student004Response.setUserId(userId2);
        student004Response.setStaffId(staffId2);
        student004Response.setTel(tel2);
        student004Response.setMaileAddress(maileAddress2);
        student004Response.setGuardianTel(guardianTel2);
        student004Response.setGuardianMaileAddress(guardianMaileAddress2);
        student004Response.setGuardianName(guardianName2);

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
        Student003OutputDto student003OutputDto = serviceEdit.searAllchStudent(inputDto);
        List<StudentInfo> studentInfoListOut = student003OutputDto.getStudentInfoList();
        StudentInfo studentInfo = studentInfoListOut.get(0);
        BeanUtils.copyProperties(studentInfo, from);
        from.setId(studentInfo.getId());
        model.addAttribute("studentData", from);
        return "student/edit";
    }

}
