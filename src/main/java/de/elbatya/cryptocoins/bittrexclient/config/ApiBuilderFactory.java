package de.elbatya.cryptocoins.bittrexclient.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.elbatya.cryptocoins.bittrexclient.util.ApiKeySigningUtil;
import feign.Feign;
import feign.RequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import javax.annotation.Nullable;

/**
 * @author contact@elbatya.de
 */
public class ApiBuilderFactory {

    private String baseUrl;

    public ApiBuilderFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Feign.Builder createApiBuilder(){
        return createApiBuilder(null);
    }


    public Feign.Builder createApiBuilder(@Nullable ApiCredentials credentials){
        ObjectMapper mapper = ObjectMapperConfigurer.configure(new ObjectMapper());

        Feign.Builder apiBuilder = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder(mapper));

        signRequestsIfCredentialsNotNull(apiBuilder, credentials);

        return apiBuilder;
    }

    private void signRequestsIfCredentialsNotNull(Feign.Builder builder, @Nullable ApiCredentials credentials){
        if (credentials != null) {
            RequestInterceptor signAllRequests = requestTemplate -> {

                requestTemplate.query("apikey", credentials.getKey());
                requestTemplate.query("nonce", ApiKeySigningUtil.createNonce());

                String requestUrl = baseUrl+requestTemplate.request().url();
                String sign = ApiKeySigningUtil.createSign(requestUrl, credentials.getSecret());
                requestTemplate.header("apisign", sign);
            };

            builder.requestInterceptor(signAllRequests);
        }
    }
}
