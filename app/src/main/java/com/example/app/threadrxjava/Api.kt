package com.example.app.threadrxjava

import com.example.app.threadrxjava.model.Repo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

 interface Api {

    @GET("users/{username}/repos")
    open fun getRepos(@Path("username") username: String?): Single<MutableList<Repo>>
}