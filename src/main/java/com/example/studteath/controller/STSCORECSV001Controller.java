package com.example.studteath.controller;


import com.example.studteath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 学生成績コントローラー
 */
@Controller
public class STSCORECSV001Controller {
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
    @GetMapping(value = "/student/search")
    public String displaySearch(Model model) {
        return "student/csv";
    }

    /**
     * ユーザー情報検索
     *
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @PostMapping(value = "/student/csv", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
            + "; charset=UTF-8; Content-Disposition: attachment")
    @ResponseBody
    public Object csv(Model model) {
//            List<USER001OutputDto> outputDto = userService.searchAll();

        return "user/search";
    }

}
