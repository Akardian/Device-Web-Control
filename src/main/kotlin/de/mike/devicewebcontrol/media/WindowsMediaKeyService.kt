package de.mike.devicewebcontrol.media

import commands.MediaKeys
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Component

@Component
class WindowsMediaKeyService {
    val mediaKeys: MediaKeys = MediaKeys()

    fun getName(): String {
        return "MediaController"
    }

    fun volumeUp() {
        mediaKeys.volumeUp()
    }

    fun volumeDown() {
        mediaKeys.volumeDown()
    }

   fun volumeMute() {
       mediaKeys.volumeMute()
   }

    fun songPrevious() {
        mediaKeys.songPrevious()
    }

    fun songNext() {
        mediaKeys.songNext()
    }

    fun songPlayPause() {
        mediaKeys.songPlayPause()
    }

    fun mediaStop() {
        mediaKeys.mediaStop()
    }
}