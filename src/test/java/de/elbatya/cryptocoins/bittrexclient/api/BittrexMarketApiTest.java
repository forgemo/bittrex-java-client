package de.elbatya.cryptocoins.bittrexclient.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
import de.elbatya.cryptocoins.bittrexclient.api.model.marketapi.OpenOrder;
import de.elbatya.cryptocoins.bittrexclient.config.ObjectMapperConfigurer;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import feign.mock.MockTarget;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author contact@elbatya.de
 */
public class BittrexMarketApiTest {

    public static final String MARKET = "btc-eth";
    private MockClient mockClient;
    private BittrexMarketApi api;

    private InputStream load(String file) {
        return getClass().getClassLoader().getResourceAsStream("marketapi/"+file);
    }

    @Before
    public void setUp() throws Exception {
        ClassLoader cl = getClass().getClassLoader();

        mockClient = new MockClient()
        .ok(HttpMethod.GET, "/market/getopenorders", load("getopenorders.json"))
        .ok(HttpMethod.GET, "/market/getopenorders?market=btc-eth", load("getopenorders.json"))
        .ok(HttpMethod.GET, "/market/cancel?uuid=1234", load("cancelorder.json"));

        ObjectMapper strictMapper = ObjectMapperConfigurer.configure(new ObjectMapper());
        strictMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        api = Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder(strictMapper))
                    .client(mockClient)
                    .target(new MockTarget<>(BittrexMarketApi.class));
    }

    @Test
    public void getOpenOrders() throws Exception {
        ApiResult<List<OpenOrder>> openOrders = api.getOpenOrders();
        assertThat(openOrders).isNotNull();
        assertThat(openOrders.isSuccess()).isTrue();
        assertThat(openOrders.getResult()).isNotEmpty();
    }

    @Test
    public void getOpenOrdersForMarket() throws Exception {
        ApiResult<List<OpenOrder>> openOrders = api.getOpenOrders(MARKET);
        assertThat(openOrders).isNotNull();
        assertThat(openOrders.isSuccess()).isTrue();
        assertThat(openOrders.getResult()).isNotEmpty();
    }

    @Test
    public void cancelOrder() throws Exception {
        ApiResult<Void> openOrders = api.cancelOrder("1234");
        assertThat(openOrders).isNotNull();
        assertThat(openOrders.isSuccess()).isTrue();
    }


}