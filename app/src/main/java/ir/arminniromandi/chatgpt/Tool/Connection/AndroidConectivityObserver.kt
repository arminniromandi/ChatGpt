package ir.arminniromandi.composeapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AndroidConectivityObserver(
    private val context : Context
):ConectivityObserver {
    private val conectivityManager = context.getSystemService(ConnectivityManager::class.java)

    override var isConnected: Flow<Boolean>
        get() = callbackFlow {
            val callBack = object : NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    trySend(true)
                }


                override fun onLost(network: Network) {
                    super.onLost(network)
                    trySend(false)
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    trySend(false)
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    val connected = networkCapabilities.hasCapability(
                        NetworkCapabilities.NET_CAPABILITY_VALIDATED
                    )
                    trySend(connected)
                }
            }

            conectivityManager.registerDefaultNetworkCallback(callBack)

            awaitClose {
                conectivityManager.unregisterNetworkCallback(callBack)
            }

        }
        set(value) {}

}