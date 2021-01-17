package com.example.app

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.threadrxjava.Api
import com.example.app.threadrxjava.model.Repo
import com.example.app.ui.dp
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_myui.*
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
        drawBadge()


//        val bottomFlipAnimator=ObjectAnimator.ofFloat(view,"bottomFilp",60f)
//        bottomFlipAnimator.startDelay=1000
//        bottomFlipAnimator.duration=1000

//        val flipFlipAnimator=ObjectAnimator.ofFloat(view,"flipRotation",270f)
//        flipFlipAnimator.startDelay=200
//        flipFlipAnimator.duration=1000
//
//        val topFlipAnimator=ObjectAnimator.ofFloat(view,"topFlip",-60f)
//        topFlipAnimator.startDelay=200
//        topFlipAnimator.duration=1000
//
//        val animatorSet=AnimatorSet()
//        animatorSet.playSequentially(bottomFlipAnimator,flipFlipAnimator,topFlipAnimator)
//        animatorSet.start()
//
//        val bottomFlipAHolder=PropertyValuesHolder.ofFloat("bottomFilp",60f)
//        val flipFlipAHolder=PropertyValuesHolder.ofFloat("flipRotation",270f)
//        val topFlipAHolder=PropertyValuesHolder.ofFloat("topFlip",-60f)
//
//        val holderAnimator=ObjectAnimator.ofPropertyValuesHolder(view,bottomFlipAHolder,flipFlipAHolder,topFlipAHolder)
//        holderAnimator.startDelay=1000
//        holderAnimator.duration=2000
//        holderAnimator.start()

        val length=200.dp
        val keyframe1=Keyframe.ofFloat(0f,0f)
        val keyframe2=Keyframe.ofFloat(1.2f,0.4f*length)
        val keyframe3=Keyframe.ofFloat(0.8f,0.6f*length)
        val keyframe4=Keyframe.ofFloat(1f,1f*length)

        val keyframeHolder=PropertyValuesHolder.ofKeyframe("translationX",keyframe1,keyframe2,keyframe3,keyframe4)

        val animator=ObjectAnimator.ofPropertyValuesHolder(view,keyframeHolder)
        animator.startDelay=1000
        animator.duration=2000
        animator.start()
    }


//        val single:Single<Int> = Single.just(1)
//        val singleString=single.map(object : Function<Int,String>{
//            override fun apply(t: Int?): String {
//                return t.toString()
//            }
//
//        })
//
//
//        singleString.subscribe(object :SingleObserver<String?>{
//            override fun onSuccess(t: String?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onSubscribe(d: Disposable?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onError(e: Throwable?) {
//                TODO("Not yet implemented")
//            }
//
//        })

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


    override fun onDestroy() {
        disposable?.isDisposed
        super.onDestroy()
    }
}



