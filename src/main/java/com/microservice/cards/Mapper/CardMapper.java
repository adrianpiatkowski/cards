package com.microservice.cards.Mapper;

import com.microservice.cards.Dto.CardsDto;
import com.microservice.cards.Entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardMapper {

    public List<CardsDto> mapToCardsDto(List<Card> cards){
        return cards.stream().map(card -> CardsDto.builder()
                .id(card.getId())
                .nrb(card.getNrb())
                .debet(card.getDebet())
                .build()).collect(Collectors.toList());
    }
}

