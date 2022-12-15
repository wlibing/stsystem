package com.example.studteath.controller;

import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER002InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.entity.User;
import com.example.studteath.modelform.*;
import com.example.studteath.service.USER002Service;
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

import java.util.*;

import static com.example.studteath.common.Constants.RESULT_CODE_FAILD;

/**
 * ユーザー情報登録
 */
@Controller
public class USER002Controller {

    @Autowired
    protected MessageSource messageSource;
    @Autowired
    USER002Service user002Service;

    /**
     * ユーザー情報登録
     *
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @PostMapping(value = "/user/login")
    public String displaySearch(@Validated @ModelAttribute USER002Request user002Request, BindingResult bindingResult, Model model) {
        USER002LoginResponse res = new USER002LoginResponse();

        List<String> errorList = new ArrayList<>();
        //入力チェック
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorList.add(messageSource.getMessage(error.getField(), null,
                        Locale.getDefault()) + error.getDefaultMessage());
            }
            res.setResultCode(RESULT_CODE_FAILD);
            res.setErrorList(errorList);
            model.addAttribute("validationError", res.getErrorList());

        } else {
            USER002InputDto user002InputDto = new USER002InputDto();
            BeanUtils.copyProperties(user002Request, user002InputDto);
            UserInfo userInfo = user002Service.searchUser(user002InputDto);
            if (null == userInfo) {
                errorList.add("userNo or password is not true");
                model.addAttribute("validationError", errorList);
            } else {
                return "menu/menu";
            }
        }
        return "index";
    }

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

}
