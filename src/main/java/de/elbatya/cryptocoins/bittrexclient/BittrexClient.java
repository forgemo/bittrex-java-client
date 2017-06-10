package de.elbatya.cryptocoins.bittrexclient;


import de.elbatya.cryptocoins.bittrexclient.api.BittrexAccountApi;
import de.elbatya.cryptocoins.bittrexclient.api.BittrexMarketApi;
import de.elbatya.cryptocoins.bittrexclient.api.BittrexPublicApi;
import de.elbatya.cryptocoins.bittrexclient.config.ApiBuilderFactory;
import de.elbatya.cryptocoins.bittrexclient.config.ApiCredentials;
import feign.Feign;
import feign.Logger;
import feign.Util;
import feign.slf4j.Slf4jLogger;

import javax.annotation.Nullable;

/**
 * @author contact@elbatya.de
 */
public class BittrexClient {

    public static final String DEFAULT_BASE_URL = "https://bittrex.com/api/v1.1";

    private BittrexPublicApi publicApi;
    private BittrexMarketApi marketApi;
    private BittrexAccountApi accountApi;

    private boolean credentialsAvailable = true;

    public BittrexClient() {
        this(DEFAULT_BASE_URL, null, null);
    }

    public BittrexClient(@Nullable Logger.Level logLevel) {
        this(DEFAULT_BASE_URL, null, logLevel);
    }

    public BittrexClient(@Nullable ApiCredentials credentials) {
        this(DEFAULT_BASE_URL, credentials, null);
    }

    public BittrexClient(@Nullable ApiCredentials credentials, @Nullable Logger.Level logLevel) {
        this(DEFAULT_BASE_URL, credentials, logLevel);
    }


    public BittrexClient(
            String baseUrl,
            @Nullable ApiCredentials credentials,
            @Nullable Logger.Level logLevel)
    {
        Util.checkNotNull(baseUrl, "The baseUrl must not be null!");

        ApiBuilderFactory apiBuilderFactory = new ApiBuilderFactory(baseUrl);

        Feign.Builder apiBuilder = apiBuilderFactory.createApiBuilder(credentials);

        if (logLevel != null) {
            apiBuilder
                    .logger(new Slf4jLogger(BittrexClient.class))
                    .logLevel(logLevel);
        }

        publicApi = apiBuilder.target(BittrexPublicApi.class, baseUrl);

        credentialsAvailable = credentials != null;

        if(credentialsAvailable) {
            marketApi = apiBuilder.target(BittrexMarketApi.class, baseUrl);
            accountApi = apiBuilder.target(BittrexAccountApi.class, baseUrl);
        }
    }

    public BittrexPublicApi getPublicApi() {
        return publicApi;
    }
    public BittrexMarketApi getMarketApi() {
        failIfNoCredentials("You can't use the MarketAPI without credentials.");
        return marketApi;
    }
    public BittrexAccountApi getAccountApi() {
        failIfNoCredentials("You can't use the AccountAPI without credentials.");
        return accountApi;
    }

    private void failIfNoCredentials(String message){
        if(!credentialsAvailable){
            throw new RuntimeException(message);
        }
    }
}
