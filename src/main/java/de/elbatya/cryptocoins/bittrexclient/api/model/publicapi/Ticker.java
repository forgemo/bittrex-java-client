package de.elbatya.cryptocoins.bittrexclient.api.model.publicapi;

/**
 * @author contact@elbatya.de
 */
public class Ticker {

    private Double bid;
    private Double ask;
    private Double last;

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

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }
}
