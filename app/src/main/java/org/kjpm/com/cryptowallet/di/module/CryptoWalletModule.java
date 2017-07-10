package org.kjpm.com.cryptowallet.di.module;

import org.kjpm.com.cryptowallet.models.service.CryptoWalletService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shortcut on 7/9/2017.
 */
@Module(includes =  NetworkModule.class)
public class CryptoWalletModule {
    private final String API_ENDPOINT = "http://cryptowallet.tk/";

    @Provides
    @Singleton
    public CryptoWalletService getCryptoWalletService(Retrofit crytpWalletRetrofit) {
        return crytpWalletRetrofit.create(CryptoWalletService.class);
    }

    @Provides
    @Singleton
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(API_ENDPOINT)
                .build();
    }
}
