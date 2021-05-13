package com.bignerdranch.android.flickrgallery

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.edit

private const val PREF_SEARCH_QUERY = "searchQuery"
private const val PREF_LAST_RESULT_ID = "lastResultId"
private const val FILE_SEARCH_QUERY = "query_word"

object QueryPreferences {
    fun getStoredQuery(context: Context): String {
        return context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .getString(PREF_SEARCH_QUERY, "planets")!!
    }

    fun setStoredQuery(context: Context, query: String) {
        context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .edit()
            .putString(PREF_SEARCH_QUERY, query)
            .apply()
    }

    fun getLastResultId(context: Context): String {
        return context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .getString(PREF_LAST_RESULT_ID, "")!!
    }

    fun setLastResultId(context: Context, lastResultId: String) {
        context.getSharedPreferences(FILE_SEARCH_QUERY, Context.MODE_PRIVATE)
            .edit()
            .putString(PREF_LAST_RESULT_ID, lastResultId)
            .apply()
    }
}