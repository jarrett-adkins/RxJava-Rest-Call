package com.example.admin.rxjava.data.remote;

import com.example.admin.rxjava.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RemoteService {

    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String username);
}
