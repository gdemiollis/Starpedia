package fr.and1droid.starpedia;

public interface RequestCallback<E> {

    void onSuccess(E result);

    void onFail(Throwable throwable);
}
