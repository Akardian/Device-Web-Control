package mediaControl.tutorial.jpa

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class Customer(
    @Id @GeneratedValue var id: Long? = null,
    var firstName: String,
    var lastName: String
) {

    override fun toString(): String {
        return "Customer(id=$id, firstName='$firstName', lastName='$lastName')"
    }
}