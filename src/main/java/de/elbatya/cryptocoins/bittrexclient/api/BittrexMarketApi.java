package de.elbatya.cryptocoins.bittrexclient.api;

import de.elbatya.cryptocoins.bittrexclient.api.model.common.ApiResult;
import de.elbatya.cryptocoins.bittrexclient.api.model.marketapi.OpenOrder;
import de.elbatya.cryptocoins.bittrexclient.api.model.marketapi.OrderCreated;
import feign.Param;
import feign.RequestLine;

import java.math.BigDecimal;
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

    @RequestLine("GET /market/selllimit?market={market}&quantity={quantity}&rate={rate}")
    ApiResult<OrderCreated> sellLimit(
            @Param("market") String market,
            @Param("quantity") BigDecimal quantity,
            @Param("rate") BigDecimal rate
    );

    @RequestLine("GET /market/buylimit?market={market}&quantity={quantity}&rate={rate}")
    ApiResult<OrderCreated> buyLimit(
            @Param("market") String market,
            @Param("quantity") BigDecimal quantity,
            @Param("rate") BigDecimal rate
    );


}
