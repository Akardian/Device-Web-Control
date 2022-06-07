package de.mike.devicewebcontrol.html

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime

@Controller
class HtmlController() {

    @GetMapping("/")
    fun index(model: Model): String {
        model["title"] = "Device Control"

        return "index"
    }
}