package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //select * from products where name = :name;

    //@Query("select p from Product p where p.name = :name")
    // @Query(value = "select  from products where name = :name ", nativeQuery = true)
    Optional<Product> findByName(String name);
    //select * from products where category = 'electronics';
    List<Product> findByCategory(String category);
    /*
    basic crud methods
    save, delete, findAll, findById
     */


}
