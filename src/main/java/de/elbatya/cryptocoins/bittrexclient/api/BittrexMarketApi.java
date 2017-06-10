package de.elbatya.cryptocoins.bittrexclient.api;

import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
import de.elbatya.cryptocoins.bittrexclient.api.model.marketapi.OpenOrder;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @author contact@elbatya.de
 */
public interface BittrexMarketApi {

    @RequestLine("GET /market/getopenorders")
    ApiResult<List<OpenOrder>> getOpenOrders();

    @RequestLine("GET /market/getopenorders?market={market}")
    ApiResult<List<OpenOrder>> getOpenOrders(@Param("market") String market);

    @RequestLine("GET /market/cancel?uuid={orderUuid}")
    ApiResult<Void> cancelOrder(@Param("orderUuid") String orderUuid);


}
