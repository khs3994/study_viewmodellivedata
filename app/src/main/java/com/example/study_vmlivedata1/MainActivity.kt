package com.example.study_vmlivedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.study_vmlivedata1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // 데이터 바인딩 추가
    private lateinit var binding: ActivityMainBinding

    //뷰모델 선언
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //뷰모델 가져오기
        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        // observer 사용 데이터 값이 변경되면 호출
        vm.currentValue.observe(this, Observer {
            //값 변경
            binding.textview.text = it.toString()
        })

        binding.up.setOnClickListener(this)
        binding.down.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.up ->
                vm.updateValue(ActionType.UP)
            binding.down ->
                vm.updateValue(ActionType.DOWN)
        }
    }
}