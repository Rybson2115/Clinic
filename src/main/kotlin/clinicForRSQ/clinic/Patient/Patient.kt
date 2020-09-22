package clinicForRSQ.clinic.Patient

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Patient (
      @Id @GeneratedValue private var id: Long,
      private var name: String,
      private var surname: String,
      private var address: String
)