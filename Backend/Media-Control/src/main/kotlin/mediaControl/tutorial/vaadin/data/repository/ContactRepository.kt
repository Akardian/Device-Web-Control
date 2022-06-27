package mediaControl.tutorial.vaadin.data.repository

import mediaControl.tutorial.vaadin.data.entity.Contact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ContactRepository: JpaRepository<Contact, Int> {

    @Query("select c from Contact c " +
            "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    fun search(@Param("searchTerm") searchTerm: String): List<Contact>
}
