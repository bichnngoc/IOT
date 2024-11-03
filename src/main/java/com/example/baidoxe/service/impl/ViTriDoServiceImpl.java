package com.example.baidoxe.service.impl;

import com.example.baidoxe.dto.ViTriDoDTO;
import com.example.baidoxe.repository.ViTriDoRepository;
import com.example.baidoxe.service.ViTriDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViTriDoServiceImpl implements ViTriDoService {

    @Autowired
    ViTriDoRepository viTriDoRepository;
    @Override
    public List<ViTriDoDTO> listActiveViTriDo() {
        return null;
    }

    @Override
    public int countByStatus() {
        int count=viTriDoRepository.countByStatus();
        return count;
    }
}
