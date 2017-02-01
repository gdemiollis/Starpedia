package fr.and1droid.starpedia.service;

public interface BaseService<E> {
    void execute(RequestCallback<E> requestCallback);
}
