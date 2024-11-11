package com.example.baidoxe.repository;

import com.example.baidoxe.models.ViTriDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViTriDoRepository extends JpaRepository<ViTriDo,Integer> {
    //Tong vi tri do
    Optional<ViTriDo> findById(Integer Id);
    // Count active ViTriDo by baiDoId
    @Query("SELECT COUNT(bd) FROM ViTriDo bd WHERE bd.Status = 1 AND bd.baiDo.Id = :baiDoId")
    int countByStatusAndBaiDoId(@Param("baiDoId") Integer baiDoId);
    @Query("SELECT bd FROM ViTriDo bd WHERE bd.Status = 1 AND bd.baiDo.Id = :baiDoId")
    List<ViTriDo> findActiveViTriDoByBaiDoId(@Param("baiDoId") Integer baiDoId);
}