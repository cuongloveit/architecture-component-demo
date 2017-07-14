package com.example.architecturecomponentdemo.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.architecturecomponentdemo.api.entity.Repository

/**
 * Created by cuong on 7/15/17.
 */
@Dao
interface RepositoryDao {
    @Query("SELECT * FROM repository")
    fun getAll(): List<Repository>

    @Insert
    fun insert(vararg repository: Repository)

    @Delete
    fun delete(repository: Repository)
}