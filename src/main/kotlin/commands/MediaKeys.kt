package commands

import de.mike.devicewebcontrol.logging.LoggingController
import org.springframework.beans.factory.UnsatisfiedDependencyException

//Thanks to https://github.com/nsnave/java-media-keys

public class MediaKeys {
    //loads library from "MediaKeys.dll"
    init {
        println("Load...")
        try {
            System.loadLibrary("MediaKeys")
        }catch (e: UnsatisfiedLinkError){
            LoggingController.logger.warn("Expected $e Exception on Spring Boot build")
        }catch (e: Exception) {
            LoggingController.logger.warn("Unexpected $e Exception on Spring Boot build")
            throw e
        }
    }

    external fun volumeMute()

    external fun volumeDown()

    external fun volumeUp()

    external fun songPrevious()

    external fun songNext()

    external fun songPlayPause()

    external fun mediaStop()
}
