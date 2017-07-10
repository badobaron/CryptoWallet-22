package org.kjpm.com.cryptowallet.models.service;

import org.kjpm.com.cryptowallet.Currency;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shortcut on 7/9/2017.
 */

public interface CryptoWalletService {
    @GET("addr/DASH/Xv3r6aNDW9q2DEhwtZ3Yg8rXrQHdBk37d5/balance")
    Call<Currency> getWallet();
}
