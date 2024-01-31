package com.desafio.decrypto.msdb.controller;

import com.desafio.decrypto.msdb.dto.response.MarketRsDTO;
import com.desafio.decrypto.msdb.dto.response.StatsOfComitentesRsDTO;
import com.desafio.decrypto.msdb.service.ComitentesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Represents the controller for comitentes
 */
//@Tag(name = "Comitentes", description = "Comitentes")
@RestController
@RequestMapping("/comitentes")
public class ComitentesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComitentesController.class);

    private final ComitentesService comitentesService;

    /**
     * Constructor
     * @param comitentesService {@link ComitentesService}
     */
    @Autowired
    public ComitentesController(final ComitentesService comitentesService) {
        this.comitentesService = comitentesService;
    }

    /**
     * Endpoint for get stats of comitentes
     * @return statsOfComitentesRsDTO {@link StatsOfComitentesRsDTO}
     */
    @GetMapping(path = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<StatsOfComitentesRsDTO> getStats() {
        return comitentesService.getStats();
    }

    /**
     * Endpoint for get stats of comitentes
     * @return statsOfComitentesRsDTO {@link StatsOfComitentesRsDTO}
     */
    @GetMapping(path = "/stats1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<MarketRsDTO>> getStats1() {
        return comitentesService.getStats1();
    }
}
