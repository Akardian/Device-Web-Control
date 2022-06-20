package de.mike.devicewebcontrol.tutorial.vaadin.data.entity

import de.mike.devicewebcontrol.tutorial.vaadin.data.AbstractEntity
import org.hibernate.annotations.Formula
import java.util.*

import javax.persistence.Entity
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank

@Entity
class Company(
    @NotBlank
    var name: String,

    @OneToMany(targetEntity = Contact::class, mappedBy = "company")
    var employees: List<Contact> = LinkedList<Contact>(),

    @Formula("(select count(c.id) from Contact c where c.company_id = id)")
    var employeeCount: Int
    ): AbstractEntity() {

    }
