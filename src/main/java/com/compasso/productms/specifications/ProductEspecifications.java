package com.compasso.productms.specifications;

import com.compasso.model.Product;
import com.compasso.productms.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductEspecifications {

    public static Specification<ProductEntity> containsNameOrDescription(String q) {
        if (q != null) {
            return (root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.or(
                            criteriaBuilder.like(root.get("name"), String.format("%%%s%%", q)),
                            criteriaBuilder.like(root.get("description"), String.format("%%%s%%", q))
                    );
        } else {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
    }

    public static Specification<ProductEntity> validateMinPrice(BigDecimal minPrice) {
        if (minPrice != null) {
            return (root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice.toString());
        } else {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
    }

    public static Specification<ProductEntity> validateMaxPrice(BigDecimal maxPrice) {
        if (maxPrice != null) {
            return (root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice.toString());
        } else {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
    }
}
