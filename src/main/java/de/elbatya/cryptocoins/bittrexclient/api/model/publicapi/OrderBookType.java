package de.elbatya.cryptocoins.bittrexclient.api.model.publicapi;

/**
 * @author contact@elbatya.de
 */
public enum OrderBookType {
    SELL, BUY, BOTH;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }


}
