package com.example.studteath.controller;


import com.example.studteath.dto.*;
import com.example.studteath.modelform.*;
import com.example.studteath.service.USER003Service;
import com.example.studteath.service.UserService;
import com.example.studteath.util.Converter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.studteath.common.Constants.RESULT_CODE_SUCCESS;


/**
 * ユーザー情報一覧取得コントローラー
 */
@Controller
public class USER003Controller {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    USER003Service service;
    @Autowired
    protected MessageSource messageSource;

    /**
     * ユーザー情報検索
     *
     * @param user003Request リクエストデータ
     * @param model          Model
     * @return ユーザー情報一覧画面
     */
    @PostMapping("/user/search")
    public String search(@Validated @ModelAttribute USER003Request user003Request, Model model) {
        USER003Response from = new USER003Response();

        // ユーザーサービス入力dtoを定義
        USER003InputDto inputDto = new USER003InputDto();
        BeanUtils.copyProperties(user003Request, inputDto);
        //ユーザーサービスを呼び出し
        USER003OutputDto user003OutputDto = service.searAllchUser(inputDto);
        List<UserInfo> userInfoListOut = user003OutputDto.getUserInfoList();
        from.setUserInfoList(userInfoListOut);
        model.addAttribute("userinfolist", from.getUserInfoList());
        if (user003Request.getUserNo() != "") {
            model.addAttribute("userNo", user003Request.getUserNo());
        }
        if (user003Request.getPassWord() != "") {
            model.addAttribute("password", user003Request.getPassWord());
        }
        return "user/search";
    }
}
