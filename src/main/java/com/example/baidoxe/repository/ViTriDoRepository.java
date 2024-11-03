package com.example.baidoxe.repository;

import com.example.baidoxe.models.ViTriDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ViTriDoRepository extends JpaRepository<ViTriDo,Integer> {
    //Tong vi tri do
    @Query("SELECT COUNT (bd) FROM ViTriDo bd WHERE bd.Status=1 AND bd.baiDo.Id=2")
    int countByStatus();



}