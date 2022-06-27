package commands

import mediaControl.logging.LoggingController


//Thanks to https://github.com/nsnave/java-media-keys

object MediaKeys {
    //loads library from "MediaKeys.dll"
    init {
        try {
            LoggingController.logger.info("Working Directory = " + System.getProperty("user.dir"))

            System.loadLibrary("MediaKeys")
            LoggingController.logger.info("Library MediaKeys loaded")
        }catch (e: UnsatisfiedLinkError){
            throw UnsatisfiedLinkError("Could not load Library")
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
