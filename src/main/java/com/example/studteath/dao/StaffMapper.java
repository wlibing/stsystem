
package com.example.studteath.dao;

import com.example.studteath.entity.Staff;
import com.example.studteath.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 従業員情報 Mapper
 */
@Mapper
public interface StaffMapper {
    /**
     *従業員情報検索
     *
     * @return 従業員一覧情報
     */
    List<Staff> searchStaffList(Staff staff);


    /**
     *従業員情報詳細
     *
     * @return 従業員一覧情報
     */
    List<Staff> searchStaffs(Staff staff);

}
