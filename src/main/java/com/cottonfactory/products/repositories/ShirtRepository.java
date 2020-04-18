package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtRepository extends JpaRepository <Shirt, Long> {
}
