package com.desafio.decrypto.msdb.config;

import com.desafio.decrypto.msdb.repository.ComitenteRepository;
import com.desafio.decrypto.msdb.repository.MercadoRepository;
import com.desafio.decrypto.msdb.utils.OwnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config for pre-load db data
 */
@Configuration
public class PreLoadDb {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreLoadDb.class);

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private ComitenteRepository comitenteRepository;

    @Bean
    CommandLineRunner init() {
        this.comitenteRepository.deleteAll();

        this.mercadoRepository.deleteAll();

        return args -> {
            LOGGER.info("Pre-load Mercados: " + this.mercadoRepository.saveAll(
                    OwnUtils.createRandomMercados(10)).size());

            LOGGER.info("Pre-load Comitentes " + this.comitenteRepository.saveAll(
                    OwnUtils.createRandomComitentes(100, this.mercadoRepository.findAll())).size());
        };
    }
}
