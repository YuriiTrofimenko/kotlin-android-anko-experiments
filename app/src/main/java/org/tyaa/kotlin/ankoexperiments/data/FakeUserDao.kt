package org.tyaa.kotlin.ankoexperiments.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeUserDao {
    // A fake database table
    private val userList = mutableListOf<User>()
    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val users = MutableLiveData<List<User>>()

    init {
        // Immediately connect the now empty userList
        // to the MutableLiveData which can be observed
        users.value = userList
    }

    fun addUser(user: User) {
        userList.add(user)
        // After adding a user to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        users.value = userList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getUsers() = users as LiveData<List<User>>
}