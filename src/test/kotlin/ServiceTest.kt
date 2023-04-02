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
    }

    @Test
    fun getByIdTest() {
        val result = getById(1)
        assertTrue(result)
    }

    @Test
    fun editTest() {
        val result = NoteService.edit(notesArray, notes1)
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editTestExc() {
        val testNote = notes1.copy(noteId = 99)
        val result = NoteService.edit(notesArray, testNote)
        assertTrue(result)
    }

    @Test
    fun restoreCommentTest() {
        val result: Boolean = restoreComment(3)
        assertTrue(result)

    }
}