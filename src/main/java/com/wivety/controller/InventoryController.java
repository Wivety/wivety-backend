package com.wivety.controller;

import com.wivety.models.ExtractInventoryRequest;
import com.wivety.models.Inventory;
import com.wivety.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    private ResponseEntity<Inventory> save(@RequestBody Inventory inventory){
        Inventory createdInventory = inventoryService.create(inventory);
        try {
            return ResponseEntity.created(new URI("/api/inventory"+createdInventory.getId())).body(createdInventory);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    private ResponseEntity<Integer> extractInventory(@RequestBody ExtractInventoryRequest extractInventoryRequest){
        int extracted = inventoryService.extractInventory(extractInventoryRequest);
        try {
            return ResponseEntity.ok(extracted);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Inventory>> getAll (){
        return ResponseEntity.ok(inventoryService.getAllProducts());
    }

    @DeleteMapping
    private ResponseEntity<Void> delete (@RequestBody Inventory inventory){
        inventoryService.delete(inventory);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Inventory>> listProducts (@PathVariable("id") String id){
        return ResponseEntity.ok(inventoryService.findById(id));
    }
}
