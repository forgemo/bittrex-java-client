package de.elbatya.cryptocoins.bittrexclient;

import com.sun.istack.internal.Nullable;
import de.elbatya.cryptocoins.bittrexclient.api.BittrexAccountApi;
import de.elbatya.cryptocoins.bittrexclient.api.BittrexMarketApi;
import de.elbatya.cryptocoins.bittrexclient.api.BittrexPublicApi;
import de.elbatya.cryptocoins.bittrexclient.config.ApiBuilderFactory;
import de.elbatya.cryptocoins.bittrexclient.config.ApiCredentials;
import feign.Util;

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
        this(DEFAULT_BASE_URL, null);
    }

    public BittrexClient(@Nullable ApiCredentials credentials) {
        this(DEFAULT_BASE_URL, credentials);
    }

    public BittrexClient(String baseUrl, @Nullable ApiCredentials credentials) {
        Util.checkNotNull(baseUrl, "The baseUrl must not be null!");

        ApiBuilderFactory apiBuilderFactory = new ApiBuilderFactory(baseUrl);

        publicApi = apiBuilderFactory.createApiBuilder().target(BittrexPublicApi.class, baseUrl);

        credentialsAvailable = credentials != null;
        if(credentialsAvailable) {
            marketApi = apiBuilderFactory.createApiBuilder(credentials).target(BittrexMarketApi.class, baseUrl);
            accountApi = apiBuilderFactory.createApiBuilder(credentials).target(BittrexAccountApi.class, baseUrl);
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
