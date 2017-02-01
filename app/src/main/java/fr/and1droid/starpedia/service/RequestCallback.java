package fr.and1droid.starpedia.service;

public interface RequestCallback<E> {

    void onSuccess(E result);

    void onFail(Throwable throwable);
}
