package com.example.studteath.controller;

import com.example.studteath.dto.*;
import com.example.studteath.entity.Student;
import com.example.studteath.modelform.Student004Response;
import com.example.studteath.modelform.USER004Response;
import com.example.studteath.service.Student003Service;
import com.example.studteath.service.USER003Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {
    //ラジオボタン用変数
    private Map<String, String> radioMarriage;

    /**
     * ユーザー情報 Service
     */
    @Autowired
    USER003Service service;
    @Autowired
    Student003Service student003Service;


    /**
     * ユーザー情報検索 Service
     */
    @Autowired
    USER003Service serviceEdit;

    @Autowired
    Student003Service StudentServiceEdit;
    //ラジオボタン初期化
    private Map<String, String> initRadioMarrige() {

        Map<String, String> radio = new LinkedHashMap<>();

        // 管理者、従業員、学生をMapに格納
        radio.put("管理者", "0");
        radio.put("従業員", "1");
        radio.put("学生", "2");

        return radio;
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "/index";
    }

    @RequestMapping("/signup")
    public String sign(Model model) {
        // ラジオボタンの初期化メソッド呼び出し
        radioMarriage = initRadioMarrige();

        // ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage);

        // signup.htmlに画面遷移

        return "/user/signup";
    }

    @RequestMapping("/searchUser")
    public String searchUser(Model model) {
        USER003OutputDto out = service.searAllchUser(new USER003InputDto());
        model.addAttribute("userinfolist", out.getUserInfoList());
        return "user/search";
    }
    @RequestMapping("/searchStudent")
    public String searchTeacher(Model model) {
        Student003OutputDto out = student003Service.searAllchStudent(new Student003InputDto());
        model.addAttribute("studentinfolist", out.getStudentInfoList());
        return "student/search";
    }
    @GetMapping("/user/info")
    public String userInfo(String id,Model model) {
        USER004Response from = new USER004Response();

        // ユーザーサービス入力dtoを定義
        USER003InputDto inputDto = new USER003InputDto();
        inputDto.setId(id);
        //ユーザーサービスを呼び出し
        USER003OutputDto user003OutputDto = serviceEdit.searAllchUser(inputDto);
        List<UserInfo> userInfoListOut = user003OutputDto.getUserInfoList();
        UserInfo userInfo = userInfoListOut.get(0);
        BeanUtils.copyProperties(userInfo, from);
        from.setId(userInfo.getId().toString());
        model.addAttribute("userData", from);
        return "user/info";
    }
    @GetMapping("/student/info")
    public String studentInfo(String id,Model model) {
        Student004Response from = new Student004Response();

        // 学生サービス入力dtoを定義
        Student003InputDto inputDto = new Student003InputDto();
        inputDto.setId(id);
        //学生サービスを呼び出し
        Student003OutputDto student003OutputDto = StudentServiceEdit.searAllchStudent(inputDto);
        List<StudentInfo> studentInfoListOut = student003OutputDto.getStudentInfoList();
        StudentInfo studentInfo = studentInfoListOut.get(0);
        BeanUtils.copyProperties(studentInfo, from);
        from.setId(studentInfo.getId());
        model.addAttribute("studentData", from);
        return "student/info";
    }
}
