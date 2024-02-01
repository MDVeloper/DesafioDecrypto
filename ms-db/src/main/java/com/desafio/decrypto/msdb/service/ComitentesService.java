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
     * Proccess test
     * @return String {@link String}
     */
    public String getTest();

    /**
     * Retrieve stats of comitentes
     * @return StatsOfComitentesRsDTO {@link StatsOfComitentesRsDTO}
     */
    public List<StatsOfComitentesRsDTO> getStats();

    /**
     * Retrieve stats of comitentes
     * @return Map<String, List<MarketRsDTO>> {@link Map<>}
     */
    public Map<String, List<MarketRsDTO>> getStats1();

    /**
     * Create random mercados
     * @param count count
     */
    public void createRandomMercados(int count);

    /**
     * Create random comitentes
     * @param count count
     */
    public void createRandomComitentes(int count);
}
