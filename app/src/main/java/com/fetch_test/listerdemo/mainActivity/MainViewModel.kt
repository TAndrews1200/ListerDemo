package com.fetch_test.listerdemo.mainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fetch_test.listerdemo.retrofit.NameClient
import com.fetch_test.listerdemo.retrofit.models.Name
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainViewModel : ViewModel() {
    val nameList: MutableLiveData<List<Name>> by lazy {
        MutableLiveData<List<Name>>()
    }
    val fetching: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun fetchNames() {
        fetching.value = true
        val call = NameClient.nameService.getNames()

        call.enqueue(object : Callback<List<Name>> {
            override fun onResponse(call: Call<List<Name>>, response: Response<List<Name>>) {
                if (response.isSuccessful) {
                    val filteredList = response.body()?.filter { potentialName ->
                        !potentialName.name.isNullOrBlank()
                    } ?: listOf()

                    nameList.value = filteredList.sortedWith(compareBy({it.listId}, {it.name}))
                } else {
                    Timber.d("Response unsuccessful ${response.message()}")
                }
                fetching.value = false
            }

            override fun onFailure(call: Call<List<Name>>, t: Throwable) {
                Timber.d("Name call failed: ${t.message}")
                fetching.value = false
            }
        })
    }
}