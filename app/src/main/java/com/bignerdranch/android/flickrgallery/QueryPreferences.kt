package com.bignerdranch.android.flickrgallery

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.edit

private const val PREF_SEARCH_QUERY = "searchQuery"
private const val PREF_LAST_RESULT_ID = "lastResultId"
private const val PREF_IS_POLLING = "isPolling"

private const val FILE_SEARCH_QUERY = "query_word"

object QueryPreferences {
    fun getStoredQuery(context: Context): String {
        return getPreferenceFileValue(context, PREF_SEARCH_QUERY, "planets")
    }


    fun setStoredQuery(context: Context, query: String) {
        setPreferenceFileValue(context, query)
    }

    fun getLastResultId(context: Context): String {
        return getPreferenceFileValue(context, PREF_LAST_RESULT_ID, "planets")
    }

    fun setLastResultId(context: Context, lastResultId: String) {
        setPreferenceFileValue(context, lastResultId)
    }

    fun isPolling(context: Context): Boolean {
        return context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE).getBoolean(
            PREF_IS_POLLING, false
        )
    }

    fun setPolling(context: Context, isOn: Boolean) {
        context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_IS_POLLING, isOn)
            .apply()
    }

    private fun setPreferenceFileValue(context: Context, lastResultId: String) {
        context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .edit()
            .putString(PREF_LAST_RESULT_ID, lastResultId)
            .apply()
    }

    private fun getPreferenceFileValue(context: Context, name: String, value: String = ""): String {
        return context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .getString(name, value)!!
    }
}