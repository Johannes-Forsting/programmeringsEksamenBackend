package com.example.onlineDelivery.service;

import com.example.onlineDelivery.DTO.van.VanResponse;
import com.example.onlineDelivery.entity.Van;
import com.example.onlineDelivery.repositories.VanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VanService {
    VanRepository vanRepository;

    public VanService(VanRepository vanRepository){
        this.vanRepository = vanRepository;
    }
    public List<VanResponse> findAllVans() {
        List<Van> vans = vanRepository.findAll();
        return vans.stream().map(van -> new VanResponse(van)).toList();
    }

    public VanResponse getVanById(Integer id) {
        Van van = vanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Van with this id: " + id + " could not be found"));
        return new VanResponse(van);
    }
}
