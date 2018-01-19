package de.elbatya.cryptocoins.bittrexclient.api;

import de.elbatya.cryptocoins.bittrexclient.api.model.accountapi.*;
import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
import feign.Param;
import feign.RequestLine;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author contact@elbatya.de
 */
public interface BittrexAccountApi {

    @RequestLine("GET /account/getbalances")
    ApiResult<List<Balance>> getBalances();

    @RequestLine("GET /account/getbalance?currency={currency}")
    ApiResult<Balance> getBalance(@Param("currency") String currency);

    @RequestLine("GET /account/getdepositaddress?currency={currency}")
    ApiResult<DepositAddress> getDepositAddress(@Param("currency") String currency);

    @RequestLine("GET /account/withdraw?currency={currency}&quantity={quantity}&address={address}&paymentid={paymentid}")
    ApiResult<WithdrawalRequested> withdraw(
            @Param("currency") String currency,
            @Param("quantity") BigDecimal quantity,
            @Param("address") String address,
            @Param("paymentid") String paymentId
    );

    @RequestLine("GET /account/withdraw?currency={currency}&quantity={quantity}&address={address}")
    ApiResult<WithdrawalRequested> withdraw(
            @Param("currency") String currency,
            @Param("quantity") BigDecimal quantity,
            @Param("address") String address
    );

    @RequestLine("GET /account/getorder?uuid={uuid}")
    ApiResult<Order> getOrder(@Param("uuid") String uuid);

    @RequestLine("GET /account/getorderhistory?market={market}")
    ApiResult<List<OrderHistoryEntry>> getOrderHistory(@Param("market") String market);

    @RequestLine("GET /account/getorderhistory")
    ApiResult<List<OrderHistoryEntry>> getOrderHistory();

    @RequestLine("GET /account/getwithdrawalhistory?currency={currency}")
    ApiResult<List<WithdrawalHistoryEntry>> getWithdrawalHistory(@Param("currency") String currency);

    @RequestLine("GET /account/getwithdrawalhistory")
    ApiResult<List<WithdrawalHistoryEntry>> getWithdrawalHistory();

    @RequestLine("GET /account/getdeposithistory?currency={currency}")
    ApiResult<List<DepositHistoryEntry>> getDepositHistory(@Param("currency") String currency);

    @RequestLine("GET /account/getdeposithistory")
    ApiResult<List<DepositHistoryEntry>> getDepositHistory();

}
