package com.example.study_vmlivedata1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType { //액션 타입 지정
    UP,DOWN
}

class MainViewModel : ViewModel() {

    // 변경가능한 Mutable 타입의 LiveData
    private val _currentValue = MutableLiveData<Int>()

    // 라이브 데이터 값에 접근할수 있는 getter 생성
    val currentValue : LiveData<Int>
        get() = _currentValue

    //데이터 초기값 지정
    init {
        _currentValue.value = 0
    }

    // setter 생성
    fun updateValue(type: ActionType) {
        when(type) {
            ActionType.UP -> //액션 타입이 증가 일때
                _currentValue.value = _currentValue.value?.plus(1)// 1 증가
            ActionType.DOWN -> //액션 타입이 감소 일때
                _currentValue.value = _currentValue.value?.minus(1)// 1 감소
        }
    }
}