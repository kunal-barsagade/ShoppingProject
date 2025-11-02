package com.ecom.productcatalog.repository;

import com.ecom.productcatalog.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<product,Long> {
    List<product> findByCategoryId(Long categoryId);
}

//findByCategoryId = this is the naming convention know as spring data jpa naming convention.
//                  this is the custome query that spring make
// find = select  * from  , by = where clause      categoryId = is the filed/row in product table
//    SELECT * FROM PRODUCT WHERE CATEGORY_ID = (what u want);
//      this is what spring boot / hibernate doo