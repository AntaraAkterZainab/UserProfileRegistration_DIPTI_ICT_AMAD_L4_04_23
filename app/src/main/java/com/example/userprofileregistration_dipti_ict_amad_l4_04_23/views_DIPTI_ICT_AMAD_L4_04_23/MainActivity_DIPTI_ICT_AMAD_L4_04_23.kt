package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.views_DIPTI_ICT_AMAD_L4_04_23

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.R

class MainActivity_DIPTI_ICT_AMAD_L4_04_23 : AppCompatActivity() {
    private lateinit var listButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dipti_ict_amad_l4_04_23)

        listButton = findViewById(R.id.profileListBtn)

        listButton.setOnClickListener {
            // Start LoadingActivity instead of ProfileListActivity
            val intent = Intent(this, LodingActivity_DIPTI_ICT_AMAD_L4_04_23::class.java)
            intent.putExtra("TARGET_ACTIVITY", "com.example.userprofileregistration_dipti_ict_amad_l4_04_23.views_DIPTI_ICT_AMAD_L4_04_23.ProfileListActivity_DIPTI_ICT_AMAD_L4_04_23")
            startActivity(intent)
            finish() // Finish MainActivity so the user can't return to it
        }
    }
}