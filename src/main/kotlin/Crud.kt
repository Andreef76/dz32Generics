
import java.util.*

interface Crud { //не надо так вот и не понимаю в лекциях тут тип
    //Этот интерфейс не надо тестировать, только наследника
    fun <T> create(input: T, storage: MutableList<T>): T { //первый параметр - элемент который нужно создать, второй параметр - хранилище, куда этот элемент нужно положить (такого же типа), здесь c, так как у этой коллекции одни из самых гибких методов
        storage.add(input)
        return storage.last()
    }
//    fun <T> update(input: T, storage: MutableList<T>): T {
//        // так всё равно сдать не получится, find {} это лямбда, она в следующем занятии, переделать на обычный for придётся ну for для меня понятнее пока  что
//        storage.find { noteId == input } // А вот тут будет сложность, мы не сможем обратиться к полям (id и прочее)  не знаю пока что даже написть
//        // чтобы сравнить элементы придётся переписать метод Equals для Notes и Comment   ясно. вопрос как только в процессе обучения не имея опыта к таким умозаключениям приходить :)
//    return input
//    }
    fun <T> edit(list: MutableList<T>, element: T): Boolean {
        // TODO внести проверку не числится ли элемент удаленным
     // if (!NoteService.notesArray[1].isDelete) println("объект удален")
        list.find { it == element } ?: return throw NoteNotFoundException("Пост не найден")//равны будут при равных id (изменённый метод equals), если не найдёт равных сразу вернёт false
        val index = list.indexOf(element) // вычисляем индекс подошедшего элемента
        list.removeAt(index) //удаляем элемент по индексу
        list.add(index, element) // добавляем элемент по индексу
        return true //если без Generic то так с лямбда функциями. а джинерик это что бы через одну функцию еще и editComment делал? да
    // вот не догоняю я как с параметрами обходится в функции
    }// это не правильно тогда метод написан


    // сигнатура у них будет одинаковая, отличаться будут только типы возвращаемых значений и то что внутри функции сигнатура одинаковая с
    // я даже гне соображу что мы сюда сейчас пишем
    // read должна вернуть список что такое реад читать в описании вк нет такой функции
    // то же что и get

    fun <T> delete(list: MutableList<T>, element: T): Boolean {         // метод удаляет (помечает как удаленный) комментарий к заметке.
        list.find { it == element } ?: return false //равны будут при равных id (изменённый метод equals), если не найдёт равных сразу вернёт false
        if (element is Comment)  {
            return edit(list as MutableList<Comment>, element.copy(isDelete = true))
        }
        if (element is Notes)  {
            return edit(list as MutableList<Notes>, element.copy(isDelete = true))
        }
//        val index = list.indexOf(element) // вычисляем индекс подошедшего элемента
//        list.removeAt(index) //удаляем элемент по индексу
//        list.add(index, element) // добавляем элемент по индексу ?? Добавляем в remove? ща соображу перезаписываем с новым значением поля
//        //Это то же самое что edit
        return list.remove(element)
    }
    fun <T> get(list: MutableList<T>) {                 // Возвращает список заметок***, созданных пользователем.
        for (item in list)
            println(item)
    }
}











