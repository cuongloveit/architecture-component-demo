package com.example.architecturecomponentdemo.api.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by cuong on 7/14/17.
 */
data class SearchResponse(
        @SerializedName("total_count")
        var totalCount: String,
        @SerializedName("incomplete_results")
        var incompleteResults: Boolean,
        @SerializedName("items")
        var repositories : List<Repository>
)