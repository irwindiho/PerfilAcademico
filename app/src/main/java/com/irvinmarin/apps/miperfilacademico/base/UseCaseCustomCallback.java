package com.irvinmarin.apps.miperfilacademico.base;

/**
 * Created by @stevecampos on 18/01/2018.
 */

public abstract class UseCaseCustomCallback<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue, C extends UseCase.UseCaseCallback<P>> extends UseCase<Q, P> {

    private C customCallback;

    public C getCustomCallback() {
        return customCallback;
    }

    public void setCustomCallback(C customCallback) {
        this.customCallback = customCallback;
    }
}
