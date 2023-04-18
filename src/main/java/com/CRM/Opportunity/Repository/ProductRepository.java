package com.CRM.Opportunity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRM.Opportunity.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
