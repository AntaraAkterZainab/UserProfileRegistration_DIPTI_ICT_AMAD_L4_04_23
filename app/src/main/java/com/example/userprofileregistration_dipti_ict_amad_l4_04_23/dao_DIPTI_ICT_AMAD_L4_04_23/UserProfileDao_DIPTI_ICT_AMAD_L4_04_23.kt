package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.dao_DIPTI_ICT_AMAD_L4_04_23

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23

@Dao
interface UserProfileDao_DIPTI_ICT_AMAD_L4_04_23 {
    @Insert
    suspend fun insert(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23)

    @Update
    suspend fun update(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23)

    @Delete
    suspend fun delete(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23)

    @Query("SELECT * FROM user_profile")
    fun getAllUserProfiles(): LiveData<List<UserProfile_DIPTI_ICT_AMAD_L4_04_23>>
}