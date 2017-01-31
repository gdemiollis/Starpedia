package fr.and1droid.starpedia;

import com.swapi.models.Planet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseService<E> {

    public BaseService() {
    }

    public void execute(final RequestCallback<E> callback) {
        Flowable.fromCallable(new Callable<E>() {
            @Override
            public E call() throws Exception {
                return invoke();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<E>() {
                    @Override
                    public void accept(E result) throws Exception {
                        callback.onSuccess(result);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFail(throwable);
                    }
                });
    }

    protected abstract E invoke() throws IOException;
}
