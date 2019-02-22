package com.example.mi_post.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 2/22/19.
 */
class NetworkConnectivity @Inject constructor(private val context: Context) {

    fun isConnected(): Boolean {

        val connectivity = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        if (connectivity != null){
           val  info= connectivity.allNetworkInfo

            if(info !=null){
                for (i in info.indices){
                    if (info[i].state == NetworkInfo.State.CONNECTED) return true
                }
            }
        }

        return false
    }

}