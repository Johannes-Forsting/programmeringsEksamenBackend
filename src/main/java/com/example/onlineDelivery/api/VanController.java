package com.example.onlineDelivery.api;


import com.example.onlineDelivery.DTO.van.VanResponse;
import com.example.onlineDelivery.service.VanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/vans")
public class VanController {

    VanService vanService;

    public VanController(VanService vanService){
        this.vanService = vanService;
    }


    @GetMapping
    public List<VanResponse> getAllVans(){
        return vanService.findAllVans();
    }

    @GetMapping("/{id}")
    public VanResponse getVanById(@PathVariable Integer id){
        return vanService.getVanById(id);
    }


}
