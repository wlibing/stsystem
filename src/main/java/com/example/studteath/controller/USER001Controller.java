package com.example.studteath.controller;


import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER001OutputDto;
import com.example.studteath.modelform.USER001AddRequest;
import com.example.studteath.modelform.USER001AddResponse;
import com.example.studteath.modelform.USER001ResponseForm;
import com.example.studteath.modelform.USER001SearchRequest;
import com.example.studteath.service.UserService;
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
 * ユーザー情報登録コントローラー
 */
@Controller
public class USER001Controller {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    UserService userService;
    @Autowired
    protected MessageSource messageSource;

    /**
     * ユーザー情報新規登録
     *
     * @param user001AddRequest リクエストデータ
     * @param model Model
     * @return res
     */
    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute USER001AddRequest user001AddRequest, BindingResult bindingResult, Model model) {
        USER001AddResponse res = new USER001AddResponse();
        // 入力チェック
        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            // エラーメッセージを設定する
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorList.add(messageSource.getMessage(error.getField(), null,
                        Locale.getDefault()) + error.getDefaultMessage());
            }
            res.setResultCode(RESULT_CODE_SUCCESS);
            res.setErrorList(errorList);
            model.addAttribute("errorList", errorList);
            return "user/signup";
        } else {
            // ユーザーサービス入力dtoを定義
            USER001InputDto inputDto = new USER001InputDto();
            // フォームからパラメータを設定
            BeanUtils.copyProperties(user001AddRequest, inputDto);
            //ユーザーサービスを呼び出し
            USER001OutputDto outputDto = userService.addUser(inputDto);
            model.addAttribute("userinfolist", outputDto.getUserInfoList());
            return "user/search";
        }
    }
}
