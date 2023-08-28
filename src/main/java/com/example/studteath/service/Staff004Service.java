package com.example.studteath.service;

import com.example.studteath.dto.Staff003InputDto;
import com.example.studteath.dto.Staff003OutputDto;
import com.example.studteath.dto.StaffInfo;
import com.example.studteath.repository.Staff004Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 従業員情報 Service
 */
@Service
public class Staff004Service {
    /**
     * 従業員情報 リポジトリ
     */
    @Autowired
private Staff004Repository staff004Repository;
    /**従業員覧情報詳細
     *
     * @return 検索結果
     */
    public Staff003OutputDto searchStaffs(Staff003InputDto inputDto){
        Staff003OutputDto outputDto = new Staff003OutputDto();
        List<StaffInfo> staffInfoList = staff004Repository.searchStaffs(inputDto);
        outputDto.setStaffInfoList(staffInfoList);
        return outputDto;

    }

}
