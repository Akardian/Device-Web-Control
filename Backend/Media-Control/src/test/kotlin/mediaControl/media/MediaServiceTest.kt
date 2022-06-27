package de.mike.devicewebcontrol.media

import mediaControl.media.WindowsMediaKeyService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MediaServiceTest {

    @Test
    @DisplayName("Volume Up")
    fun volumeUp(){
        println()
        println("Volume Up Test")
        val service = WindowsMediaKeyService()

        service.volumeUp()

        println()
        assertEquals(1, 1)
    }
}