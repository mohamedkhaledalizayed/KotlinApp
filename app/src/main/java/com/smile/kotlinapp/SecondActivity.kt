package com.smile.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var name = intent.getStringExtra("name")
        Toast.makeText(this,name,Toast.LENGTH_LONG).show()

//        var title = intent.getSerializableExtra("movie")


    }
}
