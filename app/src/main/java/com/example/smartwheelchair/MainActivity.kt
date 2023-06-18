package com.example.smartwheelchair

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logout = findViewById<Button>(R.id.logout_btn)
        logout.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Saarthi")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(applicationContext, login::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("No", null)
                .show()

        }

        val mywheel = findViewById<CardView>(R.id.option1)
        mywheel.setOnClickListener {
            val intent1 = Intent(this, MyWheelchair::class.java)
            startActivity(intent1)
        }
    }
}