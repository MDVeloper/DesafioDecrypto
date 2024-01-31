package com.desafio.decrypto.msdb.service;

import com.desafio.decrypto.msdb.dto.response.MarketRsDTO;
import com.desafio.decrypto.msdb.dto.response.StatsOfComitentesRsDTO;

import java.util.List;
import java.util.Map;

/**
 * Represents the service for comitentes
 */
public interface ComitentesService {

    /**
     * Retrieve stats of comitentes
     * @return StatsOfComitentesRsDTO {@link StatsOfComitentesRsDTO}
     */
    List<StatsOfComitentesRsDTO> getStats();

    /**
     * Retrieve stats of comitentes
     * @return Map<String, List<MarketRsDTO>> {@link Map<>}
     */
    Map<String, List<MarketRsDTO>> getStats1();
}