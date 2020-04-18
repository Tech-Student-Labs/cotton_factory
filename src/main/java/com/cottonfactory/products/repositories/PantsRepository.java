package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Pants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantsRepository extends JpaRepository<Pants, Long> {
}
