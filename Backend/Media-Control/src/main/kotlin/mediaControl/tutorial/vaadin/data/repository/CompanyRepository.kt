package mediaControl.tutorial.vaadin.data.repository

import mediaControl.tutorial.vaadin.data.entity.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Int> {

}
