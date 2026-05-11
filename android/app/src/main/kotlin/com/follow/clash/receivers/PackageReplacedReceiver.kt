package com.follow.clash.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.follow.clash.GlobalState
import com.follow.clash.RunState

class PackageReplacedReceiver : BroadcastReceiver() {
    companion object {
        private const val TAG = "PackageReplacedReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_MY_PACKAGE_REPLACED) return
        val pending = goAsync()
        if (Build.VERSION.SDK_INT >= 36) {
            GlobalState.handleStart(skipDebounce = true)
        } else {
            runCatching {
                android.net.VpnService.prepare(context)
            }.onFailure { Log.e(TAG, "Prepare failed", it) }
        }
        
        pending.finish()
    }
}
