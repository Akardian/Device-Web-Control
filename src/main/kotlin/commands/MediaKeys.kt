package commands
//Thanks to https://github.com/nsnave/java-media-keys


public class MediaKeys {
        //loads library from "MediaKeys.dll"
        init {
                println("Load...")
                System.loadLibrary("MediaKeys")
        }

        external fun volumeMute()

        external fun volumeDown()

        external fun volumeUp()

        external fun songPrevious()

        external fun songNext()

        external fun songPlayPause()

        external fun mediaStop()
}
