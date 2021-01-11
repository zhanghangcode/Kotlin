package com.example.app

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_select.*

/**
 * @Date 執筆時間 2021/01/11 18:49
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */
class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)



        packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
                .filterNot { it.name == this::class.java.name }
                .map { Class.forName(it.name) }
                .forEach { clazz ->
                    linearLayout.addView(AppCompatButton(this).apply {
                        isAllCaps = false
                        text = clazz.simpleName
                        setOnClickListener {
                            startActivity(Intent(this@SelectActivity, clazz))
                        }
                    })
                }
    }
}