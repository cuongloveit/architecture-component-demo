package com.example.architecturecomponentdemo.api.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by cuong on 7/14/17.
 */
@Entity
data class Repository(
        @PrimaryKey
        var id: Long,
        var name: String,
        var description: String)