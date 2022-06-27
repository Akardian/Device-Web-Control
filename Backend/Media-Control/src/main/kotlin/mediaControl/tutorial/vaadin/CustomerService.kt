package mediaControl.tutorial.vaadin

import mediaControl.tutorial.vaadin.data.entity.Company
import mediaControl.tutorial.vaadin.data.entity.Contact
import mediaControl.tutorial.vaadin.data.entity.Status
import mediaControl.tutorial.vaadin.data.repository.CompanyRepository
import mediaControl.tutorial.vaadin.data.repository.ContactRepository
import mediaControl.tutorial.vaadin.data.repository.StatusRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val contactRepository: ContactRepository,
    private val companyRepository: CompanyRepository,
    private val statusRepository: StatusRepository
) {
    fun findAllContacts(stringFilter: String): List<Contact> {
        return if(stringFilter.isEmpty()) {
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
        contactRepository.save(contact)
    }

    fun findAllCompanies(): List<Company> {
        return companyRepository.findAll()
    }

    fun findAllStatuses(): List<Status> {
        return statusRepository.findAll()
    }
}