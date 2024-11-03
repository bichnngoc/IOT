package com.example.baidoxe.controller;

import com.example.baidoxe.dto.BaiDoDTO;
import com.example.baidoxe.dto.PhuongTienDTO;
import com.example.baidoxe.dto.ViTriDoDTO;
import com.example.baidoxe.models.BaiDo;
import com.example.baidoxe.models.PhuongTien;
import com.example.baidoxe.repository.PhuongTienRepository;
import com.example.baidoxe.service.BaiDoService;
import com.example.baidoxe.service.PhuongTienService;
import com.example.baidoxe.service.ViTriDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/map")
public class mapController {

    @Autowired
    private BaiDoService baiDoService;
    @Autowired
    private ViTriDoService viTriDoService;
    @Autowired
    private PhuongTienService phuongTienService;


    @GetMapping("/list")
    public String listBaiDo(Model model) {
        // Fetch the list of BaiDo from the repository
        List<BaiDoDTO> baiDoListDTO = baiDoService.findActiveBaiDo();
        // Add the list to the model with the key 'listBaiDo'
        model.addAttribute("listBaiDo", baiDoListDTO);
        return "map/map";  // No need for .html, Thymeleaf resolves it automatically
    }
/*    @GetMapping("/datChoView")
    public String datChoView(Model model) {
        // Fetch the list of BaiDo from the repository
        List<BaiDoDTO> baiDoListDTO = baiDoService.listActiveBaiDo();
        // Add the list to the model with the key 'listBaiDo'
        model.addAttribute("listBaiDo", baiDoListDTO);
        return "map/khbaidoABCD";  // No need for .html, Thymeleaf resolves it automatically
    }*/
    @GetMapping("/datcho/{id}")
    public String datChoAction(@PathVariable("id") int Id, Model model)
    {
        int IdUser=1;

        BaiDoDTO baiDoDTO=baiDoService.findBaiDoById(Id);
        model.addAttribute("baiDo",baiDoDTO);
        int soLuongConTrong=viTriDoService.countByStatus();
        model.addAttribute("soLuongConTrong",soLuongConTrong);
        List<PhuongTienDTO> phuongTienDTO=phuongTienService.findPhuongTienUser();
        model.addAttribute("bienSo",phuongTienDTO);
        return "map/khbaidoABCD";
    }

}
