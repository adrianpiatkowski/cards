package com.microservice.cards.Controller.Response;

import com.microservice.cards.Dto.CardsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetCardsResponse {
    private List<CardsDto> cards;
}
