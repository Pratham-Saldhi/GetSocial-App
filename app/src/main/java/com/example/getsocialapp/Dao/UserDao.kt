package com.example.getsocialapp.Dao

import com.example.getsocialapp.Models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {

    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")

    fun addUser(user: User?){
        // Checks for the nullability
        // if null, doesn't go into the block
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user.uid).set(it)
            }

        }
    }
    fun getUserById(uId:String):Task<DocumentSnapshot>{
        return userCollection.document(uId).get()
    }
}