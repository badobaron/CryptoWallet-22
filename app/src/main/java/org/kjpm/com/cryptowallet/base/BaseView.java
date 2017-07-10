package org.kjpm.com.cryptowallet.base;

/**
 * Created by shortcut on 7/8/2017.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showToast(String message);
}
