package com.xwurfel.forecast.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xwurfel.forecast.domain.error_handling.AuthRepository
import com.xwurfel.forecast.domain.error_handling.Result
import com.xwurfel.forecast.domain.error_handling.UserDataValidator
import com.xwurfel.forecast.domain.repository.WeatherForecastRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UseViewModel @Inject constructor(
    val userDataValidator: UserDataValidator,
    val authRepository: AuthRepository,
    private val repository: Lazy<WeatherForecastRepository>
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
            when (val result = authRepository.register(password)){
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
