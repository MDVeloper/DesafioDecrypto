package com.desafio.decrypto.msdb.controller;

import com.desafio.decrypto.msdb.dto.response.MarketRsDTO;
import com.desafio.decrypto.msdb.dto.response.StatsOfComitentesRsDTO;
import com.desafio.decrypto.msdb.service.ComitentesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Represents the controller for comitentes
 */
@Tag(name = "Comitentes", description = "Comitentes")
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
     * Test answer who just get a OK message
     * @return String {@link String}
     */
    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Test answer who just get a OK message", responses = {
            @ApiResponse(description = "Test answer who just get a OK message", responseCode = "200", content = @Content(mediaType = "application/json"))})
    @ResponseStatus(HttpStatus.OK)
    public String getTest() {
        return this.comitentesService.getTest();
    }

    /**
     * Endpoint for get stats of comitentes
     * @return statsOfComitentesRsDTO {@link StatsOfComitentesRsDTO}
     */
    @GetMapping(path = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get stats of comitentes", responses = {
            @ApiResponse(description = "Get stats of comitentes", responseCode = "200", content = @Content(mediaType = "application/json"))})
    @ResponseStatus(HttpStatus.OK)
    public List<StatsOfComitentesRsDTO> getStats() {
        return this.comitentesService.getStats();
    }

    /**
     * Endpoint for get stats of comitentes
     * @return Map<String, List<MarketRsDTO>> {@link Map<>}
     */
    @GetMapping(path = "/stats1", produces = MediaType.APPLICATION_JSON_VALUE)
     @Operation(summary = "Get stats of comitentes", responses = {
            @ApiResponse(description = "Get stats of comitentes", responseCode = "200", content = @Content(mediaType = "application/json"))})
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<MarketRsDTO>> getStats1() {
        return this.comitentesService.getStats1();
    }

    /**
     * Endpoint for create random mercados
     * @param count count
     */
    @GetMapping(path = "/createMercados", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create random mercados", responses = {
            @ApiResponse(description = "Create random mercados", responseCode = "200", content = @Content(mediaType = "application/json"))})
    @ResponseStatus(value = HttpStatus.OK, reason = "Mercados created")
    public void createRandomMercados(@RequestParam("count") final int count) {
        this.comitentesService.createRandomMercados(count);
    }

    /**
     * Endpoint for create random comitentes
     * @param count count
     */
    @GetMapping(path = "/createComitentes", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create random comitentes", responses = {
            @ApiResponse(description = "Create random comitentes", responseCode = "200", content = @Content(mediaType = "application/json"))})
    @ResponseStatus(value = HttpStatus.OK, reason = "Comitentes created")
    public void createRandomComitentes(@RequestParam("count") final int count) {
        this.comitentesService.createRandomComitentes(count);
    }
}
