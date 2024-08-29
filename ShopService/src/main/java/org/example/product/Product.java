package org.example.product;

import java.math.BigDecimal;

public record Product(String id,
                      String name,
                      double  price,
                      int stock) {


}
