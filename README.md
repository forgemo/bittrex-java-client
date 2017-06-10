# bittrex-java-client - ApiVersion v1.1

Java client for the bittrex.com Api

ApiSpec: https://bittrex.com/home/api

## Implementation Status

### Public Api
- [X] /public/getmarkets
- [X] /public/getcurrencies
- [X] /public/getticker
- [X] /public/getmarketsummaries
- [X] /public/getmarketsummary
- [X] /public/getorderbook
- [X] /public/getmarkethistory

### Market Api (Credentials required)
- [ ] /market/buylimit 
- [ ] /market/selllimit
- [ ] /market/cancel
- [X] /market/getopenorders

### Account Api (Credentials required)
- [X] /account/getbalances
- [X] /account/getbalance
- [X] /account/getdepositaddress
- [ ] /account/withdraw
- [X] /account/getorder
- [X] /account/getorderhistory
- [X] /account/getwithdrawalhistory 
- [X] /account/getdeposithistory

### Stability
- [X] Public Api - Basic Unit Tests
- [ ] Market Api - Basic Unit Tests
- [ ] Account Api - Basic Unit Tests
- [ ] Public Api - Advanced Unit Tests
- [ ] Market Api - Advanced Unit Tests
- [ ] Account Api - Advanced Unit Tests
- [X] Public Api - Tested with production backend
- [ ] Market Api - Tested with production backend
- [ ] Account Api - Tested with production backend
- [ ] Used in real world applications


## Getting started with Maven
1. Clone this repository
2. Execute 'mvn install' to build the library and install it to your local maven repo
3. Add the following dependency to your pom.xml

```xml
    <dependency>
        <groupId>de.elbatya.cryptocoins</groupId>
        <artifactId>bittrex-client</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

## Example 1: List all Markets without credentials

```java

    // Create a BittrexClient
    BittrexClient bittrexClient = new BittrexClient(); 

    // Perform a getMarkets request on the public api
    ApiResult<List<Market>> apiResult = bittrexClient.getPublicApi().getMarkets();
    
    // Unwrap the results
    List<Market> markets = apiResult.unwrap();
```

## Example 2: List all your open orders using credentials

```java

    // Ceate ApiCredentials with ApiKey and Secret from bittrex.com
    ApiCredentials credentials = new ApiCredentials( 
      "YourApiKeyFromBittrex.com", 
      "YourApiKeySecretFromBittrex.com" 
    ); 
    
    // Create a BittrexClient with the ApiCredentials
    BittrexClient bittrexClient = new BittrexClient(credentials); 

    // Perform a getOpenOrders request on the market api    
    ApiResult<List<OpenOrder>> apiResult = bittrexClient.getMarketApi().getOpenOrders();
    
    // Unwrap the results
    List<OpenOrder> openOrders = apiResult.unwrap();
```

## How to get credentials for the non-public Bittrex api
1. Create an account at bittrex.com
2. Enable Two-Factor-Authentication in your account settings
3. Create an api key with the required permissions in your account settings
4. Use the api key and secret like shown in the examples
4. Read https://bittrex.com/home/api for more infos


## Do you like this library?
### Donate Bitcoins to [18rdYGVpG5BZ7EFRie65E9pfvMSE47EEfV](https://blockexplorer.com/address/18rdYGVpG5BZ7EFRie65E9pfvMSE47EEfV)
### Donate Ether to [0x10dcd290c3aa2393c005E981DED566C8fB75C182](https://etherscan.io/address/0x10dcd290c3aa2393c005E981DED566C8fB75C182)
