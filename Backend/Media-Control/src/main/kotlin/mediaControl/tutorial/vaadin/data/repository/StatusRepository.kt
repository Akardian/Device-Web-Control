package mediaControl.tutorial.vaadin.data.repository

import mediaControl.tutorial.vaadin.data.entity.Status
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository: JpaRepository<Status, Int> {

}
