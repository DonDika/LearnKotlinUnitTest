import Mock.Model.Person
import Mock.Repository.PersonRepository
import Mock.Service.PersonService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@Extensions(value = [
    ExtendWith(MockitoExtension::class)
])
class PersonServiceTest {

    //Mocking inject object
    @Mock
    lateinit var personRepository: PersonRepository
    //tidak perlu di mock
    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach(){
        personService = PersonService(personRepository)
    }

    @Test
    fun `test Person Id Is Not Valid`(){
        assertThrows<IllegalArgumentException>{
            personService.get("   ")
        }
    }

    @Test
    fun `test Person Not Found`(){
        assertThrows<Exception> {
            personService.get("not found")
        }
    }

    @Test
    fun `test Get Person Success`(){


        //Tambahkan behaviour nya
        //Misalnya personRepository dipanggil function selectById dengan parameter "satu"
        //Maka akan me-return-kan data Person("satu", "Ikhsan Mardika")
        Mockito.`when`(personRepository.selectById("dua")).thenReturn(Person("dua", "Anto Suprapto"))

        //jadi ketika get dengan personService maka akan mendapatkan datanya
        //meminta function get dengan id "dua"
        val person = personService.get("dua")
        //expected, actual
        assertEquals("dua", person.id)
        assertEquals("Anto Suprapto", person.name)
    }



}