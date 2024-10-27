package com.example.userprofileregistration_dipti_ict_amad_l4_04_23.adapter_DIPTI_ICT_AMAD_L4_04_23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.model_DIPTI_ICT_AMAD_L4_04_23.UserProfile_DIPTI_ICT_AMAD_L4_04_23
import com.example.userprofileregistration_dipti_ict_amad_l4_04_23.R


class ProfileAdapter_DIPTI_ICT_AMAD_L4_04_23 : ListAdapter<UserProfile_DIPTI_ICT_AMAD_L4_04_23, ProfileAdapter_DIPTI_ICT_AMAD_L4_04_23.ProfileViewHolder>(
    DiffCallback()
) {

    private var onItemClickListener: ((UserProfile_DIPTI_ICT_AMAD_L4_04_23) -> Unit)? = null
    private var onDeleteClickListener: ((UserProfile_DIPTI_ICT_AMAD_L4_04_23) -> Unit)? = null
    private var onUpdateClickListener: ((UserProfile_DIPTI_ICT_AMAD_L4_04_23) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_item_layout_dipti_ict_amad_l40423, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    fun setOnItemClickListener(listener: (UserProfile_DIPTI_ICT_AMAD_L4_04_23) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener: (UserProfile_DIPTI_ICT_AMAD_L4_04_23) -> Unit) {
        onDeleteClickListener = listener
    }

    fun setOnUpdateClickListener(listener: (UserProfile_DIPTI_ICT_AMAD_L4_04_23) -> Unit) {
        onUpdateClickListener = listener
    }

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileName: TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDOB: TextView = itemView.findViewById(R.id.userDOBTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.userDistritTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.userMobileTxt)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteBtn)
        private val updateButton: ImageButton = itemView.findViewById(R.id.editBtn)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)
                }
            }

            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }
            }

            updateButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onUpdateClickListener?.invoke(profile)
                }
            }
        }

        fun bind(userProfile: UserProfile_DIPTI_ICT_AMAD_L4_04_23) {
            profileName.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDOB.text = userProfile.dob
            profileDistrict.text = userProfile.district
            profileMobile.text = userProfile.mobile
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<UserProfile_DIPTI_ICT_AMAD_L4_04_23>() {
        override fun areItemsTheSame(oldItem: UserProfile_DIPTI_ICT_AMAD_L4_04_23, newItem: UserProfile_DIPTI_ICT_AMAD_L4_04_23): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserProfile_DIPTI_ICT_AMAD_L4_04_23, newItem: UserProfile_DIPTI_ICT_AMAD_L4_04_23): Boolean {
            return oldItem == newItem
        }
    }
}