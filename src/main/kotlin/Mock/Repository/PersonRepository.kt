package Mock.Repository

import Mock.Model.Person

interface PersonRepository {

    fun selectById(id: String): Person?

}