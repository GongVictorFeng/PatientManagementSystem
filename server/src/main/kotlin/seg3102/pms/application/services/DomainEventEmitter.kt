package seg3102.pms.application.services

import seg3102.pms.domain.common.DomainEvent

interface DomainEventEmitter {
    fun emit(event: DomainEvent)
}
