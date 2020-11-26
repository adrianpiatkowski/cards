package com.microservice.cards.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardsDto {
    private long id;
    private String nrb;
    private String debet;
}

