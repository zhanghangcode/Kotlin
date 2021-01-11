package com.example.app.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Date 執筆時間 2021/01/11 18:53
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */
@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, HiltFragment::class.java, null)
                .commit()
    }
}