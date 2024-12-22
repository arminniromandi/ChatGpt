package ir.arminniromandi.composeapplication

import kotlinx.coroutines.flow.Flow

interface ConectivityObserver {
    var isConnected : Flow<Boolean>

}