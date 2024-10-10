import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ir.dunijet.dunibazaar.model.repository.user.UserRepository

class ProfileViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val email = mutableStateOf("")
    val address = mutableStateOf("")
    val postalCode = mutableStateOf("")
    val loginTime = mutableStateOf("")
    val password = mutableStateOf("")

    val showLocationDialog = mutableStateOf(false)


    fun loadUserData() {
        email.value = userRepository.getUserName()!!
        loginTime.value = userRepository.getUserLoginTime()
        password.value = userRepository.getUserPassword()

        val location = userRepository.getUserLocation()
        address.value = location.first
        postalCode.value = location.second
    }

    fun signOut() {
        userRepository.signOut()
    }

    fun setUserLocation(address: String, postalCode: String) {
        userRepository.saveUserLocation(address, postalCode)
    }

    fun setUserPassword(newPassword: String) {
        userRepository.saveUserPassword(newPassword)
        password.value = newPassword // Update UI after password change
    }

}
