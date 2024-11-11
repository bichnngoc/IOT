package com.example.baidoxe.service;

import com.example.baidoxe.dto.ViTriDoDTO;

import java.util.List;

public interface ViTriDoService {
    List<ViTriDoDTO> getActiveViTriDoByBaiDoId(Integer baiDoId);
    ViTriDoDTO findViTriDoById(Integer Id);
    ViTriDoDTO ApdateStatus(Integer Id);
    int countActiveViTriDoByBaiDoId(Integer baiDoId);
}
