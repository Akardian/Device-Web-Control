package de.mike.devicewebcontrol

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Device Web Control API", version = "1.0", description = ""))
class DeviceWebControlApplication

fun main(args: Array<String>) {
	runApplication<DeviceWebControlApplication>(*args){
	}
}

