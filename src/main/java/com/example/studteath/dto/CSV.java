package com.example.studteath.dto;

import lombok.Data;

import java.util.List;
@Data
public class CSV {
    List<Integer> id;

    List<Integer> categoryId;

    List<String> adminName;

    List<String> assetName;

    List<String> remarks;
}
