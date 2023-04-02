import NoteService.comment1
import NoteService.getById
import NoteService.notes1
import NoteService.notes2
import NoteService.notesArray
import NoteService.restoreComment
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ServiceTest {

    @Before
    fun fill() {
        NoteService.clear()
        NoteService.create(notes1, notesArray)
        NoteService.create(notes2, notesArray)
        NoteService.create(comment1, notesArray[1].comments)
    }  //  тут мы что делали заполняли первоначальными данными а почему в самом меоде нельза можно, но в каждом методе зачем, когда можно в Before ,
    // бефоре на весе тесты распространяется? Запускается перед каждым тестом jr

    @Test
    fun getByIdTest() {
        val result = getById(1)
        assertTrue(result)

    }

    @Test
    fun editTest() { //? так нужно эти методы тестировать или нет? Тестировать через NoteService где задание
        val result = NoteService.edit(notesArray, notes1) //Не нужно тестировать прям всё, но на исключения должны быть
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editTestExc() { //? так нужно эти методы тестировать или нет? Тестировать через NoteService где задание
        val testNote = notes1.copy(noteId = 99)
        val result = NoteService.edit(notesArray, testNote) //Не нужно тестировать прям всё, но на исключения должны быть
        // создать где то в одном методе исключение и протестировать?
        assertTrue(result)// спасибо. Задание следующее можно посмотреть не принимая
        //Что бы о дедлайне не задумываться) в этом же проекте сейчас? потом  удалить и сдавать это ДЗ? Что удалить? ок давайте конечно посмотрим
        //Задание я на будущее показал просто чтоб не нажимать кнопку приступить и не запускать дедлайн понял!! Доделывайте и запрашивайте продление. запросил продлили сегодня расчитываю запустить. предворительно вам напишу ок
    }

    @Test
    fun restoreCommentTest() {
        val result: Boolean = restoreComment(3)
        assertTrue(result)

    }
}