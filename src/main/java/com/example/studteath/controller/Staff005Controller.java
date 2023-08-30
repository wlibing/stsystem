package com.example.studteath.controller;


import com.example.studteath.dto.*;
import com.example.studteath.modelform.Staff005Request;
import com.example.studteath.modelform.Staff005Response;
import com.example.studteath.service.Staff003Service;
import com.example.studteath.service.Staff005Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * 従業員情報更新コントローラー
 */
@Controller
public class Staff005Controller {
    /**
     * 従業員情報 Service
     */
    @Autowired
    Staff005Service service;

    /**
     * 従業員情報検索 Service
     */
    @Autowired
    Staff003Service serviceEdit;

    /**
     * 従業員情報更新
     *
     * @param staff005Request リクエストデータ
     * @param model          Model
     * @return 従業員情報一覧画面
     */
    @PostMapping("/staff/update")
    public String update(@Validated @ModelAttribute Staff005Request staff005Request, Model model) {
        Staff005Response staff005Response = new Staff005Response();
        Staff005InputDto inputDto = new Staff005InputDto();
        BeanUtils.copyProperties(staff005Request, inputDto);
        Staff005OutputDto outputDto = service.updateStaff(inputDto);
        BeanUtils.copyProperties(outputDto, staff005Response);
        model.addAttribute("staffData", staff005Response);
        return "/staff/info";
    }

    /**
     * 従業員情報編集
     *
     * @param id    ユーザID
     * @param model Model
     * @return 従業員情報編集画面
     */
    @GetMapping("/staff/edit")
    public String edit(String id, Model model) {
       Staff005Response from = new Staff005Response();

        // 従業員サービス入力dtoを定義
       Staff003InputDto inputDto = new Staff003InputDto();
        inputDto.setId(id);
        //ユーザーサービスを呼び出し
        Staff003OutputDto staff003OutputDto = serviceEdit.searchchStaff(inputDto);
        List<StaffInfo> staffInfoListOut = staff003OutputDto.getStaffInfoList();
        StaffInfo studentInfo = staffInfoListOut.get(0);
        BeanUtils.copyProperties(studentInfo, from);
        from.setId(studentInfo.getId());
        model.addAttribute("staffData", from);
        return "staff/edit";
    }

}
