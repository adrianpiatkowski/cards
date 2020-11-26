package com.microservice.cards.Repository;

import com.microservice.cards.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByCustomerId(Long customerId);
}

