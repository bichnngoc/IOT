//package com.example.baidoxe.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/login")
//
//public class loginController {
//    @Autowired
//    private loginController login;
//
//    @GetMapping("/login")
//    public String listNganHang(Model model) {
//        List<NganHangDTO> NganHangListDTO = nganHangService.listActiveNganHang();
//        model.addAttribute("listNganHang", NganHangListDTO);
//        return "nganhang-list";
//    }
//}
