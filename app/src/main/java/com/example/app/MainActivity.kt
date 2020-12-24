package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.toast
import com.example.lesson.LessonActivity

class MainActivity:AppCompatActivity(), View.OnClickListener {

    private val usernameKey:String="username"
    private val passwordKey:String="password"

    lateinit var et_username:EditText
    lateinit var et_password:EditText
    lateinit var et_code:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        et_username=findViewById<EditText>(R.id.et_username)
        et_password=findViewById<EditText>(R.id.et_password)
        et_code=findViewById<EditText>(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        val btn_login: Button? = findViewById<Button?>(R.id.btn_login)
        val img_code: CodeView? = findViewById<CodeView?>(R.id.code_view)
        btn_login?.setOnClickListener(this)
        img_code?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView){
            v.updateCode()
        }else if (v is Button){
            login()
        }
    }

    private fun login(){
       var username:String= et_username.text.toString()
       var password:String= et_password.text.toString()
       var code:String= et_code.text.toString()

        var user:User= User(username,password,code)
        if (verify(user)){
            CacheUtils.save(usernameKey,username)
            CacheUtils.save(passwordKey,password)
            startActivity(Intent(this,LessonActivity::class.java))
        }
    }

    private fun verify(user: User):Boolean{
        if (user.username!=null && user.username!!.length >4){
            toast("用户名不合法")
            return false
        }
        if (user.password!=null && user.password!!.length >4){
            toast("密码不合法")
            return false
        }
        return true

    }
}