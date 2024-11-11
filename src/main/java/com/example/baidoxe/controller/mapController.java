package com.example.baidoxe.controller;

import com.example.baidoxe.dto.BaiDoDTO;
import com.example.baidoxe.dto.DatChoDTO;
import com.example.baidoxe.dto.PhuongTienDTO;
import com.example.baidoxe.dto.ViTriDoDTO;
import com.example.baidoxe.models.BaiDo;
import com.example.baidoxe.models.PhuongTien;
import com.example.baidoxe.models.ViTriDo;
import com.example.baidoxe.repository.PhuongTienRepository;
import com.example.baidoxe.service.BaiDoService;
import com.example.baidoxe.service.DatChoService;
import com.example.baidoxe.service.PhuongTienService;
import com.example.baidoxe.service.ViTriDoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private DatChoService datChoService;

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
@GetMapping("/datcho/{Id}")
public String datChoAction(@PathVariable("Id") Integer Id, Model model) {
    BaiDoDTO baiDoDTO = baiDoService.findBaiDoById(Id);
    model.addAttribute("baiDo", baiDoDTO);

    int soLuongConTrong = viTriDoService.countActiveViTriDoByBaiDoId(Id);
    model.addAttribute("soLuongConTrong", soLuongConTrong);

    List<ViTriDoDTO> viTriDoDTOS = viTriDoService.getActiveViTriDoByBaiDoId(Id);
    model.addAttribute("ListViTriDo", viTriDoDTOS);

    List<PhuongTienDTO> phuongTienDTO = phuongTienService.findPhuongTienUser();
    model.addAttribute("bienSo", phuongTienDTO);

    return "map/khbaidoABCD"; // Đảm bảo rằng đây là tên chính xác của template Thymeleaf
}

    @PostMapping("/datcho/{Id}")
    public String datCho(@PathVariable("Id") Integer id,
                         @RequestParam("selectedVehicleId") Integer vehicleId,
                         @RequestParam("IdViTriDo") Integer viTriDoId,
                         @RequestParam("DangKyGioVao") String DangKyGioVao,
                         @RequestParam("DangKyGioRa") String DangKyGioRa) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        // Chuyển đổi chuỗi thành LocalDateTime
        LocalDateTime gioVao = LocalDateTime.parse(DangKyGioVao, formatter);
        LocalDateTime gioRa = LocalDateTime.parse(DangKyGioRa, formatter);


        // Tạo đối tượng DatChoDTO

        DatChoDTO datChoDTO = new DatChoDTO();
        datChoDTO.setPhuongTien_Id(vehicleId);
        datChoDTO.setViTriDo_Id(viTriDoId);
        datChoDTO.setDangKyGioVao(gioVao);
        datChoDTO.setDangKyGioRa(gioRa);

        ViTriDoDTO updateStatus = viTriDoService.ApdateStatus(viTriDoId);
        // Tạo mã QR cho đặt chỗ (Giả sử có một phương thức tạo mã QR)
        String qrCode = generateQRCode(datChoDTO);
        datChoDTO.setMaQR(qrCode);

        // Gọi Service để lưu thông tin đặt chỗ
        datChoService.addDatCho(datChoDTO);

        return "map/datcho-list"; // Đảm bảo trả về một view hợp lệ sau khi đặt chỗ
    }
    private String generateQRCode(DatChoDTO datChoDTO) {
        // Giả sử bạn có một phương thức để tạo mã QR từ thông tin đặt chỗ
        // Tạo mã QR từ thông tin đặt chỗ (ví dụ: vehicleId, viTriDoId, giờ vào, giờ ra)
        return "QR_" + datChoDTO.getViTriDo_Id() + "_" + datChoDTO.getPhuongTien_Id();
    }

}
