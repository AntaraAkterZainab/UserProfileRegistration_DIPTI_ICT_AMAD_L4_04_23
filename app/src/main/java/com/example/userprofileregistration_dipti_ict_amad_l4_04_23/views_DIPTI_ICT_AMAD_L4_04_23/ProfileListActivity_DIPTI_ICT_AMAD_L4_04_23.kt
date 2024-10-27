package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.views_DIPTI_ICT_AMAD_L4_04_23

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.R
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.adapter_DIPTI_ICT_AMAD_L4_04_23.ProfileAdapter_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.viewModel_DIPTI_ICT_AMAD_L4_04_23.UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_23
import com.google.android.material.floatingactionbutton.FloatingActionButton

class   ProfileListActivity_DIPTI_ICT_AMAD_L4_04_23 : AppCompatActivity() {

    private lateinit var profileViewModel: UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_23
    private lateinit var profileAdapter: ProfileAdapter_DIPTI_ICT_AMAD_L4_04_23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list_dipti_ict_amad_l40423)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_23::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)
        profileAdapter = ProfileAdapter_DIPTI_ICT_AMAD_L4_04_23()

        recyclerView.adapter = profileAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe profiles from ViewModel
        profileViewModel.getUserProfiles().observe(this, Observer { profiles ->
            if (profiles.isEmpty()) {
                // Show a Toast message if there are no profiles
                Toast.makeText(this, "No profiles available", Toast.LENGTH_SHORT).show()
            } else {
                profileAdapter.submitList(profiles)
            }
        })

        // Set item click listener for details
        profileAdapter.setOnItemClickListener { userProfile ->
            val intent = Intent(this@ProfileListActivity_DIPTI_ICT_AMAD_L4_04_23, SingleProfileActivity_DIPTI_ICT_AMAD_L4_04_23::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }

        // Set delete click listener
        profileAdapter.setOnDeleteClickListener { userProfile ->
            showDeleteConfirmationDialog(userProfile)
        }

        // Set update click listener
        profileAdapter.setOnUpdateClickListener { userProfile ->
            val intent = Intent(this@ProfileListActivity_DIPTI_ICT_AMAD_L4_04_23, UpdateProfileActivity_DIPTI_ICT_AMAD_L4_04_23::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }

        // Add profile button click listener
        findViewById<FloatingActionButton>(R.id.addProfileBtn).setOnClickListener {
            val intent = Intent(this@ProfileListActivity_DIPTI_ICT_AMAD_L4_04_23, AddProfileActivity_DIPTI_ICT_AMAD_L4_04_23::class.java)
            startActivity(intent)
        }
    }

    // Show delete confirmation dialog
    private fun showDeleteConfirmationDialog(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Profile")
        builder.setMessage("Are you sure you want to delete this profile?")

        builder.setPositiveButton("Yes") { dialog, which ->
            profileViewModel.deleteUserProfile(userProfile)  // Delete the profile
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()  // Cancel delete operation
        }

        val dialog = builder.create()
        dialog.show()
    }
}