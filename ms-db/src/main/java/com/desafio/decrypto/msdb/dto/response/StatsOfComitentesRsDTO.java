package com.desafio.decrypto.msdb.dto.response;

import com.desafio.decrypto.msdb.entity.Mercado;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsOfComitentesRsDTO {
    private String country;
    private List<MarketRsDTO> marketList;
}
