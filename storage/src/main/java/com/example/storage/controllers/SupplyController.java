package com.example.storage.controllers;

import com.example.storage.entities.Supply;
import com.example.storage.services.SupplyService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplies")
public class SupplyController {
    private final SupplyService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Supply createSupply(@RequestBody Supply supply) {
        return service.createSupply(supply);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getSupplyById(id), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Supply updateSupply(@RequestBody Supply supply) {
        return service.updateSupply(supply);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSupplyById(@PathVariable Long id) {
        service.deleteSupplyById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}/count")
    public Integer getCountFreeSupply(@PathVariable String name) {
        return service.getCountFreeSupply(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}/first_free")
    public Supply getFirstFreeSupplyByName(@PathVariable String name) {
        return service.getFirstFreeSupplyByName(name);
    }
}
