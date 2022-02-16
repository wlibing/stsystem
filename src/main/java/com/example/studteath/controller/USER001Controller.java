package com.example.studteath.controller;


import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER001OutputDto;
import com.example.studteath.modelform.USER001ResponseForm;
import com.example.studteath.modelform.USER001SearchRequest;
import com.example.studteath.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
    /**
     * ユーザー情報検索画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping(value = "/user/search")
    public String displaySearch(Model model) {
        return "user/search";
    }
    /**
     * ユーザー情報検索
     * @param user001SearchRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @PostMapping("/user/id_search")
    public String search(@Validated @ModelAttribute USER001SearchRequest user001SearchRequest, BindingResult bindingResult,Model model) {
        USER001ResponseForm from = new USER001ResponseForm();
        // 入力チェック
        if(bindingResult.hasErrors()){
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
        }else {
            // ユーザーサービス入力dtoを定義
            USER001InputDto inputDto=new USER001InputDto();
            // フォームからパラメータを設定
            inputDto.setId( Long.parseLong(user001SearchRequest.getId()));
            //ユーザーサービスを呼び出し
            USER001OutputDto outputDto = userService.search(inputDto);

            from.setName(outputDto.getName());
            from.setAddress(outputDto.getAddress());
            from.setPhone(outputDto.getPhone());
            BeanUtils.copyProperties(from,outputDto);
            model.addAttribute("userinfo", from);
        }

        return "user/search";
    }
}