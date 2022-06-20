package de.mike.devicewebcontrol.logging

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class LoggingController {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(LoggingController::class.java)
    }

    @RequestMapping("/log")
    fun index(): String? {
        logger.trace("A TRACE Message")
        logger.debug("A DEBUG Message")
        logger.info("An INFO Message")
        logger.warn("A WARN Message")
        logger.error("An ERROR Message")
        return "Howdy! Check out the Logs to see the output..."
    }
}