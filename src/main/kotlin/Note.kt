class Note (val name: String, val text: String) {
    fun readNote() {
        println("Заголовок заметки: $name")
        println("Текст заметки: $text")
    }
}