package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3102.pms.domain.log.entities.Log
import seg3102.pms.domain.log.factories.LogFactory
import java.time.LocalDateTime
import java.util.*

@Primary
@Component
class LogFactoryImpl: LogFactory {
    override fun createLog(operation: String): Log {
        return Log(UUID.randomUUID(), operation, LocalDateTime.now())
    }
}