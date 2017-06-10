package de.elbatya.cryptocoins.bittrexclient.api.model.accountapi;

import java.time.LocalDateTime;

/**
 * @author contact@elbatya.de
 */
public class Order {
    private String accountId;
    private String orderUuid;
    private String exchange;
    private String type;
    private Double quantity;
    private Double quantityRemaining;
    private Double limit;
    private Double reserved;
    private Double reserveRemaining;
    private Double commissionReserved;
    private Double commissionReserveRemaining;
    private Double commissionPaid;
    private Double price;
    private Double pricePerUnit;
    private LocalDateTime opened;
    private Boolean closed;
    private Boolean isOpen;
    private String sentinel;
    private Boolean cancelInitiated;
    private Boolean immediateOrCancel;
    private Boolean isConditional;
    private String condition;
    private String conditionTarget;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(Double quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getReserved() {
        return reserved;
    }

    public void setReserved(Double reserved) {
        this.reserved = reserved;
    }

    public Double getReserveRemaining() {
        return reserveRemaining;
    }

    public void setReserveRemaining(Double reserveRemaining) {
        this.reserveRemaining = reserveRemaining;
    }

    public Double getCommissionReserved() {
        return commissionReserved;
    }

    public void setCommissionReserved(Double commissionReserved) {
        this.commissionReserved = commissionReserved;
    }

    public Double getCommissionReserveRemaining() {
        return commissionReserveRemaining;
    }

    public void setCommissionReserveRemaining(Double commissionReserveRemaining) {
        this.commissionReserveRemaining = commissionReserveRemaining;
    }

    public Double getCommissionPaid() {
        return commissionPaid;
    }

    public void setCommissionPaid(Double commissionPaid) {
        this.commissionPaid = commissionPaid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public LocalDateTime getOpened() {
        return opened;
    }

    public void setOpened(LocalDateTime opened) {
        this.opened = opened;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean open) {
        isOpen = open;
    }

    public String getSentinel() {
        return sentinel;
    }

    public void setSentinel(String sentinel) {
        this.sentinel = sentinel;
    }

    public Boolean getCancelInitiated() {
        return cancelInitiated;
    }

    public void setCancelInitiated(Boolean cancelInitiated) {
        this.cancelInitiated = cancelInitiated;
    }

    public Boolean getImmediateOrCancel() {
        return immediateOrCancel;
    }

    public void setImmediateOrCancel(Boolean immediateOrCancel) {
        this.immediateOrCancel = immediateOrCancel;
    }

    public Boolean getIsConditional() {
        return isConditional;
    }

    public void setIsConditional(Boolean conditional) {
        isConditional = conditional;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionTarget() {
        return conditionTarget;
    }

    public void setConditionTarget(String conditionTarget) {
        this.conditionTarget = conditionTarget;
    }
}
