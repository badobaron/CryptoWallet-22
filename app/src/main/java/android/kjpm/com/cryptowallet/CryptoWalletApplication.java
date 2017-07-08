package android.kjpm.com.cryptowallet;

import android.app.Activity;
import android.app.Application;
import android.kjpm.com.cryptowallet.di.component.CryptoWalletComponent;
import android.kjpm.com.cryptowallet.di.component.DaggerCryptoWalletComponent;
import android.kjpm.com.cryptowallet.di.module.CryptoWalletModule;
import android.kjpm.com.cryptowallet.models.service.CryptoWalletService;
import android.widget.Toast;


/**
 * Created by shortcut on 7/8/2017.
 */

public class CryptoWalletApplication extends Application {

    private CryptoWalletComponent component;
    private CryptoWalletService cryptoWalletService;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerCryptoWalletComponent.builder()
                .cryptoWalletModule(new CryptoWalletModule())
                .build();
        cryptoWalletService = component.getCryptoWalletService();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static CryptoWalletApplication get(Activity activity) {
        return (CryptoWalletApplication)activity.getApplication();
    }

    public CryptoWalletComponent component() {
        return component;
    }

    public CryptoWalletService getCryptoWalletService() {
        return cryptoWalletService;
    }
}
