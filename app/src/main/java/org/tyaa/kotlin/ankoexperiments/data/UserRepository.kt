package org.tyaa.kotlin.ankoexperiments.data

// FakeUserDao must be passed in - it is a dependency
// You could also instantiate the DAO right inside the class without all the fuss, right?
// No. This would break testability - you need to be able to pass a mock version of a DAO
// to the repository (e.g. one that upon calling getUsers() returns a dummy list of quotes for testing)
// This is the core idea behind DEPENDENCY INJECTION - making things completely modular and independent.
class UserRepository private constructor(private val quoteDao: FakeUserDao) {

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun addUser(quote: User) {
        quoteDao.addUser(quote)
    }

    fun getUsers() = quoteDao.getUsers()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: UserRepository? = null

        fun getInstance(quoteDao: FakeUserDao) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(quoteDao).also { instance = it }
            }
    }
}