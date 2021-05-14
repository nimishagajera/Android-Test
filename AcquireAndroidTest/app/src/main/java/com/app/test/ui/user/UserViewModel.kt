package com.app.test.ui.user

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.test.data.repository.DataRepository
import com.app.test.model.State
import com.app.test.model.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class UserViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    private val _userLiveData = MutableLiveData<State<List<User>>>()

    val userLiveData: LiveData<State<List<User>>>
        get() = _userLiveData

    fun getUsers() {
        viewModelScope.launch {
            dataRepository.getAllUsers().collect {
                _userLiveData.value = it
            }
        }
    }


}