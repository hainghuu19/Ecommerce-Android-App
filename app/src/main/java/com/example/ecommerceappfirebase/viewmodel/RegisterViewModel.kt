package com.example.ecommerceappfirebase.viewmodel
import androidx.lifecycle.ViewModel
import com.example.ecommerceappfirebase.data.User
import com.example.ecommerceappfirebase.util.Constants.USER_COLLECTION
import com.example.ecommerceappfirebase.util.RegisterFieldsStates
import com.example.ecommerceappfirebase.util.RegisterValidation
import com.example.ecommerceappfirebase.util.Resource
import com.example.ecommerceappfirebase.util.validateEmail
import com.example.ecommerceappfirebase.util.validatePassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@HiltViewModel
class RegisterViewModel @Inject constructor(
        private val firebaseAuth: FirebaseAuth,
        private val db: FirebaseFirestore
): ViewModel(){
    private val _register = MutableStateFlow<Resource<User>>(Resource.Unspecified())
    val register: Flow<Resource<User>> = _register

    private val _validation = Channel<RegisterFieldsStates>()
        val validation = _validation.receiveAsFlow()


    fun createAccountWithEmailAndPassword(user: User, password: String){
        if(checkValidation(user, password)) {
            runBlocking {
                _register.emit(Resource.Loading())
            }
            firebaseAuth.createUserWithEmailAndPassword(user.email, password)
                .addOnSuccessListener {
                    it.user?.let {
                        saveUserInfo(it.uid, user)
//                        _register.value = Resoure.Sucess(it)
                    }
                }.addOnFailureListener {
                    _register.value = Resource.Error(it.message.toString())
                }
        }else{
            val registerFieldsStates = RegisterFieldsStates(
                validateEmail(user.email), validatePassword(password)
            )
            runBlocking {
                _validation.send(registerFieldsStates)
            }
        }
    }

    private fun saveUserInfo(userUid: String, user: User) {
        db.collection(USER_COLLECTION)
            .document(userUid)
            .set(user)
            .addOnSuccessListener {
                _register.value = Resource.Sucess(user)
            }.addOnFailureListener{
                _register.value = Resource.Error(it.message.toString())
            }
    }

    private fun checkValidation(user: User, password: String): Boolean {
        val emailValidation = validateEmail(user.email)
        val passwordValidation = validatePassword(password)
        val shouldRegister =
            emailValidation is RegisterValidation.Success && passwordValidation is RegisterValidation.Success
        return shouldRegister
    }
}


