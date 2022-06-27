package mediaControl.media

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import mediaControl.media.WindowsMediaKeyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/media"])
class MediaController {
    private val service: WindowsMediaKeyService

    @Autowired
    private constructor(service: WindowsMediaKeyService) {
        this.service = service
    }

    @GetMapping("")
    @Operation(summary = "Contains the class name", description = "Returns the class name")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun getName(): String{
        return service.getName()
    }

    @PostMapping("/volumeUp")
    @Operation(summary = "Sends a volumeUp keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun volumeUp() {
        service.volumeUp()
    }

    @PostMapping("/volumeDown")
    @Operation(summary = "Sends a volumeDown keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun volumeDown() {
        service.volumeDown()
    }

    @PostMapping("/volumeMute")
    @Operation(summary = "Sends a volumeMute keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun volumeMute() {
        service.volumeMute()
    }

    @PostMapping("/songPrevious")
    @Operation(summary = "Sends a songPrevious keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun songPrevious() {
        service.songPrevious()
    }

    @PostMapping("/songNext")
    @Operation(summary = "Sends a songNext keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun songNext() {
        service.songNext()
    }

    @PostMapping("/songPlayPause")
    @Operation(summary = "Sends a songPlayPause keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun songPlayPause() {
        service.songPlayPause()
    }

    @PostMapping("/mediaStop")
    @Operation(summary = "Sends a mediaStop keystroke to server", description = "No body needed")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation")
    ])
    fun mediaStop() {
        service.mediaStop()
    }
}