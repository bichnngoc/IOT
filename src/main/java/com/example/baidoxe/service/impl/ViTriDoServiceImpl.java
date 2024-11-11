package com.example.baidoxe.service.impl;

import com.example.baidoxe.dto.ViTriDoDTO;
import com.example.baidoxe.mapper.ViTriDoMapper;
import com.example.baidoxe.models.ViTriDo;
import com.example.baidoxe.repository.ViTriDoRepository;
import com.example.baidoxe.service.ViTriDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViTriDoServiceImpl implements ViTriDoService {

    @Autowired
    ViTriDoRepository viTriDoRepository;

    @Autowired
    ViTriDoMapper viTriDoMapper;

    @Override
    public List<ViTriDoDTO> getActiveViTriDoByBaiDoId(Integer baiDoId) {
        List<ViTriDo> viTriDoList = viTriDoRepository.findActiveViTriDoByBaiDoId(baiDoId);
        return viTriDoList.stream()
                .map(viTriDoMapper::toViTriDoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ViTriDoDTO findViTriDoById(Integer Id) {
        Optional<ViTriDo> viTriDoOptional = viTriDoRepository.findById(Id);
        return viTriDoOptional.map(viTriDoMapper::toViTriDoDTO).orElse(null);
    }

    @Override
    public ViTriDoDTO ApdateStatus(Integer Id) {
        Optional<ViTriDo> viTriDoOptional= viTriDoRepository.findById(Id);
        if (viTriDoOptional.isPresent()){
            ViTriDo existingViTriDo = viTriDoOptional.get();
            //Cập nhật trạng thái vị trí đỗ làddaxđó Status(2)
            existingViTriDo.setStatus(2);
            viTriDoRepository.save(existingViTriDo);
        }else {
            throw new IllegalArgumentException("ViTriDo not found with ID: " + Id);
        }
        return null;
    }

    @Override
    public int countActiveViTriDoByBaiDoId(Integer baiDoId) {
        return viTriDoRepository.countByStatusAndBaiDoId(baiDoId);
    }


}
