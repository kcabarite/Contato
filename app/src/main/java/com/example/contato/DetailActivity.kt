package com.example.contato

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.contact_item.view.*


class DetailActivity: AppCompatActivity() {
    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.contact_detail)

        getExtras()
        bindViews()
        initToolbar()

    }

    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.tv_name).text = contact?.nome
        findViewById<TextView>(R.id.tv_phone).text = contact?.phone
    }

    companion object {
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}