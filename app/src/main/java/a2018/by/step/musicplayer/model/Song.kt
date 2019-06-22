package a2018.by.step.musicplayer.model

import android.net.Uri

data class Song(
    val title: String,
    val artist: String,
    val duration: Int,
    val uri: Uri
    )