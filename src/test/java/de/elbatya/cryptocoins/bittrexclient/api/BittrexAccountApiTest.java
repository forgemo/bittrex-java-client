package de.elbatya.cryptocoins.bittrexclient.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.elbatya.cryptocoins.bittrexclient.api.model.accountapi.*;
import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
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
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author contact@elbatya.de
 */
public class BittrexAccountApiTest {

    public static final String MARKET = "btc-eth";
    public static final String CURRENCY = "btc";

    private MockClient mockClient;
    private BittrexAccountApi api;

    private InputStream load(String file) {
        return getClass().getClassLoader().getResourceAsStream("accountapi/"+file);
    }

    @Before
    public void setUp() throws Exception {
        ClassLoader cl = getClass().getClassLoader();

        mockClient = new MockClient()
                .ok(HttpMethod.GET, "/account/getbalances", load("getbalances.json"))
                .ok(HttpMethod.GET, "/account/getbalance?currency=btc", load("getbalance.json"))
                .ok(HttpMethod.GET, "/account/getdepositaddress?currency=btc", load("getdepositaddress.json"))
                .ok(HttpMethod.GET, "/account/getdeposithistory", load("getdeposithistory.json"))
                .ok(HttpMethod.GET, "/account/getdeposithistory?currency=btc", load("getdeposithistory.json"))
                .ok(HttpMethod.GET, "/account/getorder?uuid=1234", load("getorder.json"))
                .ok(HttpMethod.GET, "/account/getorderhistory", load("getorderhistory.json"))
                .ok(HttpMethod.GET, "/account/getorderhistory?market=btc-eth", load("getorderhistoryformarket.json"))
                .ok(HttpMethod.GET, "/account/getwithdrawalhistory?currency=btc", load("getwithdrawalhistory.json"))
                .ok(HttpMethod.GET, "/account/getwithdrawalhistory", load("getwithdrawalhistory.json"))
                .ok(HttpMethod.GET, "/account/withdraw?currency=btc&quantity=11.0&address=BTC_ADDRESS", load("withdraw.json"))
                .ok(HttpMethod.GET, "/account/withdraw?currency=btc&quantity=11.0&address=BTC_ADDRESS&paymentid=note", load("withdraw.json"))
        ;

        ObjectMapper strictMapper = ObjectMapperConfigurer.configure(new ObjectMapper());
        strictMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        api = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder(strictMapper))
                .client(mockClient)
                .target(new MockTarget<>(BittrexAccountApi.class));
    }

    @Test
    public void getBalances() throws Exception {
        ApiResult<List<Balance>> balances = api.getBalances();
        assertThat(balances).isNotNull();
        assertThat(balances.isSuccess()).isTrue();
        assertThat(balances.getResult()).isNotEmpty();
    }

    @Test
    public void getBalance() throws Exception {
        ApiResult<Balance> balance = api.getBalance(CURRENCY);
        assertThat(balance).isNotNull();
        assertThat(balance.isSuccess()).isTrue();
        assertThat(balance.getResult()).isNotNull();
    }

    @Test
    public void getDepositAddress() throws Exception {
        ApiResult<DepositAddress> depositAddress = api.getDepositAddress(CURRENCY);
        assertThat(depositAddress).isNotNull();
        assertThat(depositAddress.isSuccess()).isTrue();
        assertThat(depositAddress.getResult()).isNotNull();
    }

    @Test
    public void getOrder() throws Exception {
        ApiResult<Order> order = api.getOrder("1234");
        assertThat(order).isNotNull();
        assertThat(order.isSuccess()).isTrue();
        assertThat(order.getResult()).isNotNull();
    }

    @Test
    public void getOrderHistory() throws Exception {
        ApiResult<List<OrderHistoryEntry>> orderHistory = api.getOrderHistory();
        assertThat(orderHistory).isNotNull();
        assertThat(orderHistory.isSuccess()).isTrue();
        assertThat(orderHistory.getResult()).isNotEmpty();
    }

    @Test
    public void getOrderHistoryForMarket() throws Exception {
        ApiResult<List<OrderHistoryEntry>> orderHistory = api.getOrderHistory(MARKET);
        assertThat(orderHistory).isNotNull();
        assertThat(orderHistory.isSuccess()).isTrue();
        assertThat(orderHistory.getResult()).isNotEmpty();
    }

    @Test
    public void getWithdrawalHistory() throws Exception {
        ApiResult<List<WithdrawalHistoryEntry>> orderHistory = api.getWithdrawalHistory();
        assertThat(orderHistory).isNotNull();
        assertThat(orderHistory.isSuccess()).isTrue();
        assertThat(orderHistory.getResult()).isNotEmpty();
    }

    @Test
    public void getWithdrawalHistoryForMarket() throws Exception {
        ApiResult<List<WithdrawalHistoryEntry>> orderHistory = api.getWithdrawalHistory(CURRENCY);
        assertThat(orderHistory).isNotNull();
        assertThat(orderHistory.isSuccess()).isTrue();
        assertThat(orderHistory.getResult()).isNotEmpty();
    }

    @Test
    public void getDepositHistory() throws Exception {
        ApiResult<List<DepositHistoryEntry>> depositHistory = api.getDepositHistory();
        assertThat(depositHistory).isNotNull();
        assertThat(depositHistory.isSuccess()).isTrue();
        assertThat(depositHistory.getResult()).isNotEmpty();
    }

    @Test
    public void getDepositHistoryForCurrency() throws Exception {
        ApiResult<List<DepositHistoryEntry>> depositHistory = api.getDepositHistory(CURRENCY);
        assertThat(depositHistory).isNotNull();
        assertThat(depositHistory.isSuccess()).isTrue();
        assertThat(depositHistory.getResult()).isNotEmpty();
    }


    @Test
    public void withdraw() throws Exception {
        ApiResult<WithdrawalRequested> depositHistory = api.withdraw(
                CURRENCY,
                BigDecimal.valueOf(11.0),
                "BTC_ADDRESS");
        assertThat(depositHistory).isNotNull();
        assertThat(depositHistory.isSuccess()).isTrue();
        assertThat(depositHistory.getResult()).isNotNull();
    }


    @Test
    public void withdrawWithPaymentId() throws Exception {
        ApiResult<WithdrawalRequested> depositHistory = api.withdraw(
                CURRENCY,
                BigDecimal.valueOf(11.0),
                "BTC_ADDRESS",
                "note"
        );
        assertThat(depositHistory).isNotNull();
        assertThat(depositHistory.isSuccess()).isTrue();
        assertThat(depositHistory.getResult()).isNotNull();
    }



}