package com.example.magica_colombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class DepaAmazonas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depa_amazonas)
        val amazonas1Card: CardView = findViewById(R.id.Amazonas1card)
        val amazonas2Card: CardView = findViewById(R.id.Amazonas2card)
        val amazonas3Card: CardView = findViewById(R.id.Amazonas3card)
        val amazonas4Card: CardView = findViewById(R.id.Amazonas4card)

        amazonas1Card.setOnClickListener {
            val intent = Intent(this, Historia1Ama::class.java)
            startActivity(intent)
        }

        amazonas2Card.setOnClickListener {
            val intent = Intent(this, Historia2Ama::class.java)
            startActivity(intent)
        }
        amazonas3Card.setOnClickListener {
            val intent = Intent(this, Historia3Ama::class.java)
            startActivity(intent)
        }
        amazonas4Card.setOnClickListener {
            val intent = Intent(this, Historia4Ama::class.java)
            startActivity(intent)
        }


    }
}