package seg3102.pms.contracts.testStubs.factories

import seg3102.pms.domain.log.entities.Log
import seg3102.pms.domain.log.factories.LogFactory
import java.time.LocalDateTime
import java.util.*

class LogFactoryStub: LogFactory {
    override fun createLog(operation: String): Log {
        return Log(
            UUID.randomUUID(),
            operation,
            LocalDateTime.now()
        )
    }
}