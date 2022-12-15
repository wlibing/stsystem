package com.example.studteath.controller;


import com.example.studteath.dto.*;
import com.example.studteath.modelform.USER003Request;
import com.example.studteath.modelform.USER003Response;
import com.example.studteath.service.USER003Service;
import com.example.studteath.service.USER005Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * ユーザー情報削除コントローラー
 */
@Controller
public class USER005Controller {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    USER005Service service;
    @Autowired
    protected MessageSource messageSource;

    /**
     * ユーザー削除
     *
     * @param id リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("/user/delete")
    public String delete(String id, Model model) {
        // ユーザーサービス入力dtoを定義
        USER005InputDto inputDto = new USER005InputDto();
        inputDto.setId(id);
        //ユーザーサービスを呼び出し
        USER005OutputDto user005OutputDto = service.delete(inputDto);
        model.addAttribute("userinfolist", user005OutputDto.getUserInfoList());
        return "user/search";
    }
}
