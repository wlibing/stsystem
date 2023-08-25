package com.example.studteath.controller;

import com.example.studteath.dto.*;
import com.example.studteath.entity.Staff;
import com.example.studteath.modelform.Staff003Request;
import com.example.studteath.modelform.Staff003Response;
import com.example.studteath.modelform.Student003Request;
import com.example.studteath.modelform.Student003Response;
import com.example.studteath.service.Staff003Service;
import com.example.studteath.service.Student003Service;
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
public class Staff003Controller {
    /**
     * 従業員情報 Service
     */
    @Autowired
    Staff003Service staff003Service;
    @Autowired
    protected MessageSource messageSource;

    /**
     * 従業員情報検索
     *
     * @param staff003Request リクエストデータ
     * @param model          Model
     * @return 従業員情報一覧画面
     */
    @PostMapping("/staff/search")
    public String search(@Validated @ModelAttribute Staff003Request staff003Request, Model model) {
        Staff003Response from = new Staff003Response();

        // ユーザーサービス入力dtoを定義
        Staff003InputDto inputDto = new Staff003InputDto();
        BeanUtils.copyProperties(staff003Request, inputDto);
        //ユーザーサービスを呼び出し
        Staff003OutputDto staff003OutputDto = staff003Service.searchchStaff(inputDto);
        List<StaffInfo> staffInfoListOut = staff003OutputDto.getStaffInfoList();
        from.setStaffInfoList(staffInfoListOut);
        model.addAttribute("staffinfolist", from.getStaffInfoList());
        if (staff003Request.getId() != "") {
            model.addAttribute("id", staff003Request.getId());
        }
        if (staff003Request.getName() != "") {
            model.addAttribute("name", staff003Request.getName());
        }
        return "staff/search";
    }
}
