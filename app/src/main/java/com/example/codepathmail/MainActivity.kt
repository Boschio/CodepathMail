package com.example.codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var emails: List<Email>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)

        // Fetch emails
        emails = EmailFetcher.getEmails()

        // create instance of Email adapter and give it list of emails
        val emailAdapter = EmailAdapter(emails)

        // Attach the adapter to RV by setting its' "adapter" field
        emailsRv.adapter = emailAdapter

        // Set layout manager for RV to tell it how to position items
        emailsRv.layoutManager = LinearLayoutManager(this)

    }
}

