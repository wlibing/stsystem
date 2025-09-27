package com.example.studteath.controller;

import com.example.studteath.dto.*;
import com.example.studteath.entity.Director;
import com.example.studteath.modelform.Director003Request;
import com.example.studteath.modelform.Director003Response;
import com.example.studteath.modelform.Staff003Request;
import com.example.studteath.modelform.Staff003Response;
import com.example.studteath.service.Director003Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Director003Controller {
    /**
     * 主任情報 Service
     */
    @Autowired
    Director003Service director003Service;
    @Autowired
    protected MessageSource messageSource;

    /**
     * 主任情報検索
     *
     * @param director003Request リクエストデータ
     * @param model          Model
     * @return 主任情報一覧画面
     */
    @PostMapping("/director/search")
    public String director(@Validated @ModelAttribute Director003Request director003Request, Model model) {
        Director003Response from = new Director003Response();

        // ユーザーサービス入力dtoを定義
        Director003InputDto inputDto = new Director003InputDto();
        BeanUtils.copyProperties(director003Request, inputDto);
        //ユーザーサービスを呼び出し
        Director003OutputDto  director003OutputDto = director003Service.searchDirector(inputDto);
        List<DirectorInfo> directorInfoListOut = director003OutputDto.getDirsectorInfoList();
        from.setDirectorInfoList(directorInfoListOut);
        model.addAttribute("directorinfolist", from.getDirectorInfoList());
        if (director003Request.getId() != "") {
            model.addAttribute("id", director003Request.getId());
        }
        if (director003Request.getName() != "") {
            model.addAttribute("name", director003Request.getName());
        }
        return "director/search";
    }
}
