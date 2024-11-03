package com.example.baidoxe.service.impl;

import com.example.baidoxe.dto.PhuongTienDTO;
import com.example.baidoxe.mapper.PhuongTienMapper;
import com.example.baidoxe.models.PhuongTien;
import com.example.baidoxe.repository.PhuongTienRepository;
import com.example.baidoxe.service.PhuongTienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhuongTienServiceImpl implements PhuongTienService {
    @Autowired
    private PhuongTienRepository phuongTienRepository;
    @Autowired
    private PhuongTienMapper phuongTienMapper;

//    @Override
//    public List<PhuongTien> listPhuongTienUser() {
//        // Lấy danh sách PhuongTienDTO từ repository
//        List<PhuongTienDTO> phuongTiensDTO = phuongTienRepository.findPhuongTienActive();
//
//        // Chuyển đổi từ PhuongTienDTO sang PhuongTien (có thể cần một mapper để làm việc này)
//        return phuongTiensDTO.stream()
//                .map(phuongTienMapper::toPhuongTien) // Phương thức chuyển đổi từ DTO sang Entity
//                .collect(Collectors.toList());


    @Override
    public List<PhuongTienDTO> findPhuongTienUser() {
        return phuongTienRepository.findPhuongTienUser();
    }
}
