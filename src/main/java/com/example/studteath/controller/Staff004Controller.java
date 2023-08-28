package com.example.studteath.controller;

import com.example.studteath.dto.*;
import com.example.studteath.modelform.Staff004Response;
import com.example.studteath.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Staff004Controller {

    /**
     * 従業員情報 Service
     */
    @Autowired
    Staff004Service service;

    @GetMapping("/staff/info")
    public String staffInfo(String id,Model model) {
        Staff004Response from = new Staff004Response();

        // 学生サービス入力dtoを定義
        Staff003InputDto inputDto = new Staff003InputDto();
        inputDto.setId(id);
        //学生サービスを呼び出し
        Staff003OutputDto staff003OutputDto = service.searchStaffs(inputDto);
        List<StaffInfo> staffInfoListOut = staff003OutputDto.getStaffInfoList();
        StaffInfo staffInfo = staffInfoListOut.get(0);
        BeanUtils.copyProperties(staffInfo, from);
        from.setId(staffInfo.getId());
        model.addAttribute("staffData", from);
        return "staff/info";
    }
}
