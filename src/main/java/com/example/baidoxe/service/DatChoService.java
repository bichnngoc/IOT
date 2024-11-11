package com.example.baidoxe.service;

import com.example.baidoxe.dto.DatChoDTO;

public interface DatChoService {
    DatChoDTO finDatChoById(Integer Id);
    DatChoDTO addDatCho(DatChoDTO datChoDTO);
}
