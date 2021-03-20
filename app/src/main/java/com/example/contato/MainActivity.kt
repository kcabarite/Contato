package com.example.contato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contato.DetailActivity.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickItemContactListener{
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        updateList()
        bindView()
        initDrawer()
    }

    private fun initDrawer(){
     val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
     val toolbar = findViewById<Toolbar>(R.id.toolbar)
     setSupportActionBar(toolbar)

    val toogle = ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.open_drawer,R.string.close_drawer)
     drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
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

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT,contact)
        startActivity(intent)
    }
}