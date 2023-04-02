data class Notes (

    val noteId: Int,
    val title: String,
    val text: String,
    val ownerId: Int, //создатель заметки
    val date: Int,
    var isDelete: Boolean = false,  // метка для обозначения удаления заметки tru - удален
    var comments: MutableList<Comment> = arrayListOf()
    ) {

    override fun equals(other: Any?): Boolean {
       // if (!this.isDelete) println("объект удален")
        val expected = if (other is Notes) other else return super.equals(other)
        return (this.noteId == expected.noteId)

    }
}

data class Comment (

    val commentId: Int,
    val noteId: Int,
    val message: String,
    val ownerComment: Int, //создатель коммента
    val date: Int,
    val isDelete: Boolean = false  // метка для обозначения удаления комментария tru - удален
)

{

    override fun equals(other: Any?): Boolean {
        val expected = if (other is Comment) other else return super.equals(other)
        return this.commentId == expected.commentId

    }
}

