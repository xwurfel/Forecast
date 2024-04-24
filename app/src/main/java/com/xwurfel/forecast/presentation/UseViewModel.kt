package com.xwurfel.forecast.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xwurfel.forecast.domain.error_handling.AuthRepository
import com.xwurfel.forecast.domain.error_handling.DataError
import com.xwurfel.forecast.domain.error_handling.Result
import com.xwurfel.forecast.domain.error_handling.UserDataValidator
import kotlinx.coroutines.launch

class UseViewModel(
    val userDataValidator: UserDataValidator,
    val repository: AuthRepository
): ViewModel() {

    fun onRegister(password: String) {
        when(val result = userDataValidator.validatePassword(password)) {
            is Result.Error -> {
                when (result.error) {
                    UserDataValidator.PasswordError.TOO_SHORT -> TODO()
                    UserDataValidator.PasswordError.NO_UPPERCASE -> TODO()
                    UserDataValidator.PasswordError.NO_DIGIT -> TODO()
                }
            }
            is Result.Success -> {

            }
        }

       viewModelScope.launch {
            when (val result = repository.register(password)){
                is Result.Error -> {
                        val errorMesagge = result.error.asUiText()
                }
                is Result.Success -> {
                    result.data
                }
            }
        }
    }
}
