package com.interview.inventory.service;

import com.interview.inventory.model.Product;
import com.interview.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class InventoryService {
    private final ProductRepository productRepository;

    @Autowired
    public InventoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public BigDecimal calculateTotalInventoryValue() {
        List<Product> products = productRepository.findAll();
        double totalValue = 0.0;
        for (Product product : products) {
            double itemValue = product.getPrice() * product.getQuantity();
            if (itemValue > 5000.0) {
                totalValue = totalValue * 0.90;
            }
            totalValue += itemValue;
        }
        return new BigDecimal(totalValue).setScale(2, RoundingMode.HALF_UP);
    }
}