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
import static com.example.studteath.common.Constants.VALIDATION_ERROR;


/**
 * ユーザーコントローラー
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
     * ユーザー情報検索画面を表示
     *
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping(value = "/user/search")
    public String displaySearch(Model model) {
        return "user/add";
    }

    /**
     * ユーザー情報検索
     *
     * @param user001SearchRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @PostMapping("/user/id_search")
    public String search(@Validated @ModelAttribute USER001SearchRequest user001SearchRequest, BindingResult bindingResult, Model model) {
        USER001ResponseForm from = new USER001ResponseForm();
            // ユーザーサービス入力dtoを定義
            USER001InputDto inputDto = new USER001InputDto();
            BeanUtils.copyProperties(user001SearchRequest, inputDto);
            //ユーザーサービスを呼び出し
//            USER001OutputDto outputDto = userService.search(inputDto);
//            BeanUtils.copyProperties(outputDto, from);
            model.addAttribute("userinfo", from);

        return "user/search";
    }

    /**
     * ユーザー情報登録
     *
     * @param user001AddRequest リクエストデータ
     * @param model Model
     * @return res
     */
    @PostMapping("/user/add")
    public String login(@Validated @ModelAttribute USER001AddRequest user001AddRequest, BindingResult bindingResult, Model model) {
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
        } else {
            // ユーザーサービス入力dtoを定義
            USER001InputDto inputDto = new USER001InputDto();
            inputDto.setUserNo(user001AddRequest.getUserNo());
            // フォームからパラメータを設定
            BeanUtils.copyProperties(user001AddRequest, inputDto);
//            inputDto.setId(Long.parseLong(user001AddRequest.getId()));
            //ユーザーサービスを呼び出し
            USER001OutputDto outputDto = userService.add(inputDto);
//            BeanUtils.copyProperties(outputDto, res);
//            model.addAttribute("userinfo", res);
        }

        return "user/search";
    }
}