package com.example.baidoxe.service;

import com.example.baidoxe.dto.NganHangDTO;
import com.example.baidoxe.dto.ViTriDoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ViTriDoService {
    List<ViTriDoDTO> listActiveViTriDo();
    int countByStatus();
}
