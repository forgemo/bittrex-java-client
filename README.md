[![Build Status](https://travis-ci.org/forgemo/bittrex-java-client.svg?branch=develop)](https://travis-ci.org/forgemo/bittrex-java-client)

# bittrex-java-client

Java client for the bittrex.com api.
It uses the api version 1.1.

ApiSpec: https://bittrex.com/home/api

Warning! This library is fairly young and **not considered stable**. 
Use it with caution ... especially the market api.

## Breaking change in 2.0
For greater precision, double values have been replaced by BigDecimal.

## Getting started

### Building from code with Maven (preferred)
1. Clone this repository
2. Execute 'mvn install' to build the library and install it to your local maven repo
3. Add the following dependency to your projects pom.xml

    ```xml
    <dependency>
        <groupId>de.elbatya.cryptocoins</groupId>
        <artifactId>bittrex-client</artifactId>
        <version>2.0</version>
    </dependency>
    ```
### Prebuild binaries via JitPack
Note: Using JitPack is more convenient but less secure. There is no mechanism in place to ensure the authenticity of a downloaded artifact.

#### Maven via JitPack
1. Add the JitPack repository to your build file.
    
    ```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    ```

2. Add the dependency

    ```xml
    <dependency>
        <groupId>com.github.forgemo</groupId>
        <artifactId>bittrex-java-client</artifactId>
        <version>v2.0</version>
    </dependency>
    ```
        


#### Gradle via JitPack 
1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

    ```groovy        
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    ``` 

2. Add the dependency

    ```groovy
    dependencies {
       compile 'com.github.forgemo:bittrex-java-client:v2.0'
    }
    ```

#### Others via JitPack
https://jitpack.io/#forgemo/bittrex-java-client/v2.0


## Examples

### List all markets without credentials

```java

    // Create a BittrexClient
    BittrexClient bittrexClient = new BittrexClient(); 

    // Perform a getMarkets request on the public api
    ApiResult<List<Market>> apiResult = bittrexClient.getPublicApi().getMarkets();
    
    // Unwrap the results
    List<Market> markets = apiResult.unwrap();
```


### List all your open orders using credentials

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
- [X] /market/buylimit 
- [X] /market/selllimit
- [X] /market/cancel
- [X] /market/getopenorders

### Account Api (Credentials required)
- [X] /account/getbalances
- [X] /account/getbalance
- [X] /account/getdepositaddress
- [X] /account/withdraw
- [X] /account/getorder
- [X] /account/getorderhistory
- [X] /account/getwithdrawalhistory 
- [X] /account/getdeposithistory

### Stability
- [X] Public Api - Basic Unit Tests
- [X] Market Api - Basic Unit Tests
- [X] Account Api - Basic Unit Tests
- [ ] Public Api - Advanced Unit Tests
- [ ] Market Api - Advanced Unit Tests
- [ ] Account Api - Advanced Unit Tests
- [X] Public Api - Tested with production backend
- [X] Market Api - Tested with production backend
- [X] Account Api - Tested with production backend
- [X] Used in low budget / low risk real world applications 
- [ ] Used in real world applications

## Do you like this library?
### Donate Bitcoins to [18rdYGVpG5BZ7EFRie65E9pfvMSE47EEfV](https://blockexplorer.com/address/18rdYGVpG5BZ7EFRie65E9pfvMSE47EEfV)
### Donate Ether to [0x10dcd290c3aa2393c005E981DED566C8fB75C182](https://etherscan.io/address/0x10dcd290c3aa2393c005E981DED566C8fB75C182)
