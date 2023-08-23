package com.example.studteath.controller;


import com.example.studteath.dto.*;
import com.example.studteath.modelform.USER004Request;
import com.example.studteath.modelform.USER004Response;
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

import java.util.Date;
import java.util.List;


/**
 * ユーザー情報更新コントローラー
 */
@Controller
public class USER004Controller {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    USER004Service service;

    /**
     * ユーザー情報検索 Service
     */
    @Autowired
    USER003Service serviceEdit;

    /**
     * ユーザー情報更新
     *
     * @param user004Request リクエストデータ
     * @param model          Model
     * @return ユーザー情報一覧画面
     */
    @PostMapping("/user/update")
    public String update(@Validated @ModelAttribute USER004Request user004Request, Model model) {
        USER004Response user004Response = new USER004Response();
        USER004InputDto inputDto = new USER004InputDto();
        BeanUtils.copyProperties(user004Request, inputDto);
        USER004OutputDto outputDto = service.updateUser(inputDto);
        BeanUtils.copyProperties(outputDto, user004Response);
        model.addAttribute("userData", user004Response);
        return "/user/info";
    }

    /**
     * ユーザー情報編集
     *
     * @param id    ユーザID
     * @param model Model
     * @return ユーザー情報編集画面
     */
    @GetMapping("/user/edit")
    public String edit(String id, Model model) {
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
        return "user/edit";
    }

}
