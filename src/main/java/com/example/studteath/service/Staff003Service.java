package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.entity.Staff;
import com.example.studteath.repository.StaffRepository;
import com.example.studteath.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 従業員情報 Service
 */
@Service
public class Staff003Service {
    /**
     * 従業員情報 リポジトリ
     */
    @Autowired
private StaffRepository staffRepository;
    /**従業員覧情報検索
     *
     * @return 検索結果
     */
    public Staff003OutputDto searchchStaff(Staff003InputDto inputDto){
        Staff003OutputDto outputDto = new Staff003OutputDto();
        List<StaffInfo> staffInfoList = staffRepository.searchAllStaff(inputDto);
        outputDto.setStaffInfoList(staffInfoList);
        return outputDto;

    }

}
