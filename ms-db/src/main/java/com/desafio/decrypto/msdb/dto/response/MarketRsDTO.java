package com.desafio.decrypto.msdb.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MarketRsDTO {
    private String code;
    private String percentage;
}
