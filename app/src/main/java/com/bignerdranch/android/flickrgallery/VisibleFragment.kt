package com.bigne

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast
import com.bignerdranch.android.flickrgallery.PollWorker
import android.content.BroadcastReceiver
import android.util.Log
import androidx.fragment.app.Fragment

private const val TAG = "VisibleFragment "

abstract class VisibleFragment : Fragment() {
    private val onShowNotification = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // 显示Fragment就取消通知
            Log.i(TAG,"取消通知")
            resultCode = Activity.RESULT_CANCELED
        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(PollWorker.ACTION_SHOW_NOTIFICATION)
        requireActivity().registerReceiver(
            onShowNotification,
            filter,
            PollWorker.PERM_PRIVATE,
            null
        )
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unregisterReceiver(onShowNotification)
    }
}