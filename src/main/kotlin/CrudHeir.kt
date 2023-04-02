
object NoteService : Crud { //Вот наследник Crud
    var notes1 = Notes(1, "1", "1", 1, 1, false)
    var notes2 = Notes(2, "2", "2", 2, 2, false)
    var comment1 = Comment(3, 1, "3", 3, 3, false)


    //val testListInt: MutableList<Int> = mutableListOf()
    // val testListString: MutableList<String> = mutableListOf()
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
//            note.comments = note.comments.map { //лямбда map
//                if (it.commentId == element) {
//                    it.copy(isDelete = false)
//                    return true
//                } else it
//            }.toMutableList() //вроде всё спасибо. я понимаю тут 2 варианта?  ок
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
        NoteService.delete(NoteService.notesArray[1].comments, NoteService.notesArray[1].comments[0]) //так нормально отработает а у меня не верно было, как было он бы просто удалил элемент из массива вроде работал. ставил пометку тру//да, отредактировать чтобы в поле isDelete было  так у меня метод отдельно назыв делит // нам удалять не надо комментарий// пометка на удаление комментария
        // как прописать путь к конкретному комментарию, конкретной заметки??? но можно было как у меня? понимаю что повторение кода или недопустимо?
        // Так логически правильнее так как не надо в параметр передавать копию с флагом isDelete. ок Вопросы? остальное все верно работает. можно готовить к отправке?
// я вижу что разные типы но пока не соображу или сразу отправить на проверку, пока не надо, я сейчас проверяю там одну, как закончу скажу...у меня правда вчера был срок сдачи работы, скинули бы вчера) только сегодня доделал. Отправите запрос на продление дедлайна
        println(NoteService.notesArray[1].comments)
        NoteService.restoreComment(0) // а откуда брать будет список
        println(NoteService.notesArray[1].comments)
        NoteService.get(NoteService.notesArray)
        NoteService.get(NoteService.notesArray[1].comments)   // как прописать путь к списку комментариев конкретной заметки??? da не посмотрите как получилось в целом
        println()
        println()
        NoteService.getById(2)
        NoteService.restoreComment(1)
    }




