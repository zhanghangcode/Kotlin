package com.example.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.threadrxjava.Api
import com.example.app.threadrxjava.model.Repo
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.jvm.functions.FunctionN

class MyUiActivity:AppCompatActivity() {
    private lateinit var textView: TextView
    var disposable:Disposable?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myui)

        val single:Single<Int> = Single.just(1)
        val singleString=single.map(object : Function<Int,String>{
            override fun apply(t: Int?): String {
                return t.toString()
            }

        })


        singleString.subscribe(object :SingleObserver<String?>{
            override fun onSuccess(t: String?) {
                TODO("Not yet implemented")
            }

            override fun onSubscribe(d: Disposable?) {
                TODO("Not yet implemented")
            }

            override fun onError(e: Throwable?) {
                TODO("Not yet implemented")
            }

        })

//        textView=findViewById(R.id.textview)
//
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.github.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                .build()
//        val api = retrofit.create(Api::class.java)
//
//        api.getRepos("")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object :SingleObserver<MutableList<Repo>>{
//                    override fun onSuccess(t: MutableList<Repo>?) {
//                        textView="Result${t[0].name}"
//                    }
//
//                    override fun onSubscribe(d: Disposable?) {
//                        disposable=d
//
//                        textView.text=""
//                    }
//
//                    override fun onError(e: Throwable?) {
//                    }
//
//
//                })
    }

    override fun onDestroy() {
        disposable?.isDisposed
        super.onDestroy()
    }
}



