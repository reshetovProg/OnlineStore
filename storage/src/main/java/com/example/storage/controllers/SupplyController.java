package com.example.storage.controllers;

import com.example.storage.entities.Supply;
import com.example.storage.services.SupplyService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplies")
public class SupplyController {
    private final SupplyService service;

    @PostMapping
    public Supply createSupply(@RequestBody Supply supply) {
        return service.createSupply(supply);
    }

    @GetMapping("/{id}")
    public Supply getSupplyById(@PathVariable Long id) {
        return service.getSupplyById(id);
    }

    @PutMapping
    public Supply updateSupply(@RequestBody Supply supply) {
        return service.updateSupply(supply);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplyById(@PathVariable Long id) {
        service.deleteSupplyById(id);
    }

    @GetMapping("/{name}/count")
    public Integer getCountFreeSupply(@PathVariable String name) {
        return service.getCountFreeSupply(name);
    }

    @GetMapping("/{name}/first_free")
    public Supply getFirstFreeSupplyByName(@PathVariable String name) {
        return service.getFirstFreeSupplyByName(name);
    }
}
