package de.mike.devicewebcontrol.tutorial.vaadin.data.repository

import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Status
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository: JpaRepository<Status, Int> {

}
