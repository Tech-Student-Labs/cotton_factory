package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JacketRepository extends JpaRepository<Jacket, Long> {
}
