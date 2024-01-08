package seg3102.pms.contracts.testStubs.services

import seg3102.pms.application.services.DomainEventEmitter
import seg3102.pms.domain.common.DomainEvent
import seg3102.pms.domain.patient.events.NewPatientRegistered
import kotlin.collections.ArrayList
import seg3102.pms.domain.division.events.NewAdmissionAdded
import seg3102.pms.domain.log.events.NewLogAdded

class EventEmitterStub : DomainEventEmitter {
    private val emitted: MutableList<DomainEvent> = ArrayList()

    override fun emit(event: DomainEvent) {
        emitted.add(event)
    }

    fun retrieveNewPatientRegisteredEvent(): NewPatientRegistered {
        return emitted.find { it is NewPatientRegistered} as NewPatientRegistered

    }

    fun retrieveNewAdmissionAddedEvent(): NewAdmissionAdded {
        return emitted.find { it is NewAdmissionAdded} as NewAdmissionAdded

    }

    fun retrieveNewLogAddedEvent(): NewLogAdded {
        return emitted.find { it is NewLogAdded} as NewLogAdded
    }

}