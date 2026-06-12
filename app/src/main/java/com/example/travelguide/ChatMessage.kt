package com.example.travelguide

import java.io.Serializable

data class ChatMessage(
    val id: Long,
    val text: String,
    val isFromUser: Boolean,
    val timestamp: Long
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
