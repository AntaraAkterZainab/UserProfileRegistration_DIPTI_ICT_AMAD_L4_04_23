package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.repository_DIPTI_ICT_AMAD_L4_04_23

import androidx.lifecycle.LiveData
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.dao_DIPTI_ICT_AMAD_L4_04_23.UserProfileDao_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23

class
UserProfileRepository_DIPTI_ICT_AMAD_L4_04_23(private val userProfileDao: UserProfileDao_DIPTI_ICT_AMAD_L4_04_23) {
    fun getUserProfiles(): LiveData<List<UserProfile_DIPTI_ICT_AMAD_L4_04_23>> {
        return userProfileDao.getAllUserProfiles()
    }

    suspend fun insert(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        userProfileDao.insert(userProfile)
    }

    suspend fun update(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        userProfileDao.update(userProfile)
    }

    suspend fun delete(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        userProfileDao.delete(userProfile)
    }
}