package com.interview.inventory.service;

import com.interview.inventory.dto.InventoryValueResponse;
import com.interview.inventory.dto.ProductValuationDto;
import com.interview.inventory.model.Product;
import com.interview.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    private final ProductRepository productRepository;

    private static final BigDecimal DISCOUNT_THRESHOLD = new BigDecimal("5000.00");
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.10"); // 10%

    @Autowired
    public InventoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public InventoryValueResponse calculateInventoryValue() {
        List<Product> products = productRepository.findAll();

        BigDecimal totalGrossValue = BigDecimal.ZERO;
        BigDecimal totalDiscount = BigDecimal.ZERO;
        List<ProductValuationDto> breakdownList = new ArrayList<>();

        for (Product product : products) {
            BigDecimal itemPrice = BigDecimal.valueOf(product.getPrice());
            BigDecimal itemQuantity = new BigDecimal(product.getQuantity());
            BigDecimal itemLineValue = itemPrice.multiply(itemQuantity);

            BigDecimal discountForItem = BigDecimal.ZERO;

            totalGrossValue = totalGrossValue.add(itemLineValue);

            if (itemLineValue.compareTo(DISCOUNT_THRESHOLD) > 0) {
                discountForItem = itemLineValue.multiply(DISCOUNT_RATE);
                totalDiscount = discountForItem;
            }

            ProductValuationDto productDto = new ProductValuationDto();
            productDto.setProductId(product.getId());
            productDto.setProductName(product.getName());
            productDto.setQuantity(product.getQuantity());
            productDto.setUnitPrice(itemPrice.setScale(2, RoundingMode.HALF_UP));
            productDto.setLineGrossValue(itemLineValue.setScale(2, RoundingMode.HALF_UP));
            productDto.setDiscountApplied(discountForItem.setScale(2, RoundingMode.HALF_UP));
            productDto.setLineNetValue(itemLineValue.subtract(discountForItem).setScale(2, RoundingMode.HALF_UP));

            breakdownList.add(productDto);
        }

        BigDecimal netValue = totalGrossValue.subtract(totalDiscount);
        String details = String.format("A %.0f%% discount is applied to any product line with a total value over $%s.",
                DISCOUNT_RATE.doubleValue() * 100,
                DISCOUNT_THRESHOLD.toPlainString());

        InventoryValueResponse finalResponse = new InventoryValueResponse();
        finalResponse.setGrossValue(totalGrossValue.setScale(2, RoundingMode.HALF_UP));
        finalResponse.setTotalDiscountAmount(totalDiscount.setScale(2, RoundingMode.HALF_UP));
        finalResponse.setNetValue(netValue.setScale(2, RoundingMode.HALF_UP));
        finalResponse.setDiscountDetails(details);
        finalResponse.setProductBreakdown(breakdownList);

        return finalResponse;
    }
}