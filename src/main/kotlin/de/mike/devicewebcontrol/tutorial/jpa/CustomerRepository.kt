package de.mike.devicewebcontrol.tutorial.jpa

import de.mike.devicewebcontrol.tutorial.jpa.Customer
import org.springframework.data.repository.CrudRepository

interface  CustomerRepository : CrudRepository<Customer, Long>{

    fun findByLastName(lastname: String): List<Customer>
}