package com.example.lifecycleexploration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val userList = mutableListOf<User>()
    val itemList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Lifecycle - onCreate")
        generateData()
        populateData()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "on start", Toast.LENGTH_LONG).show()
        Log.i("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }

    fun populateData() {
        for (i in 0..3) {
            val view = createTextView(itemList[i], userList[i])
            list_view.addView(view)
        }
    }

    fun createTextView(item: Item, user: User): TextView {
        val view = TextView(this)

        view.text = "${item.name} - ${item.price}, ${user.name}, ${user.reputation}"
        view.textSize = 24f

        return view
    }

    fun generateData() {
        userList.add(User("Bob", 5))
        userList.add(User("Joe", 4))
        userList.add(User("Susan", 5))
        userList.add(User("Mary", 3))

        itemList.add(Item(1.00f, "truck", "toy"))
        itemList.add(Item(1.25f, "dress", "clothing"))
        itemList.add(Item(500.00f, "bike", "sports"))
        itemList.add(Item(1000.00f, "laptop", "electronics"))
    }

}