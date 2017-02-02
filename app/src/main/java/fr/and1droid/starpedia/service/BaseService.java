package fr.and1droid.starpedia.service;

public interface BaseService<E> {
    void list(RequestCallback<E> requestCallback);
}
