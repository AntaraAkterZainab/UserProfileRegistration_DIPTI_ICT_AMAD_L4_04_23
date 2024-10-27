package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.viewModel_DIPTI_ICT_AMAD_L4_04_23

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.database_DIPTI_ICT_AMAD_L4_04_23.UserDatabase_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.repository_DIPTI_ICT_AMAD_L4_04_23.UserProfileRepository_DIPTI_ICT_AMAD_L4_04_23
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_23(application: Application) : AndroidViewModel(application) {
    private val repository: UserProfileRepository_DIPTI_ICT_AMAD_L4_04_23

    init {
        val userProfileDao = UserDatabase_DIPTI_ICT_AMAD_L4_04_23.getDatabase(application).userProfileDao()
        repository = UserProfileRepository_DIPTI_ICT_AMAD_L4_04_23(userProfileDao)
    }

    fun getUserProfiles(): LiveData<List<UserProfile_DIPTI_ICT_AMAD_L4_04_23>> {
        return repository.getUserProfiles()
    }

    fun insertUserProfile(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(userProfile)
        }
    }

    fun updateUserProfile(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(userProfile)
        }
    }

    fun deleteUserProfile(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(userProfile)
        }
    }
}