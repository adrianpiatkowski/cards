package com.microservice.cards.Controller;

import com.microservice.cards.Controller.Response.GetCardsResponse;
import com.microservice.cards.Dto.CardsDto;
import com.microservice.cards.Service.CardsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "/v1/cards", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CardsController {
    @Value("${application.allow-get-cards}")
    private boolean allowGetCards;

    private final CardsService cardsService;

    @GetMapping
    public GetCardsResponse getCards(@RequestParam("customerId")Long customerId){
        log.info("Get cards for customerId: {}", customerId);
        if(!allowGetCards) {
            log.info("Getting cards is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting cards is disabled");
        }
        List<CardsDto> cards = cardsService.getCards(customerId);
        return GetCardsResponse.of(cards);

    }
}

