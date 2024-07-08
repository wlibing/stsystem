package com.example.studteath.repository;

import com.example.studteath.dao.StaffMapper;
import com.example.studteath.dto.*;
import com.example.studteath.entity.Staff;

import com.example.studteath.util.Converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 従業員情報 リポジトリ
 */
@Repository
public class Staff006Repository {
    /**
     * 従業員情報 Mapper
     */
    @Autowired
    private StaffMapper saffMapper;

    /**
     * 従業員削除
     *
     * @return 検索結果
     */
    public Staff006OutputDto delete(Staff006InputDto inputDto) {
        String id=inputDto.getId();
        Integer addNum=saffMapper.delete(Integer.parseInt(id));
        Staff006OutputDto staff006OutputDto=new Staff006OutputDto();

        if (addNum >0){
            Staff staff = new Staff();
            staff.setDisableFlag("1");
            List<Staff> staffList = saffMapper.searchStaffList(staff);
            List<StaffInfo> staffInfoList=new ArrayList<>();
            if (staffList.size()>0){
                for (Staff s:staffList){
                    StaffInfo staffInfo =new StaffInfo();
                    BeanUtils.copyProperties(s,staffInfo);
                    staffInfoList.add(staffInfo);
                }
                staff006OutputDto.setStaffInfoList(staffInfoList);
            }
        }
        return staff006OutputDto;
    }

}
