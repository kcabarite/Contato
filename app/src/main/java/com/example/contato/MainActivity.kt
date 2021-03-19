package com.example.contato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateList()
        bindView()
    }


    private fun bindView() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Kleber",
                    "(00)1209-0000",
                    "img.pnj"
                ),

                Contact(
                    "Leticia",
                    "(00)1309-0000",
                    "img.pnj"
                )
            )
        )
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val Inflater: MenuInflater = menuInflater
        Inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.Item_menu_1 ->{
                showToast("Item menu 1")
                return true
            }

            R.id.Item_menu_2 ->{
                showToast("Item menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}