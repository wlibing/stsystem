package com.example.studteath.repository;

import com.example.studteath.dao.StaffMapper;
import com.example.studteath.dao.StudentMapper;
import com.example.studteath.dto.*;
import com.example.studteath.entity.Staff;
import com.example.studteath.entity.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 従業員更新 リポジトリ
 */
@Repository
public class Staff005Repository {
    /**
     * 従業員 Mapper
     */
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private StaffRepository staffRepository;
    /**
     * 従業員更新
     * @param inputDto
     * @return 検索結果
     */
    public StaffInfo searchstaff(Staff005InputDto inputDto) {
        StaffInfo staffInfo = new StaffInfo();
        Staff staff = new Staff();
        BeanUtils.copyProperties(inputDto, staff);
       LocalDateTime dateTime = LocalDateTime.now();
        staff.setUpdateDate(dateTime);
        Integer integer = staffMapper.updateStaffs(staff);
        if (integer > 0 ){
            Staff003InputDto staff003InputDto = new Staff003InputDto();
            staff003InputDto.setId(inputDto.getId().toString());
            List<StaffInfo> list = staffRepository.searchAllStaff(staff003InputDto);
            staffInfo = list.get(0);

        }
              return staffInfo;


    }
}
