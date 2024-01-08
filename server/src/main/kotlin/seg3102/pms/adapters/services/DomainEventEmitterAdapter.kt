package seg3102.pms.adapters.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import seg3102.pms.application.services.DomainEventEmitter
import seg3102.pms.domain.common.DomainEvent

@Component
class DomainEventEmitterAdapter: DomainEventEmitter {
    @Autowired
    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    override fun emit(event: DomainEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}