package mediaControl.tutorial.vaadin.data.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import mediaControl.tutorial.vaadin.data.AbstractEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
class Contact(
    @NotEmpty
    var lastName: String = "",
    @NotEmpty
    var firstName: String = "",
    @ManyToOne
    @JoinColumn(name = "company_id")
    @NotNull
    @JsonIgnoreProperties("employees")
    var company: Company,
    @Email
    @NotEmpty
    var email: String = "",
    @NotNull
    @ManyToOne
    var status: Status
): AbstractEntity() {

    override fun toString(): String {
        return "Contact(lastName='$lastName', firstName='$firstName', company=$company, email='$email', status=$status)"
    }
}
