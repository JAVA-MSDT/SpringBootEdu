package com.msdt.springmvc.repository;

import java.util.List;

import com.msdt.springmvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   // @Query("SELECT p FROM product p WHERE p.name LIKE %:name%")
   // public List<Product> searchByName(@Param("name") String name);

    public List<Product> findProductsByName(String name);
}
