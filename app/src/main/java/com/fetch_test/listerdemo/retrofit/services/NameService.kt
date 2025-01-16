package com.fetch_test.listerdemo.retrofit.services

import com.fetch_test.listerdemo.retrofit.models.Name
import retrofit2.Call
import retrofit2.http.GET

interface NameService {
    /**
     * Fetch the names from the server.
     */
    @GET("hiring.json")
    fun getNames() : Call<List<Name>>
}