package com.desafio.decrypto.msdb.utils;

import com.desafio.decrypto.msdb.entity.Comitente;
import com.desafio.decrypto.msdb.entity.Mercado;
import com.desafio.decrypto.msdb.enums.AdmitedCountries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Util class used as component and not classic static, bcoz of the autowired repository
 */
public class OwnUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(OwnUtils.class);

    /**
     * Method to create a list of random Mercado
     * @param count count
     * @return mercadoList {@link List<Mercado>}
     */
    public static List<Mercado> createRandomMercados(final int count) {
        final List<Mercado> mercadoList = new ArrayList<>();

        int remaining = count;

        while (remaining > 0) {
            mercadoList.add(Mercado.builder()
                    .code(generateRandomString(5))
                    .description(generateRandomString(50))
                    .country(getRandomEnum())
                    .build()
            );
            remaining--;
        }
        return mercadoList;
    }

    /**
     * Method to create a list of random Comitentes with random Mercado assign to them
     * @param count count
     * @param allExistingMercados allExistingMercados
     * @return mercadoList {@link List<Comitente>}
     */
    public static List<Comitente> createRandomComitentes(final int count, final List<Mercado> allExistingMercados) {
        final List<Comitente> comitenteList = new ArrayList<>();

        int remaining = count;

        while (remaining > 0) {
            final List<Mercado> marketList = new ArrayList<>();
            marketList.add(findMercadosAndGetOneRandom(allExistingMercados));

            comitenteList.add(Comitente.builder()
                    .description(generateRandomString(50))
                    .marketList(marketList)
                    .build()
            );
            remaining--;
        }
        return comitenteList;
    }

    /**
     * Method to find a random Mercado
     * @param allExistingMercados allExistingMercados
     * @return mercado {@link Mercado}
     */
    public static Mercado findMercadosAndGetOneRandom(final List<Mercado> allExistingMercados) {
        return allExistingMercados.get(new Random().nextInt(allExistingMercados.size()));
    }
    /**
     * Method to generate a random string
     * @param length length
     * @return randomString
     */
    public static String generateRandomString(final int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        final Random rnd = new Random();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            final int randomIndex = rnd.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    /**
     * Method to get a random enum of AdmittedCountries
     * @return AdmitedCountries {@link AdmitedCountries}
     */
    public static AdmitedCountries getRandomEnum() {
        return AdmitedCountries.values()[(int) (Math.random() * AdmitedCountries.values().length)];
    }
}
