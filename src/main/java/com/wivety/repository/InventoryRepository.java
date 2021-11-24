package com.wivety.repository;

import com.wivety.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    @Query( value = "SELECT * FROM inventory p WHERE p.product = :inventory and p.active = TRUE", nativeQuery = true)
    Optional<Inventory> getByProductById(@Param("inventory") String inventory);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query( value = "UPDATE inventory SET quantity = quantity - :quantity WHERE product = :id", nativeQuery = true)
    int extractInventory(@Param("id") String id, @Param("quantity") Long quantity);

}
