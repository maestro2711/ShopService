package org.example.order;

import org.example.product.Product;

import java.math.BigDecimal;
import java.util.List;

public record Order(String id,
                    List<Product>products,
                    double amount) {

}
