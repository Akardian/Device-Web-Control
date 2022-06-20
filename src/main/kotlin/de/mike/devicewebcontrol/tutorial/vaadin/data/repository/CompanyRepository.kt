package de.mike.devicewebcontrol.tutorial.vaadin.data.repository

import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Int> {

}
