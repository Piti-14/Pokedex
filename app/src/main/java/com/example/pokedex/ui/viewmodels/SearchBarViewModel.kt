package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchBarViewModel: ViewModel() {

    private var _search = MutableLiveData<String>()
    val search: LiveData<String> = _search

    private var _isSearching = MutableLiveData<String>()


}