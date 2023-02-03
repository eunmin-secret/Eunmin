package dev.project.eunmin.model

import android.net.Uri

data class Profile(
    val email: String,
    val profileUri: Uri?,
    val nickname: String?
)
