package de.mike.devicewebcontrol.tutorial.vaadin

import de.mike.devicewebcontrol.logging.LoggingController
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Company
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Contact
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Status
import de.mike.devicewebcontrol.tutorial.vaadin.data.repository.CompanyRepository
import de.mike.devicewebcontrol.tutorial.vaadin.data.repository.ContactRepository
import de.mike.devicewebcontrol.tutorial.vaadin.data.repository.StatusRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val contactRepository: ContactRepository,
    private val companyRepository: CompanyRepository,
    private val statusRepository: StatusRepository
) {
    fun findAllContacts(stringFilter: String): List<Contact> {
        return if(stringFilter == null || stringFilter.isEmpty()) {
            contactRepository.findAll()
        } else {
            contactRepository.search(stringFilter)
        }
    }

    fun countContacts(): Long {
        return contactRepository.count()
    }

    fun deleteContact(contact: Contact){
        contactRepository.delete(contact)
    }

    fun saveContact(contact: Contact){
        if(contact == null) {
            LoggingController.logger.warn("Contact is null.")
        }else {
            contactRepository.save(contact)
        }
    }

    fun findAllCompanies(): List<Company> {
        return companyRepository.findAll()
    }

    fun findAllStatuses(): List<Status> {
        return statusRepository.findAll()
    }
}