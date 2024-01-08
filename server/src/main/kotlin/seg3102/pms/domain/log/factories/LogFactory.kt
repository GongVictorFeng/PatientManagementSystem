package seg3102.pms.domain.log.factories

import seg3102.pms.domain.log.entities.Log

interface LogFactory {
    fun createLog(operation:String): Log
}