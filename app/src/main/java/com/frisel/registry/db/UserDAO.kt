package com.frisel.registry.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Query("SELECT * FROM users")
    fun getAllUser(): Flow<List<User>>

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun updateIdUser(user: User)
}