package com.example.app.hilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @Date 執筆時間 2021/01/11 19:59
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */
@AndroidEntryPoint
class HiltFragment : Fragment() {

    // 使用 @Inject 注解从组件中获取依赖
    @Inject
    lateinit var mHiltSimple: HiltSimple

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hilt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHiltSimple.doSomething()
    }
}