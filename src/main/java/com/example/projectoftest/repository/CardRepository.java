package com.example.projectoftest.repository;

import com.example.projectoftest.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
