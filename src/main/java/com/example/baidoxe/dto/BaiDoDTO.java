package com.example.baidoxe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaiDoDTO {
    private Integer Id;
    private String TenBaiDo;
    private String DiaChi;
    private String KinhDo;
    private String ViDo;
    private Integer Status;

    public BaiDoDTO(Integer Id, String TenBaiDo, String DiaChi, Integer Status, String KinhDo,String ViDo) {
        this.Id = Id;
        this.TenBaiDo = TenBaiDo;
        this.DiaChi = DiaChi;
        this.Status = Status;
        this.KinhDo=KinhDo;
        this.ViDo=ViDo;
    }
}

