package de.mike.devicewebcontrol.tutorial.vaadin.data.entity

import de.mike.devicewebcontrol.tutorial.vaadin.data.AbstractEntity
import javax.persistence.Entity

@Entity
class Status(): AbstractEntity() {
    var name: String? = null

    constructor(name: String) : this() {
        this.name = name
    }
}