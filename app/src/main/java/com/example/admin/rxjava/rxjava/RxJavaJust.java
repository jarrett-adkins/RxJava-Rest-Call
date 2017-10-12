package com.example.admin.rxjava.rxjava;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaJust {

    private static final String TAG = "RxJavaExample";

    public static void main(String[] args) {
        Observable<String> stringObservable = Observable.just( "first", "second", "third" );
        //just method admits these values, it just admits them, doesn't do anything fancy like the
        //other Observable methods. Like timer.

        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println( "onSubscribe:" + Thread.currentThread().getName() );
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println( "onNext: " + s + " " + Thread.currentThread().getName() );
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println( "onError: " + e.toString() );
            }

            @Override
            public void onComplete() {
                System.out.println( "onComplete: " + Thread.currentThread().getName() );
            }
        };

        stringObservable
                .observeOn( Schedulers.io() ) //on new thread. io thread is already running.
                //.subscribeOn(AndroidSchedulers.mainThread() ) //on the main thread
                .subscribe( stringObserver );
    }
}
