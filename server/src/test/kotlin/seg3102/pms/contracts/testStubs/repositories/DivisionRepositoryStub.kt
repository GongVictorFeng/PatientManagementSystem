package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.division.repositories.DivisionRepository
import seg3102.pms.domain.division.entities.Division

class DivisionRepositoryStub: DivisionRepository {
    private  val divisions: MutableMap<Int, Division> = HashMap()

    override fun save(division: Division): Division {
        divisions[division.divisionId] = division
        return division
    }

    override fun find(divisionId: String): Division? = divisions[divisionId]
}