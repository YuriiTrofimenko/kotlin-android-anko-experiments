package org.tyaa.kotlin.ankoexperiments.data

import org.tyaa.kotlin.ankoexperiments.data.post.FakePostDao

// Private primary constructor inaccessible from other classes
class FakeDatabase private constructor() {

    // All the DAOs go here
    var postDao = FakePostDao()
        private set
    var userDao = FakeUserDao()
        private set

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        // The only way to get hold of the FakeDatabase object
        fun getInstance() =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}