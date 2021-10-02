package com.scorpio.a_eye.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.scorpio.a_eye.model.Guide
import java.util.*

class AppViewModel : ViewModel() {

    val currentScanningType: MutableLiveData<Int> = MutableLiveData(3)

    private val auth = Firebase.auth
    private val database = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()

    val currentUser: MutableLiveData<Guide> = MutableLiveData(null)

    /**
     * 0 -> Login Success
     * 1 -> Login Failure
     *
     * 2 -> Register Success
     * 3 -> Register Failure
     *
     * 5 -> Editing Success
     * 6 -> Editing Failure
     */
    val showAuthenticationStatus: MutableLiveData<Int> = MutableLiveData(null)
    fun signInUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    getUserData(email)
                    showAuthenticationStatus.postValue(0)
                    Log.i("ViewModelTag", "signInUser: Login successful")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.i("ViewModelTag", "signInUser: Login error")
                    showAuthenticationStatus.postValue(1)
                }
            }
    }

    fun registerUser(
        personName: String, personAge: String, gender: String, guideName: String,
        guidePhone: String, guideEmail: String, guidePassword: String
    ) {
        Log.i("ViewModelTag", "registerUser: ")
        auth.createUserWithEmailAndPassword(guideEmail, guidePassword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("ViewModelTag", "signInUser: signup successful")
                val guideHash: HashMap<String, Any> = hashMapOf(
                    "userId" to "${auth.currentUser?.uid}",
                    "guidePhoto" to "",
                    "guideName" to guideName,
                    "guidePhone" to guidePhone,
                    "userName" to personName,
                    "userAge" to personAge,
                    "userGender" to gender,
                    "faces" to mutableListOf<String>(),
                    "currencies" to mutableListOf<String>()
                )
                database.collection("users").document(guideEmail).set(guideHash).addOnCompleteListener {
                    val guideModel = Guide(auth.currentUser?.uid, "", guideName, guidePhone, guideEmail, personName, personAge.toInt(), gender, mutableListOf(), mutableListOf())
                    currentUser.postValue(guideModel)
                    showAuthenticationStatus.postValue(2)
                }.addOnFailureListener {
                    Log.i("ViewModelTag", "add data error->", it)
                }
            } else {
                Log.i("ViewModelTag", "signInUser: signup error")
                showAuthenticationStatus.postValue(3)
                auth.currentUser?.delete()
                database.collection("users").document(guideEmail).delete()
            }
        }.addOnFailureListener {
            Log.i("ViewModelTag", "signInUser: signup error", it)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun getUserData(email: String) {
        database.collection("users").document(email).get().addOnCompleteListener {
            it.result?.let { snapshot ->
                snapshot.data?.let { data ->
                    val guideModel = Guide(
                        auth.currentUser?.uid,
                        data["guidePhoto"].toString().trim(),
                        data["guideName"].toString().trim(),
                        data["guidePhone"].toString().trim(),
                        email,
                        data["userName"].toString().trim(),
                        if (data["userAge"] != null) data["userAge"].toString().trim().toInt() else null,
                        data["userGender"].toString().trim(),
                        data["faces"] as List<String>,
                        data["currencies"] as List<String>
                    )
                    currentUser.postValue(guideModel)
                    Log.i("ViewModelTag", "data fetched ->${currentUser.value}")
                }
            }

        }.addOnFailureListener {
            Log.i("ViewModelTag", "add data error->", it)
        }
    }

    fun updateData(value: HashMap<String, Any>) {
        database.collection("users").document(auth.currentUser?.email ?: "").set(value)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    getUserData(auth.currentUser?.email ?: "")
                    showAuthenticationStatus.postValue(5)
                } else {
                    showAuthenticationStatus.postValue(6)
                }
            }.addOnFailureListener {
                showAuthenticationStatus.postValue(6)
            }
    }

    fun uploadImageToDatabase(value: HashMap<String, Any>, uri: Uri) {
        val storageReference = storage.reference.child("profile_images/${auth.currentUser?.email}")
        storageReference.putFile(uri).addOnSuccessListener {
            storageReference.downloadUrl.addOnSuccessListener {
                value["guidePhoto"] = it.toString()
                updateData(value)
                Log.i("ViewModelTag", "uploadImageToDatabase: image upload success.")
            }
        }.addOnFailureListener {
            Log.i("ViewModelTag", "uploadImageToDatabase: image upload failed.", it)
        }
    }
}