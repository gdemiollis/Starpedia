package fr.and1droid.starpedia;

import com.swapi.http.PlanetApi;
import com.swapi.models.Planet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseService<E> {
    private RequestCallback<E> callback;

    public BaseService(RequestCallback<E> callback) {
        this.callback = callback;
    }

    public void invoke() {
        final PlanetApi planetApi = new PlanetApi();
        Flowable.fromCallable(new Callable<E>() {
            @Override
            public E call() throws Exception {
                return execute();
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

    protected abstract E execute() throws IOException;
}
