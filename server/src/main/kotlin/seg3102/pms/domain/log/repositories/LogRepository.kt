package seg3102.pms.domain.log.repositories

import seg3102.pms.domain.log.entities.Log
import java.util.UUID

interface LogRepository {
    fun save(log: Log): Log
    fun find(id: UUID): Log?
}