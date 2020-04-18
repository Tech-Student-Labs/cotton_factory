package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<Shoes, Long> {

}
