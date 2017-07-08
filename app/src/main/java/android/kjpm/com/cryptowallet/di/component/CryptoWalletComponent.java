package android.kjpm.com.cryptowallet.di.component;

import android.kjpm.com.cryptowallet.di.module.CryptoWalletModule;
import android.kjpm.com.cryptowallet.models.service.CryptoWalletService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shortcut on 7/9/2017.
 */
@Singleton
@Component(modules = CryptoWalletModule.class)
public interface CryptoWalletComponent {
    CryptoWalletService getCryptoWalletService();
}
