data class Positive



fun  add()  {
    val title: String           // Заголовок заметки.
    val  text: String                 // Текст заметки.
    val privacy: Array<String> = arrayOf(1, 2, 3, 4, 5)
}
fun editComment() {
    val commentId: Positive     // Идентификатор комментария.
    val ownerId: Positive       // Идентификатор владельца заметки
    val message: String         // Новый текст комментария.
}



