package com.example.baidoxe.mapper;

import com.example.baidoxe.dto.PhuongTienDTO;
import com.example.baidoxe.models.PhuongTien;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class PhuongTienMapper {
    // Chuyển đổi từ PhuongTienDTO sang PhuongTien
    public PhuongTien toPhuongTien(PhuongTienDTO dto) {
        if (dto == null) {
            return null; // Kiểm tra null để tránh NullPointerException
        }

        PhuongTien phuongTien = new PhuongTien();
        phuongTien.setId(dto.getId());
        phuongTien.setBienSo(dto.getBienSo());
        phuongTien.setHang(dto.getHang());
        phuongTien.setLoaiPhuongTien(dto.getLoaiPhuongTien());
        phuongTien.setStatus(dto.getStatus());

        // Nếu có các thuộc tính khác trong PhuongTien, thêm vào đây
        return phuongTien;
    }

    // Chuyển đổi từ PhuongTien sang PhuongTienDTO
    public PhuongTienDTO toPhuongTienDTO(PhuongTien entity) {
        if (entity == null) {
            return null; // Kiểm tra null để tránh NullPointerException
        }

        PhuongTienDTO dto = new PhuongTienDTO();
        dto.setId(entity.getId());
        dto.setBienSo(entity.getBienSo());
        dto.setHang(entity.getHang());
        dto.setLoaiPhuongTien(entity.getLoaiPhuongTien());
        dto.setStatus(entity.getStatus());

        // Nếu có các thuộc tính khác trong PhuongTienDTO, thêm vào đây
        return dto;
    }

}