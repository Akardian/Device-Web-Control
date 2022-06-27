package de.mike.devicewebcontrol.tutorial.jpa

import mediaControl.tutorial.jpa.Customer
import mediaControl.tutorial.jpa.CustomerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: CustomerRepository
){

    @Test
    @DisplayName("Create user and find by ID")
    fun findUserByID(){
        val juergen = Customer(firstName = "Juergen", lastName = "Hoeller")

        entityManager.persist(juergen)
        entityManager.flush()

        println("\n Customer: $juergen.toString() \n")

        val found = userRepository.findByIdOrNull(juergen.id!!)
        assertThat(found).isEqualTo(juergen)
    }

    @Test
    @DisplayName("Create user and find by lastname")
    fun findUserByLastName(){
        val juergen = Customer(firstName = "Juergen", lastName = "Hoeller")

        entityManager.persist(juergen)
        entityManager.flush()

        println("\n Customer: $juergen.toString() \n")

        val found = userRepository.findByLastName((juergen.lastName))
        assertThat(found[0]).isEqualTo(juergen)
    }
}