package Mock.Service

import Mock.Model.Person
import Mock.Repository.PersonRepository

//ViewModel
class PersonService(private val personRepository: PersonRepository) {

    //Gimana cara bikin unit test untuk PersonService?
    //Sementara PersonService butuh object PersonRespository
    //Maka dari itu kita mocking repository nya dan fokus test PersonService

    fun get(id: String): Person {
        if(id.isBlank()){
            throw IllegalArgumentException("Person ID is not valid")
        }
        val person = personRepository.selectById(id)
        if (person != null){
            return person
        } else {
            throw Exception("Person not found")
        }
    }

}