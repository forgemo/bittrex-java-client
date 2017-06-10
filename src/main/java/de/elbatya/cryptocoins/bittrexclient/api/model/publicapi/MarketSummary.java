package de.elbatya.cryptocoins.bittrexclient.api.model.publicapi;

import java.time.LocalDateTime;

/**
 * @author contact@elbatya.de
 */
public class MarketSummary {

    private String marketName;
    private Double high;
    private Double low;
    private Double volume;
    private Double last;
    private Double baseVolume;
    private LocalDateTime timeStamp;
    private Double bid;
    private Double ask;
    private Integer openBuyOrders;
    private Integer openSellOrders;
    private Double prevDay;
    private LocalDateTime created;

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(Double baseVolume) {
        this.baseVolume = baseVolume;
    }


    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Integer getOpenBuyOrders() {
        return openBuyOrders;
    }

    public void setOpenBuyOrders(Integer openBuyOrders) {
        this.openBuyOrders = openBuyOrders;
    }

    public Integer getOpenSellOrders() {
        return openSellOrders;
    }

    public void setOpenSellOrders(Integer openSellOrders) {
        this.openSellOrders = openSellOrders;
    }

    public Double getPrevDay() {
        return prevDay;
    }

    public void setPrevDay(Double prevDay) {
        this.prevDay = prevDay;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
