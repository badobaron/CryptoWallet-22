package org.kjpm.com.cryptowallet;

/**
 * Created by kemjohnmantos on 22/06/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("total_received")
    @Expose
    private long totalReceived;
    @SerializedName("total_sent")
    @Expose
    private long totalSent;
    @SerializedName("balance")
    @Expose
    private long balance;
    @SerializedName("unconfirmed_balance")
    @Expose
    private long unconfirmedBalance;
    @SerializedName("final_balance")
    @Expose
    private long finalBalance;
    @SerializedName("n_tx")
    @Expose
    private long nTx;
    @SerializedName("unconfirmed_n_tx")
    @Expose
    private long unconfirmedNTx;
    @SerializedName("final_n_tx")
    @Expose
    private long finalNTx;

    /**
     * No args constructor for use in serialization
     *
     */
    public Currency() {
    }

    /**
     *
     * @param balance
     * @param address
     * @param unconfirmedNTx
     * @param unconfirmedBalance
     * @param totalReceived
     * @param totalSent
     * @param finalNTx
     * @param nTx
     * @param finalBalance
     */
    public Currency(String address, long totalReceived, long totalSent, long balance, long unconfirmedBalance, long finalBalance, long nTx, long unconfirmedNTx, long finalNTx) {
        super();
        this.address = address;
        this.totalReceived = totalReceived;
        this.totalSent = totalSent;
        this.balance = balance;
        this.unconfirmedBalance = unconfirmedBalance;
        this.finalBalance = finalBalance;
        this.nTx = nTx;
        this.unconfirmedNTx = unconfirmedNTx;
        this.finalNTx = finalNTx;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(long totalReceived) {
        this.totalReceived = totalReceived;
    }

    public long getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(long totalSent) {
        this.totalSent = totalSent;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public void setUnconfirmedBalance(long unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    public long getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(long finalBalance) {
        this.finalBalance = finalBalance;
    }

    public long getNTx() {
        return nTx;
    }

    public void setNTx(long nTx) {
        this.nTx = nTx;
    }

    public long getUnconfirmedNTx() {
        return unconfirmedNTx;
    }

    public void setUnconfirmedNTx(long unconfirmedNTx) {
        this.unconfirmedNTx = unconfirmedNTx;
    }

    public long getFinalNTx() {
        return finalNTx;
    }

    public void setFinalNTx(long finalNTx) {
        this.finalNTx = finalNTx;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "address='" + address + '\'' +
                ", totalReceived=" + totalReceived +
                ", totalSent=" + totalSent +
                ", balance=" + balance +
                ", unconfirmedBalance=" + unconfirmedBalance +
                ", finalBalance=" + finalBalance +
                ", nTx=" + nTx +
                ", unconfirmedNTx=" + unconfirmedNTx +
                ", finalNTx=" + finalNTx +
                '}';
    }
}