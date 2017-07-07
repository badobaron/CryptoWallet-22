package android.kjpm.com.cryptowallet;

/**
 * Created by kemjohnmantos on 22/06/2017.
 */
public class Currency {
    private String address;
    private String total_received;
    private String total_sent;
    private String balance;
    private String unconfirmed_balance;
    private String final_balance;
    private String n_tx;
    private String unconfirmed_n_tx;
    private String final_n_tx;

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getTotalReceived() { return total_received; }
    public void setTotalReceived(String total_received) { this.total_received = total_received; }

    public String getTotalSent() { return total_sent; }
    public void setTotalSent(String total_sent) { this.total_sent = total_sent; }

    public String getBalance() { return balance; }
    public void setBalance(String balance) { this.balance = balance; }

    public String getUnconfirmedBalance() { return unconfirmed_balance; }
    public void setUnconfirmedBalance(String unconfirmed_balance) { this.unconfirmed_balance = unconfirmed_balance; }

    public String getFinalBalance() { return final_balance; }
    public void setFinalBalance(String final_balance) { this.final_balance = final_balance; }

    public String getNtx() { return n_tx; }
    public void setNtx(String n_tx) { this.n_tx = n_tx; }

    public String getUnconfirmedNtx() { return unconfirmed_n_tx; }
    public void setUnconfirmedNtx(String unconfirmed_n_tx) { this.unconfirmed_n_tx = unconfirmed_n_tx; }

    public String getFinalNtx() { return final_n_tx; }
    public void setFinalNtx(String final_n_tx) { this.final_n_tx = final_n_tx; }

}
