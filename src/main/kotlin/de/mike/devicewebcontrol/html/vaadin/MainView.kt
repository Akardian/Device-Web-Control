package de.mike.devicewebcontrol.html.vaadin

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route


@Route
@PageTitle("Device Control")
class MainView : VerticalLayout{

    private val layout = HorizontalLayout()

    constructor() {
        val button = Button("I am Button")
        button.addClickListener {
            add(Text("Big Button"))
        }

        layout.add(button)

        add(layout)
    }

}