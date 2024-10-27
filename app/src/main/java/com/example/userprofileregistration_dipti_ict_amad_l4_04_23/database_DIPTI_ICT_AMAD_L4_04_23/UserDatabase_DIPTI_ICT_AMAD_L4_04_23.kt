package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.database_DIPTI_ICT_AMAD_L4_04_23

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.dao_DIPTI_ICT_AMAD_L4_04_23.UserProfileDao_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23

@Database(entities = [UserProfile_DIPTI_ICT_AMAD_L4_04_23::class], version = 1)
abstract class UserDatabase_DIPTI_ICT_AMAD_L4_04_23 : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao_DIPTI_ICT_AMAD_L4_04_23

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase_DIPTI_ICT_AMAD_L4_04_23? = null

        fun getDatabase(context: Context): UserDatabase_DIPTI_ICT_AMAD_L4_04_23 {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase_DIPTI_ICT_AMAD_L4_04_23::class.java,
                    "user_profile_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}