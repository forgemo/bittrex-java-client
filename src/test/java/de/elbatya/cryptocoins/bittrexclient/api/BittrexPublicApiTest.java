package de.elbatya.cryptocoins.bittrexclient.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
import de.elbatya.cryptocoins.bittrexclient.api.model.publicapi.*;
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
public class BittrexPublicApiTest {

    private MockClient mockClient;
    private BittrexPublicApi api;
    private final static String MARKET = "btc-eth";

    private InputStream load(String file) {
        return getClass().getClassLoader().getResourceAsStream("publicapi/"+file);
    }

    @Before
    public void setUp() throws Exception {

        ClassLoader cl = getClass().getClassLoader();

        mockClient = new MockClient()
        .ok(HttpMethod.GET, "/public/getmarkets", load("getmarkets.json"))
        .ok(HttpMethod.GET, "/public/getcurrencies", load("getcurrencies.json"))
        .ok(HttpMethod.GET, "/public/getticker?market=btc-eth", load("getticker.json"))
        .ok(HttpMethod.GET, "/public/getmarketsummaries", load("getmarketsummaries.json"))
        .ok(HttpMethod.GET, "/public/getmarketsummary?market=btc-eth", load("getmarketsummary.json"))
        .ok(HttpMethod.GET, "/public/getorderbook?type=both&market=btc-eth", load("getorderbookboth.json"))
        .ok(HttpMethod.GET, "/public/getorderbook?type=both&market=btc-eth&depth=10", load("getorderbookboth.json"))
        .ok(HttpMethod.GET, "/public/getorderbook?type=sell&market=btc-eth", load("getorderbooksell.json"))
        .ok(HttpMethod.GET, "/public/getorderbook?type=sell&market=btc-eth&depth=10", load("getorderbooksell.json"))
        .ok(HttpMethod.GET, "/public/getorderbook?type=buy&market=btc-eth", load("getorderbookbuy.json"))
        .ok(HttpMethod.GET, "/public/getorderbook?type=buy&market=btc-eth&depth=10", load("getorderbookbuy.json"))
        .ok(HttpMethod.GET, "/public/getmarkethistory?market=btc-eth", load("getmarkethistory.json"));


        ObjectMapper strictMapper = ObjectMapperConfigurer.configure(new ObjectMapper());
        strictMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        api = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder(strictMapper))
                .client(mockClient)
                .target(new MockTarget<>(BittrexPublicApi.class));
    }

    @Test
    public void getMarkets() throws Exception {
        ApiResult<List<Market>> markets = api.getMarkets();
        assertThat(markets).isNotNull();
        assertThat(markets.isSuccess()).isTrue();
        assertThat(markets.getResult()).isNotEmpty();
    }

    @Test
    public void getCurrencies() throws Exception {
        ApiResult<List<Currency>> currencies = api.getCurrencies();
        assertThat(currencies).isNotNull();
        assertThat(currencies.isSuccess()).isTrue();
        assertThat(currencies.getResult()).isNotEmpty();
    }

    @Test
    public void getTicker() throws Exception {
        ApiResult<Ticker> ticker = api.getTicker(MARKET);
        assertThat(ticker).isNotNull();
        assertThat(ticker.isSuccess()).isTrue();
        assertThat(ticker.getResult()).isNotNull();
    }

    @Test
    public void getMarketSummaries() throws Exception {
        ApiResult<List<MarketSummary>> marketSummaries = api.getMarketSummaries();
        assertThat(marketSummaries).isNotNull();
        assertThat(marketSummaries.isSuccess()).isTrue();
        assertThat(marketSummaries.getResult()).isNotEmpty();
    }

    @Test
    public void getMarketSummary() throws Exception {
        ApiResult<List<MarketSummary>> marketSummary = api.getMarketSummary(MARKET);
        assertThat(marketSummary).isNotNull();
        assertThat(marketSummary.isSuccess()).isTrue();
        assertThat(marketSummary.getResult()).isNotEmpty();
    }

    @Test
    public void getOrderBook() throws Exception {
        ApiResult<OrderBook> orderBook = api.getOrderBook(MARKET);
        assertThat(orderBook).isNotNull();
        assertThat(orderBook.isSuccess()).isTrue();
        assertThat(orderBook.getResult()).isNotNull();
        assertThat(orderBook.getResult().getBuy()).isNotEmpty();
        assertThat(orderBook.getResult().getSell()).isNotEmpty();
    }

    @Test
    public void getOrderBookWithDepth() throws Exception {
        ApiResult<OrderBook> orderBook = api.getOrderBook(MARKET, 10);
        assertThat(orderBook).isNotNull();
        assertThat(orderBook.isSuccess()).isTrue();
        assertThat(orderBook.getResult()).isNotNull();
    }

    @Test
    public void getOrderBookForSell() throws Exception {
        ApiResult<List<OrderBookEntry>> orderBookForSell = api.getOrderBookForSell(MARKET);
        assertThat(orderBookForSell).isNotNull();
        assertThat(orderBookForSell.isSuccess()).isTrue();
        assertThat(orderBookForSell.getResult()).isNotEmpty();
    }

    @Test
    public void getOrderBookForSellWithDepth() throws Exception {
        ApiResult<List<OrderBookEntry>> orderBookForSell = api.getOrderBookForSell(MARKET, 10);
        assertThat(orderBookForSell).isNotNull();
        assertThat(orderBookForSell.isSuccess()).isTrue();
        assertThat(orderBookForSell.getResult()).isNotEmpty();
    }

    @Test
    public void getOrderBookForBuy() throws Exception {
        ApiResult<List<OrderBookEntry>> orderBookForBuy = api.getOrderBookForBuy(MARKET);
        assertThat(orderBookForBuy).isNotNull();
        assertThat(orderBookForBuy.isSuccess()).isTrue();
        assertThat(orderBookForBuy.getResult()).isNotEmpty();
    }

    @Test
    public void getOrderBookForBuyWithDepth() throws Exception {
        ApiResult<List<OrderBookEntry>> orderBookForBuy = api.getOrderBookForBuy(MARKET, 10);
        assertThat(orderBookForBuy).isNotNull();
        assertThat(orderBookForBuy.isSuccess()).isTrue();
        assertThat(orderBookForBuy.getResult()).isNotEmpty();
    }

    @Test
    public void getMarketHistory() throws Exception {
        ApiResult<List<MarketHistoryEntry>> marketHistory = api.getMarketHistory(MARKET);
        assertThat(marketHistory).isNotNull();
        assertThat(marketHistory.isSuccess()).isTrue();
        assertThat(marketHistory.getResult()).isNotEmpty();
    }

}