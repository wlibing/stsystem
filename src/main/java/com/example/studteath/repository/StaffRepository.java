package com.example.studteath.repository;

import com.example.studteath.dao.StaffMapper;
import com.example.studteath.dao.StudentMapper;
import com.example.studteath.dto.Staff003InputDto;
import com.example.studteath.dto.StaffInfo;
import com.example.studteath.dto.Student003InputDto;
import com.example.studteath.dto.StudentInfo;
import com.example.studteath.entity.Staff;
import com.example.studteath.entity.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffRepository {
    /**
     * 従業員情報 Mapper
     */
    @Autowired
    private StaffMapper staffMapper;

/**
 *従業員一覧情報検索
 *
 * @return 検索結果
 */
public List<StaffInfo> searchAllStaff(Staff003InputDto staff003InputDto) {
    List<StaffInfo> staffInfoList=new ArrayList<>();
    Staff staffSearch = new Staff();
    String id = staff003InputDto.getId();
    String name = staff003InputDto.getName();
    Long staffId = null;
    if (id != "" && id != null){
       staffId = Long.parseLong(id);
        staffSearch.setId(staffId);
    } if (name != "" && name != null){
        staffSearch.setName(name);
    }

    staffSearch.setDisableFlag("1");
    List<Staff> staffs = staffMapper.searchStaffList(staffSearch);
    if (staffs.size()>0){
        for (Staff staff: staffs){
            StaffInfo staffInfo = new StaffInfo();
            BeanUtils.copyProperties(staff, staffInfo);
            staffInfoList.add(staffInfo);
        }
    }
    return staffInfoList;
}

}
