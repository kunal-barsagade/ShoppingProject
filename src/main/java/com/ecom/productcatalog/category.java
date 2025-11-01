package com.ecom.productcatalog;

import com.ecom.productcatalog.model.product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private Set<product> products;


}
