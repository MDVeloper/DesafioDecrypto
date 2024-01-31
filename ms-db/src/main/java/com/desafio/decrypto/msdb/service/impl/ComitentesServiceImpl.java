package com.desafio.decrypto.msdb.service.impl;

import com.desafio.decrypto.msdb.dto.response.MarketRsDTO;
import com.desafio.decrypto.msdb.dto.response.StatsOfComitentesRsDTO;
import com.desafio.decrypto.msdb.entity.Comitente;
import com.desafio.decrypto.msdb.entity.Mercado;
import com.desafio.decrypto.msdb.enums.AdmitedCountries;
import com.desafio.decrypto.msdb.repository.ComitenteRepository;
import com.desafio.decrypto.msdb.repository.MercadoRepository;
import com.desafio.decrypto.msdb.service.ComitentesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

/**
 * Represents the service for comitentes
 */
@Service
public class ComitentesServiceImpl implements ComitentesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComitentesServiceImpl.class);

    private final ComitenteRepository comitenteRepository;
    private final MercadoRepository mercadoRepository;

    /**
     * Constructor
     * @param comitenteRepository {@link ComitenteRepository}
     */
    @Autowired
    public ComitentesServiceImpl(final ComitenteRepository comitenteRepository, final MercadoRepository mercadoRepository) {
         this.comitenteRepository = comitenteRepository;
         this.mercadoRepository = mercadoRepository;
    }

    @Override
    public Map<String, List<MarketRsDTO>> getStats1() {
        LOGGER.info("Using Method 1, diferent formato, pero menores iteraciones/rsTime");

        long startingPoint = System.currentTimeMillis();
        final List<Comitente> comitenteList = this.comitenteRepository.findAll().stream().toList();
        LOGGER.info("Comitentes found: {} in {} seconds", comitenteList.size(), (double) (System.currentTimeMillis() - startingPoint) / 1000);

        startingPoint = System.currentTimeMillis();
        final List<Mercado> mercadoList = this.mercadoRepository.findAll().stream().toList();
        LOGGER.info("Mercados found: {} in {} seconds", comitenteList.size(), (double) (System.currentTimeMillis() - startingPoint) / 1000);

        startingPoint = System.currentTimeMillis();
        Map<String, List<MarketRsDTO>> result = mapByCountryAndMarkets(comitenteList, mercadoList);
        LOGGER.info("Time consume in seconds to make the proccess: {}", (double) (System.currentTimeMillis() - startingPoint) / 1000);
        // return mapByCountryAndMarkets(comitenteList, mercadoList);
        return result;
    }

    @Override
    public List<StatsOfComitentesRsDTO> getStats() {
        LOGGER.info("Using Method 0, formato indicado, pero mas iteraciones/rsTime");

        long startingPoint = System.currentTimeMillis();
        final List<Comitente> comitenteList = this.comitenteRepository.findAll().stream().toList();
        LOGGER.info("Comitentes found: {} in {} seconds", comitenteList.size(), (double) (System.currentTimeMillis() - startingPoint) / 1000);

        startingPoint = System.currentTimeMillis();
        final List<Mercado> mercadoList = this.mercadoRepository.findAll().stream().toList();
        LOGGER.info("Mercados found: {} in {} seconds", comitenteList.size(), (double) (System.currentTimeMillis() - startingPoint) / 1000);

        startingPoint = System.currentTimeMillis();
        List<StatsOfComitentesRsDTO> statsOfComitentesRsDTOList = buildResponse(comitenteList, mercadoList);
        LOGGER.info("Time consume in seconds to make the proccess: {}", (double) (System.currentTimeMillis() - startingPoint) / 1000);
        //return buildResponse(comitenteList, mercadoList);
        return statsOfComitentesRsDTOList;
    }

    private List<Comitente> filterComitentesByCountry(final List<Comitente> comitenteList, final AdmitedCountries country) {
        final Predicate<Comitente> comitentePredicate = comitente -> comitente.getMarketList().stream().anyMatch(mercado -> mercado.getCountry().equals(country));
        return comitenteList.stream().filter(comitentePredicate).toList();
    }

    private List<Mercado> filterMarketsByCountry(final List<Mercado> mercadoList, AdmitedCountries country) {
        final Predicate<Mercado> mercadoPredicate = mercado -> mercado.getCountry().equals(country);
        return mercadoList.stream().filter(mercadoPredicate).toList();
    }

    private List<StatsOfComitentesRsDTO> buildResponse(final List<Comitente> comitenteList, final List<Mercado> mercadoList) {
        Map<String, List<MarketRsDTO>> mappedResult = mapByCountryAndMarkets(comitenteList, mercadoList);

        return buildStatsOfComitentesRsDTOList(mappedResult);
    }

    private Map<String, List<MarketRsDTO>> mapByCountryAndMarkets(final List<Comitente> comitenteList, final List<Mercado> mercadoList) {
        double percentagePerComitente = 100.0 / comitenteList.size();

        final Map<String, List<MarketRsDTO>> responseMap = new HashMap<>();

        mercadoList.forEach(mercado -> {

            if (AdmitedCountries.resolveByName(mercado.getCountry().name()) == null) {
                return;
            }

            if (!responseMap.containsKey(mercado.getCountry().name())) {
                responseMap.put(mercado.getCountry().name(), new ArrayList<>());
            }

            double marketPercentage = percentagePerComitente * mercado.getComitenteList().size();

            MarketRsDTO marketRsDTO = MarketRsDTO.builder()
                    .code(mercado.getCode())
                    .percentage(String.valueOf(marketPercentage))
                    .build();

            responseMap.get(mercado.getCountry().name()).add(marketRsDTO);
        });

        return responseMap;
    }

    private List<StatsOfComitentesRsDTO> buildStatsOfComitentesRsDTOList(Map<String, List<MarketRsDTO>> map) {

        final List<StatsOfComitentesRsDTO> statsOfComitentesRsDTOList = new ArrayList<>();

        for (Map.Entry<String, List<MarketRsDTO>> entry : map.entrySet()) {
            StatsOfComitentesRsDTO statsOfComitentesRsDTO = StatsOfComitentesRsDTO.builder()
                    .country(entry.getKey())
                    .marketList(entry.getValue())
                    .build();

            statsOfComitentesRsDTOList.add(statsOfComitentesRsDTO);
        }

        return statsOfComitentesRsDTOList;
    }

    private static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = rnd.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    private static AdmitedCountries getRandomEnum() {
        return AdmitedCountries.values()[(int) (Math.random() * AdmitedCountries.values().length)];
    }

    private void createData() {
        int stop = 1000;
        while (stop > 0) {
            Mercado mercadoGuardado = this.mercadoRepository.save(
                    Mercado.builder()
                            .code(generateRandomString(5))
                            .description(generateRandomString(50))
                            .country(getRandomEnum())
                            .build()
            );

            Comitente comitenteGuardado = this.comitenteRepository.save(
                    Comitente.builder()
                            .description(generateRandomString(50))
                            .marketList(List.of(mercadoGuardado))
                            .build()
            );
            stop--;
        }
    }
}
