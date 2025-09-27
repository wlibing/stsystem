package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主任情報 Service
 */
@Service
public class Director003Service {
    /**
     * 主任情報 リポジトリ
     */
    @Autowired
private DirectorRepository directorRepository;
    /**主任覧情報検索
     *
     * @return 検索結果
     */
    public Director003OutputDto searchDirector(Director003InputDto inputDto){
        Director003OutputDto outputDto = new Director003OutputDto();
        List<DirectorInfo> directorInfoList = directorRepository.searchAllDirector(inputDto);
        outputDto.setDirsectorInfoList(directorInfoList);
        return outputDto;

    }

}
