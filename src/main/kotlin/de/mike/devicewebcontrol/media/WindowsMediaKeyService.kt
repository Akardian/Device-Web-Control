package de.mike.devicewebcontrol.media

import commands.MediaKeys
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Component

@Component
class WindowsMediaKeyService {

    fun getName(): String {
        return "MediaController"
    }

    fun volumeUp() {
        MediaKeys.volumeUp()
    }

    fun volumeDown() {
        MediaKeys.volumeDown()
    }

   fun volumeMute() {
       MediaKeys.volumeMute()
   }

    fun songPrevious() {
        MediaKeys.songPrevious()
    }

    fun songNext() {
        MediaKeys.songNext()
    }

    fun songPlayPause() {
        MediaKeys.songPlayPause()
    }

    fun mediaStop() {
        MediaKeys.mediaStop()
    }
}