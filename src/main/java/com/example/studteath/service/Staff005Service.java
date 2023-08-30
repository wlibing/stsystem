package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.repository.Staff005Repository;
import com.example.studteath.repository.Student004Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 従業員更新 Service
 */
@Service
public class Staff005Service {
    /**
     * 従業員更新 リポジトリ
     */
    @Autowired
    private Staff005Repository staff005Repository;

    /**
     * 従業員一覧情報検索
     *
     * @return 検索結果
     */
    public Staff005OutputDto updateStaff(Staff005InputDto inputDto) {
        Staff005OutputDto outputDto = new Staff005OutputDto();
        StaffInfo info = staff005Repository.searchstaff(inputDto);
        BeanUtils.copyProperties(info, outputDto);
        LocalDateTime updateDate = info. getUpdateDate();
        outputDto.setUpdateDate(updateDate);
        return outputDto;
    }


}
