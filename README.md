# bittrex-java-client - ApiVersion v1.1

Java client for the bittrex.com Api

ApiSpec: https://bittrex.com/home/api

## Implementation Progess

### Public Api
- [X] /public/getmarkets
- [X] /public/getcurrencies
- [X] /public/getticker
- [X] /public/getmarketsummaries
- [X] /public/getmarketsummary
- [X] /public/getorderbook
- [X] /public/getmarkethistory

### Market Api (Only with Api-Key)
- [ ] /market/buylimit
- [ ] /market/selllimit
- [ ] /market/cancel
- [X] /market/getopenorders

### Account Api (Only with Api-Key)
- [X] /account/getbalances
- [X] /account/getbalance
- [X] /account/getdepositaddress
- [X] /account/withdraw
- [X] /account/getorder
- [X] /account/getorderhistory
- [X] /account/getwithdrawalhistory 
- [X] /account/getdeposithistory

### Stability
- [ ] Unit tests
- [ ] Integratien tests with real Bittrex Api
- [ ] Usage in real world applications


## Example 1: PublicApi without credentials

```java

    BittrexClient bittrexClient = new BittrexClient(); 

    ApiResult<List<Market>> apiResult = bittrexClient.getPublicApi().getMarkets();
    
    if (result.isSuccess()) {
      List<Market> markets = apiResult.result();
    }
```

## Example 2: MarketApi with credentials

```java

    ApiCredentials credentials = new ApiCredentials( 
      "YourApiKeyFromBittrex.com", 
      "YourApiKeySecretFromBittrex.com" 
    ); 
        
    BittrexClient bittrexClient = new BittrexClient(credentials); 

    ApiResult<List<OpenOrder>> apiResult = bittrexClient.getMarketApi().getOpenOrders();
    
    if (result.isSuccess()) {
      List<OpenOrder> openOrders = apiResult.result();
    }
```
l
