package com.wivety.service;

import com.wivety.models.ExtractInventoryRequest;
import com.wivety.models.Inventory;
import com.wivety.models.Product;
import com.wivety.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllProducts() {
        return inventoryRepository.findAll();

    }

    public void delete(Inventory inventory) {
        inventoryRepository.delete(inventory);
    }

    public Optional<Inventory> findById(String id) {
        return inventoryRepository.getByProductById(id);
    }

    public int extractInventory(ExtractInventoryRequest extractInventoryRequest) {
        return inventoryRepository.extractInventory(extractInventoryRequest.getId(), extractInventoryRequest.getQuantity());
    }
}
