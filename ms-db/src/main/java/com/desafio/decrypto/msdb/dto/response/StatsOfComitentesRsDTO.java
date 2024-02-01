package com.desafio.decrypto.msdb.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.List;

/**
 * Represent StatsOfComitentesRsDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsOfComitentesRsDTO {
    private String country;
    private List<MarketRsDTO> marketList;
}
