package de.mike.devicewebcontrol.tutorial.vaadin.views

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.value.ValueChangeMode
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import de.mike.devicewebcontrol.tutorial.vaadin.ContactForm
import de.mike.devicewebcontrol.tutorial.vaadin.CustomerService
import de.mike.devicewebcontrol.tutorial.vaadin.data.entity.Contact


@Route("/tutorial")
@PageTitle("Vaadin Tutorial")
class ContactView(
    private val service: CustomerService
) : VerticalLayout() {
    private val grid = Grid(Contact::class.java)
    private val filterText = TextField()
    private val contactForm: ContactForm

    init {
        addClassName("customer-view")
        setSizeFull()
        configureGrid()
        contactForm = configureForm()
        add(getToolbar(), getContent())

        updateList()
    }

    private fun configureGrid(){
        grid.addClassName("contact-grid")
        grid.setSizeFull()
        grid.setColumns("firstName", "lastName", "email")
        grid.addColumn(Contact::status.name).setHeader("Status")
        grid.addColumn(Contact::company.name).setHeader("Company")
        grid.columns.forEach{col: Grid.Column<Contact> ->
            col.setAutoWidth(true)
        }
    }

    private fun configureForm(): ContactForm {
        val contactForm = ContactForm(emptyList(), emptyList())
        contactForm.width = "25em"

        return contactForm
    }

    private fun getContent(): HorizontalLayout {
        val content = HorizontalLayout(grid, contactForm)
        content.setFlexGrow(2.0, grid)
        content.setFlexGrow(1.0, contactForm)
        content.addClassName("content")
        content.setSizeFull()

        return content
    }

    private fun getToolbar(): HorizontalLayout{
        filterText.placeholder = "Filter by name..."
        filterText.isClearButtonVisible = true
        filterText.valueChangeMode = ValueChangeMode.LAZY
        filterText.addValueChangeListener { updateList() }

        val toolbar = HorizontalLayout(filterText, Button("Add contact"))
        toolbar.addClassName("toolbar")

        return toolbar
    }

    private fun updateList() {
        grid.setItems(service.findAllContacts(filterText.value));
    }
}