package seg3102.pms.domain.staff.entities

class StaffAccount(
    val employeeNumber: String,
    var name: String,
    val password: String,
    val email: String,
    var divisionId: String
) {
    var role: StaffRole? = null

    fun assignRoleToAccount(role: String) {
        this.role = StaffRole(role)
    }
}