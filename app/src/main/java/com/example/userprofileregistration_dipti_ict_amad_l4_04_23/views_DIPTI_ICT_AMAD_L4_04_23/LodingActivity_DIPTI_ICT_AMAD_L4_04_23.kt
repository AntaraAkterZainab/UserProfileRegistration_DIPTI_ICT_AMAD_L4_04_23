package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.views_DIPTI_ICT_AMAD_L4_04_23

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.R
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23

class LodingActivity_DIPTI_ICT_AMAD_L4_04_23 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loding_dipti_ict_amad_l40423)

        // Simulate loading or some processing time
        Handler(Looper.getMainLooper()).postDelayed({
            // Retrieve the target activity and user profile
            val targetActivityName = intent.getStringExtra("TARGET_ACTIVITY")
            val userProfile = intent.getSerializableExtra("USER_PROFILE") as UserProfile_DIPTI_ICT_AMAD_L4_04_23 ?

            // Navigate to the target activity
            val targetIntent = Intent()
            targetIntent.setClassName(this, targetActivityName ?: return@postDelayed)
            userProfile?.let {
                targetIntent.putExtra("USER_PROFILE", it)
            }
            startActivity(targetIntent)
            finish() // Finish this activity so the user can't return to it
        }, 1000) // 3000 milliseconds = 3 seconds
    }
}