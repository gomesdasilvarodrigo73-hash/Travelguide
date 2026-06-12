package com.example.travelguide

import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chatInput: EditText
    private lateinit var btnSend: FloatingActionButton
    private lateinit var chatScrollView: NestedScrollView
    private lateinit var suggestionsScrollView: HorizontalScrollView
    private lateinit var suggestionsContainer: LinearLayout

    private val messages = mutableListOf<ChatMessage>()
    private var messageIdCounter = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        setupToolbar()
        setupChatRecyclerView()
        setupInput()
        setupSuggestions()

        // Send welcome message
        val welcomeMessage = ChatMessage(
            id = ++messageIdCounter,
            text = ChatBot.getWelcomeMessage(),
            isFromUser = false,
            timestamp = System.currentTimeMillis()
        )
        messages.add(welcomeMessage)
        chatAdapter.notifyDataSetChanged()
        scrollToBottom()
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbarChat)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupChatRecyclerView() {
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.setHasFixedSize(true)
        chatAdapter = ChatAdapter(messages)
        chatRecyclerView.adapter = chatAdapter
    }

    private fun setupInput() {
        chatInput = findViewById(R.id.chatInput)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener {
            sendMessage()
        }

        chatInput.setOnEditorActionListener { _, _, event ->
            if (event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                sendMessage()
                true
            } else {
                false
            }
        }
    }

    private fun setupSuggestions() {
        suggestionsContainer = findViewById(R.id.suggestionsContainer)
        suggestionsScrollView = findViewById(R.id.suggestionsScrollView)

        val suggestions = ChatBot.getQuickSuggestions()
        for (suggestion in suggestions) {
            val chip = TextView(this).apply {
                text = suggestion
                setTextColor(getColor(R.color.primary_dark))
                background = getDrawable(R.drawable.bg_chip)
                setPadding(16, 8, 16, 8)
                textSize = 12f
                setOnClickListener {
                    chatInput.setText(suggestion)
                    sendMessage()
                }
            }
            suggestionsContainer.addView(chip)
        }
    }

    private fun sendMessage() {
        val message = chatInput.text.toString().trim()
        if (message.isEmpty()) return

        // Hide suggestions after first message
        suggestionsScrollView.visibility = android.view.View.GONE

        // Add user message
        messages.add(
            ChatMessage(
                id = ++messageIdCounter,
                text = message,
                isFromUser = true,
                timestamp = System.currentTimeMillis()
            )
        )
        chatAdapter.notifyDataSetChanged()
        chatInput.text.clear()
        scrollToBottom()

        // Bot responds
        chatRecyclerView.postDelayed({
            val response = ChatBot.getResponse(message)
            messages.add(
                ChatMessage(
                    id = ++messageIdCounter,
                    text = response,
                    isFromUser = false,
                    timestamp = System.currentTimeMillis()
                )
            )
            chatAdapter.notifyDataSetChanged()
            scrollToBottom()
        }, 500)
    }

    private fun scrollToBottom() {
        chatRecyclerView.post {
            chatRecyclerView.smoothScrollToPosition(messages.size - 1)
            chatScrollView.fullScroll(NestedScrollView.FOCUS_DOWN)
        }
    }
}
