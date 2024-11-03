package com.example.baidoxe.repository;

import com.example.baidoxe.dto.NganHangDTO;
import com.example.baidoxe.dto.PhuongTienDTO;
import com.example.baidoxe.models.BaiDo;
import com.example.baidoxe.models.NganHang;
import com.example.baidoxe.models.PhuongTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PhuongTienRepository extends JpaRepository<PhuongTien, Integer>
{
    Optional<PhuongTien> findById(Integer Id);

    @Query("SELECT new com.example.baidoxe.dto.PhuongTienDTO(" +
            "pt.Id, pt.LoaiPhuongTien,pt.Hang,pt.BienSo,pt.Status) " +
            "FROM PhuongTien pt " +
            "JOIN Users u ON u.Id = pt.users.Id " + // thêm khoảng trắng sau User_Id
            "WHERE pt.Status = 1 AND u.Id=1")
    List<PhuongTienDTO> findPhuongTienUser();


}
