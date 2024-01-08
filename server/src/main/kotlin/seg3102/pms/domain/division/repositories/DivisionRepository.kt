package seg3102.pms.domain.division.repositories

import seg3102.pms.domain.division.entities.Division

interface DivisionRepository {
    fun find(divisionId: String): Division?
    fun save(division: Division): Division
}