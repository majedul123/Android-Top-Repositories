package com.majedul.assignment.ui.views

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majedul.assignment.data.model.Items
import com.majedul.assignment.data.repository.DataRepository
import com.majedul.assignment.ui.base.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SearchViewModel(private val topHeadlineRepository: DataRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Items>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Items>>> = _uiState
    val TAG = "SearchViewModel"

    init {
        fetchSearchData()
    }

    private fun fetchSearchData() {
        Log.d(TAG," on fetchSearchData method")
        viewModelScope.launch {
            topHeadlineRepository.getSearchItems("android","stars")
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    Log.d(TAG," on fetchSearchData item List $it")
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}