package com.app.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Buy;

@Repository
public interface buyRepository extends JpaRepository<Buy, Long> {

    @Query("SELECT b FROM Buy b WHERE b.id = :id")
    Optional<Buy> findByBuyId(Long id);

    @SuppressWarnings("null")
    Optional<Buy> findById(Long id);
}