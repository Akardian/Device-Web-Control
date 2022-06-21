package commands

import de.mike.devicewebcontrol.logging.LoggingController

//Thanks to https://github.com/nsnave/java-media-keys

object MediaKeys {
    //loads library from "MediaKeys.dll"
    init {
        try {
            System.loadLibrary("MediaKeys")
            LoggingController.logger.info("Library MediaKeys.dll loaded")
        }catch (e: UnsatisfiedLinkError){
            LoggingController.logger.warn("Expected $e Exception on Spring Boot build")
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
