package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.log.entities.Log
import seg3102.pms.domain.log.repositories.LogRepository
import java.util.HashMap
import java.util.UUID

class LogRepositoryStub: LogRepository {
    private val logs: MutableMap<UUID, Log> = HashMap()

    override fun save(log: Log): Log {
        logs[log.id] = log
        return log
    }

    override fun find(id: UUID): Log? = logs[id]
}