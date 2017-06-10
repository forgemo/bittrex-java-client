package de.elbatya.cryptocoins.bittrexclient.api;

import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
import de.elbatya.cryptocoins.bittrexclient.api.model.marketapi.OpenOrder;
import de.elbatya.cryptocoins.bittrexclient.api.model.publicapi.OrderBook;
import de.elbatya.cryptocoins.bittrexclient.api.model.publicapi.OrderBookType;
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

}
