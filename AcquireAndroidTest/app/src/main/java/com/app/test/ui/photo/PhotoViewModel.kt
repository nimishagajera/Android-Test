package com.app.test.ui.photo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.test.data.repository.DataRepository
import com.app.test.model.Photo
import com.app.test.model.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class PhotoViewModel @ViewModelInject constructor(private val dataRepository: DataRepository):
    ViewModel(){

    private val _photoLiveData = MutableLiveData<State<List<Photo>>>()

    val photoLiveData: LiveData<State<List<Photo>>>
        get() = _photoLiveData

    fun getPhotos(){
        viewModelScope.launch {
            dataRepository.getAllImages().collect {
                _photoLiveData.value = it
            }
        }
    }
}