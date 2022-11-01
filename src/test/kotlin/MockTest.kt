import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

class MockTest {


    @Test
    fun testMock(){

        // Mock merupakan object tiruan yang memiliki perilaku (behaviour)
        // seperti object aslinya serta memiliki ekspektasi akan hasil interaksinya.
        // Walupun membuat object tiruan kita tetap bisa memanggil functionnya dan dapat get data di mockingnnya

        //membuat mock
        val list: List<String> = Mockito.mock(List::class.java) as List<String>

        //menambahkan behaviour(apa yg akan dilakukan) di mock(tiruan) object
        //ketika get(0) dipanggil maka akan memberikan nilai "Ikhsan"
        Mockito.`when`(list.get(0)).thenReturn("Ikhsan")
        Mockito.`when`(list.get(1)).thenReturn("Mardika")

        //test mock
        //paling penting disini, karena mem-validasi skenario expected dan actual result
        assertEquals("Ikhsan", list.get(0))
        assertEquals("Mardika", list.get(1))
        assertEquals("Mardika", list.get(1))

        //mem-verifikasi bahwa function pernah dipanggil
        Mockito.verify(list).get(0)
        //mem-verifikasi bahwa function pernah dipanggil 2x
        Mockito.verify(list, Mockito.times(2)).get(1)

    }


}