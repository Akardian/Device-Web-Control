package de.mike.devicewebcontrol.tutorial.vaadin

import com.vaadin.flow.component.ComponentEvent
import com.vaadin.flow.component.ComponentEventListener
import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.textfield.EmailField
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.BeanValidationBinder
import com.vaadin.flow.data.binder.ValidationException
import com.vaadin.flow.shared.Registration
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Company
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Contact
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Status


class ContactForm(
    companies: List<Company>,
    statuses: List<Status>
) : FormLayout() {
    private var contact: Contact? = null
        set(value) {
            field = value
            binder.readBean(contact)
        }

    private val firstName = TextField("First name")
    private val lastName = TextField("Last name")
    private val email = EmailField("Email")

    private val status = ComboBox<Status>("Status")
    private val company  = ComboBox<Company>("Company")

    private val save = Button("Save")
    private val delete = Button("Delete")
    private val close = Button("Close")

    private val binder = BeanValidationBinder(Contact::class.java)

    init {
        addClassName("contact-form")
        binder.bindInstanceFields( this)
        company.setItems(companies)
        company.setItemLabelGenerator(Company::name)
        status.setItems((statuses))
        status.setItemLabelGenerator(Status::name)
        add(firstName,
            lastName,
            email,
            company,
            status,
            createButtonsLayout()
        )
    }

    private fun createButtonsLayout(): HorizontalLayout {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY)
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR)
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY)

        save.addClickShortcut(Key.ENTER)
        close.addClickShortcut(Key.ESCAPE)
        //add save, delete, and close event listeners
        save.addClickListener { validateAndSave() }
        delete.addClickListener { fireEvent(DeleteEvent(source = this, contact = contact)) }
        close.addClickListener { fireEvent(CloseEvent(source = this))}
        //Validates the form every time it changes
        binder.addStatusChangeListener { save.isEnabled = binder.isValid }
        return HorizontalLayout(save, delete, close)
    }

    private fun validateAndSave() {
        try {
            //Write the form contents back to the original
            binder.writeBean(contact)
            fireEvent(SaveEvent(source = this, contact = contact))
        } catch (e: ValidationException) {
            e.printStackTrace()
        }
    }

    //Events
    abstract class ContactFormEvent(
        source: ContactForm,
        private val contact: Contact?
    ) : ComponentEvent<ContactForm>(source, false)

    class SaveEvent(
        source: ContactForm,
        contact: Contact?
    ) : ContactFormEvent(source, contact)

    class DeleteEvent(
        source: ContactForm,
        contact: Contact?
    ) : ContactFormEvent(source, contact)

    class CloseEvent(
        source: ContactForm
    ) : ContactFormEvent(source, null)

    override fun <T : ComponentEvent<*>?> addListener(
        eventType: Class<T>,
        listener: ComponentEventListener<T>
    ): Registration {
        return eventBus.addListener(eventType, listener)
    }
}
