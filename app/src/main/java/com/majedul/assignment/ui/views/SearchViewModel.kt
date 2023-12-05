package com.majedul.assignment.ui.views

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

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            topHeadlineRepository.getSearchItems("android","star")
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}