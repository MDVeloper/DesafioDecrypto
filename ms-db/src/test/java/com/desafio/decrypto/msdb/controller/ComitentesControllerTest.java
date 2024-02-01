package com.desafio.decrypto.msdb.controller;

import com.desafio.decrypto.msdb.dto.response.MarketRsDTO;
import com.desafio.decrypto.msdb.dto.response.StatsOfComitentesRsDTO;
import com.desafio.decrypto.msdb.service.ComitentesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test the Comitentes Controller.
 */
@RunWith(MockitoJUnitRunner.class)
public class ComitentesControllerTest {

    private final int REQUEST_INTEGER = 10;

    @InjectMocks
    private ComitentesController comitentesController;

    @Mock
    private ComitentesService comitentesService;

    private MockMvc mockMvc;

    /**
     * Init.
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(comitentesController).build();
    }

    /**
     * Test the getStats method.
     */
    @Test
    public void whenGetStatsThenReturnListOfStatsOfComitentesRsDTO() {
        List<StatsOfComitentesRsDTO> expected = new ArrayList<>();
        when(this.comitentesService.getStats()).thenReturn(expected);
        List<StatsOfComitentesRsDTO> response = this.comitentesController.getStats();

        assertEquals(expected, response);
    }

    /**
     * Test the getStats1 method.
     */
    @Test
    public void whenGetStats1ThenReturnListOfStatsOfComitentesRsDTO() {
        Map<String, List<MarketRsDTO>> expected = new HashMap<>();
        when(this.comitentesService.getStats1()).thenReturn(expected);
        Map<String, List<MarketRsDTO>> response = this.comitentesController.getStats1();

        assertEquals(expected, response);
    }

    /**
     * Test the createRandomMercados method.
     */
    @Test
    public void whenCreateRandomMercadosThenReturnVoid() {
        doNothing().when(this.comitentesService).createRandomMercados(REQUEST_INTEGER);

        this.comitentesController.createRandomMercados(REQUEST_INTEGER);

        verify(this.comitentesService).createRandomMercados(REQUEST_INTEGER);
    }

    /**
     * Test the createRandomComitentes method.
     */
    @Test
    public void whenCreateRandomComitentesThenReturnVoid() {
        doNothing().when(this.comitentesService).createRandomComitentes(REQUEST_INTEGER);

        this.comitentesController.createRandomComitentes(REQUEST_INTEGER);

        verify(this.comitentesService).createRandomComitentes(REQUEST_INTEGER);
    }
}
