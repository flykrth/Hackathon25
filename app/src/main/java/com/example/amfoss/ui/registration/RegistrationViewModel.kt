package com.example.amfoss.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amfoss.data.repository.RegistrationRepository
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: RegistrationRepository) : ViewModel() {

    var registrationState = mutableStateOf<RegistrationState>(RegistrationState.Idle)
        private set

    fun registerMember(
        rollNo: String,
        name: String,
        email: String,
        sex: String,
        year: Int,
        hostel: String,
        groupId: String
    ) {
        viewModelScope.launch {
            registrationState.value = RegistrationState.Loading
            val success = repository.registerMember(rollNo, name, email, sex, year, hostel, groupId)
            registrationState.value = if (success) RegistrationState.Success else RegistrationState.Error
        }
    }
}

sealed class RegistrationState {
    object Idle : RegistrationState()
    object Loading : RegistrationState()
    object Success : RegistrationState()
    object Error : RegistrationState()
}

