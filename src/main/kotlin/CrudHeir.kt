
object NoteService : Crud {
    var notes1 = Notes(1, "1", "1", 1, 1, false)
    var notes2 = Notes(2, "2", "2", 2, 2, false)
    var comment1 = Comment(3, 1, "3", 3, 3, false)
    val notesArray: MutableList<Notes> = mutableListOf()     // список для хранения заметок

    fun clear() { notesArray.clear() }
    fun getById(element: Int): Boolean {                // метод возвращает заметку*** по её id
        for (index in notesArray)
            if (index.noteId == element) {
                println(notesArray[element - 1])
                return true
            }
        return false
    }

    fun restoreComment(element: Int): Boolean {          // Метод восстанавливает удалённый комментарий.
        for (note in notesArray)
            for (comment in note.comments)
                if (comment.commentId == element) {
                    val ind = note.comments.indexOf(comment)
                    note.comments.removeAt(ind)
                    note.comments.add(ind, comment.copy(isDelete = false))
                    return true
                }
        return false
    }
}
    fun main() {

        NoteService.create(NoteService.notes1, NoteService.notesArray)
        NoteService.create(NoteService.notes2, NoteService.notesArray)
//        println(NoteService.notesArray)
        NoteService.edit(NoteService.notesArray, NoteService.notes2.copy(title = "Изменено"))
//        println(NoteService.notesArray)
//        NoteService.delete(NoteService.notesArray, NoteService.notes1.copy(isDelete = true))
        NoteService.edit(NoteService.notesArray, NoteService.notes1.copy(title = "Изменено Следующее"))
        NoteService.create(NoteService.comment1, NoteService.notesArray[1].comments)
        println(NoteService.notesArray[1].comments)
        NoteService.delete(NoteService.notesArray[1].comments, NoteService.notesArray[1].comments[0])
         println(NoteService.notesArray[1].comments)
        NoteService.restoreComment(0)
        println(NoteService.notesArray[1].comments)
        NoteService.get(NoteService.notesArray)
        NoteService.get(NoteService.notesArray[1].comments)
        println()
        println()
        NoteService.getById(2)
        NoteService.restoreComment(1)
    }




