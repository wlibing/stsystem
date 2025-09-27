package com.example.studteath.dao;


import com.example.studteath.entity.Director;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 練習検索情報 Mapper
 */
@Mapper
public interface DirectorMapper {
    /**
     *主任情報検索
     *
     * @return 主任一覧情報
     */
    List<Director> searchDirectorList(Director director);
}
