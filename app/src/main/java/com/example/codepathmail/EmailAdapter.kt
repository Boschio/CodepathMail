package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTv: TextView
        val titleTv: TextView
        val summaryTv: TextView



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            senderTv = itemView.findViewById(R.id.senderTv)
            titleTv = itemView.findViewById(R.id.titleTv)
            summaryTv = itemView.findViewById(R.id.summaryTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)

        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)

        // Set item views based on views and data model
        holder.senderTv.text = email.sender
        holder.titleTv.text = email.title
        holder.summaryTv.text = email.summary

        // check if read or not
        val isEmailRead = email.isRead

        //
        if (!isEmailRead) {
            holder.senderTv.setTypeface(holder.senderTv.getTypeface(), Typeface.BOLD)
        }
        if (!isEmailRead) {
            holder.titleTv.setTypeface(holder.titleTv.getTypeface(), Typeface.BOLD)
        }
        if (!isEmailRead) {
            holder.summaryTv.setTypeface(holder.summaryTv.getTypeface(), Typeface.BOLD)
        }

    }

    override fun getItemCount(): Int {
        return emails.size
    }
}