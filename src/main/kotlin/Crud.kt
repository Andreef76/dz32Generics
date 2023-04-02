
interface Crud {
    fun <T> create(input: T, storage: MutableList<T>): T {
        storage.add(input)
        return storage.last()
    }

    fun <T> edit(list: MutableList<T>, element: T): Boolean {
        list.find { it == element } ?: return throw NoteNotFoundException("Пост не найден")
        val index = list.indexOf(element)
        list.removeAt(index)
        list.add(index, element)
        return true
    }

    fun <T> delete(list: MutableList<T>, element: T): Boolean {
        list.find { it == element } ?: return false
        if (element is Comment)  {
            return edit(list as MutableList<Comment>, element.copy(isDelete = true))
        }
        if (element is Notes)  {
            return edit(list as MutableList<Notes>, element.copy(isDelete = true))
        }
        return list.remove(element)
    }
    fun <T> get(list: MutableList<T>) {
        for (item in list)
            println(item)
    }
}











