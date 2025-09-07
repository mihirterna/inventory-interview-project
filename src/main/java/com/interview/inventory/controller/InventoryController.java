package com.interview.inventory.controller;
import com.interview.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Map;
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping("/value")
    public ResponseEntity<Map<String, BigDecimal>> getTotalValue() {
        BigDecimal totalValue = inventoryService.calculateTotalInventoryValue();
        return ResponseEntity.ok(Map.of("totalInventoryValue", totalValue));
    }
}