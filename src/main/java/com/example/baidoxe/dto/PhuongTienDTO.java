package com.example.baidoxe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhuongTienDTO {
    private Integer Id;
    private String LoaiPhuongTien;
    private String Hang;
    private String BienSo;
    private Integer Status;

//    public PhuongTienDTO(Integer Id, String loaiPhuongTien,String Hang, String bienSo,Integer Status) {
//        this.LoaiPhuongTien =loaiPhuongTien;
//        this.BienSo =bienSo;
//        this.Id =Id;
//        this.Hang =Hang;
//        this.Status =Status;
//    }
}
