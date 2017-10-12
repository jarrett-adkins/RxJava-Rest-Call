package com.example.admin.rxjava.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class RxJavaRange {

    public static void main(String[] args) {
        Observable<Integer> integerObservable = Observable.range( 1, 10 );

        Observer<Integer>integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println( "onSubscribe" );
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println( "onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println( "onError" + e.toString() );
            }

            @Override
            public void onComplete() {
                System.out.println( "onComplete" );
            }
        };

        integerObservable
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        return integer > 5;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        return integer*10;
                    }
                }).map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        return integer / 10;
                    }
                })
                .take(3)
                .subscribe( integerObserver );
    }
}

//reactive - example, rest call. when do you want to react? how much time wil it take? With observer,
//you don't have to keep checking if it's ready, it does it on it's own.