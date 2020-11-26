package com.microservice.cards.Service;

import com.microservice.cards.Dto.CardsDto;
import com.microservice.cards.Entity.Card;
import com.microservice.cards.Mapper.CardMapper;
import com.microservice.cards.Repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CardsService {
    private final CardsRepository cardsRepository;
    private final CardMapper mapper;

    public List<CardsDto> getCards (Long customerId){
        List<Card> cards = cardsRepository.findAllByCustomerId(customerId);
        return mapper.mapToCardsDto(cards);
    }
}

