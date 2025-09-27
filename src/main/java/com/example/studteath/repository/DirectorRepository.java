package com.example.studteath.repository;

import com.example.studteath.dao.DirectorMapper;
import com.example.studteath.dto.Director003InputDto;
import com.example.studteath.dto.DirectorInfo;
import com.example.studteath.entity.Director;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DirectorRepository {
    /**
     * 主任情報 Mapper
     */
    @Autowired
    private DirectorMapper directorMapper;

/**
 *主任一覧情報検索
 *
 * @return 検索結果
 */
public List<DirectorInfo> searchAllDirector(Director003InputDto director003InputDto) {
    List<DirectorInfo> directorInfoList=new ArrayList<>();
    Director directorSearch = new Director();
    String id = director003InputDto.getId();
    String name = director003InputDto.getName();
    Long directorId = null;
    if (id != "" && id != null){
        directorId = Long.parseLong(id);
        directorSearch.setId(directorId);
    } if (name != "" && name != null){
        directorSearch.setName(name);
    }

    directorSearch.setDisableFlag("1");
    List<Director> directors = directorMapper.searchDirectorList(directorSearch);
    if (directors.size()>0){
        for (Director director: directors){
            DirectorInfo directorInfo = new DirectorInfo();
            BeanUtils.copyProperties(director, directorInfo);
            directorInfoList.add(directorInfo);
        }
    }
    return directorInfoList;
}

}
