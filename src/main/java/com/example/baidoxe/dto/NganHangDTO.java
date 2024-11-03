package com.example.baidoxe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NganHangDTO {
    private Integer Id;
    private String TenNganHang;
    private String SoTaiKhoan;
    private Integer Status;
}