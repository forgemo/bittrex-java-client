package de.elbatya.cryptocoins.bittrexclient.api.model.accountapi;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author contact@elbatya.de
 */
public class Order {
    private String accountId;
    private String orderUuid;
    private String exchange;
    private String type;
    private BigDecimal quantity;
    private BigDecimal quantityRemaining;
    private BigDecimal limit;
    private BigDecimal reserved;
    private BigDecimal reserveRemaining;
    private BigDecimal commissionReserved;
    private BigDecimal commissionReserveRemaining;
    private BigDecimal commissionPaid;
    private BigDecimal price;
    private BigDecimal pricePerUnit;
    private LocalDateTime opened;
    private LocalDateTime closed;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(BigDecimal quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getReserved() {
        return reserved;
    }

    public void setReserved(BigDecimal reserved) {
        this.reserved = reserved;
    }

    public BigDecimal getReserveRemaining() {
        return reserveRemaining;
    }

    public void setReserveRemaining(BigDecimal reserveRemaining) {
        this.reserveRemaining = reserveRemaining;
    }

    public BigDecimal getCommissionReserved() {
        return commissionReserved;
    }

    public void setCommissionReserved(BigDecimal commissionReserved) {
        this.commissionReserved = commissionReserved;
    }

    public BigDecimal getCommissionReserveRemaining() {
        return commissionReserveRemaining;
    }

    public void setCommissionReserveRemaining(BigDecimal commissionReserveRemaining) {
        this.commissionReserveRemaining = commissionReserveRemaining;
    }

    public BigDecimal getCommissionPaid() {
        return commissionPaid;
    }

    public void setCommissionPaid(BigDecimal commissionPaid) {
        this.commissionPaid = commissionPaid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public LocalDateTime getOpened() {
        return opened;
    }

    public void setOpened(LocalDateTime opened) {
        this.opened = opened;
    }

    public LocalDateTime getClosed() {
        return closed;
    }

    public void setClosed(LocalDateTime closed) {
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
