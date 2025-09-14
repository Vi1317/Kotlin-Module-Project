import java.util.Scanner

class Archive (val name: String) {
    val notes: MutableList<Note> = ArrayList()

    fun addNote() {
        val scanner = Scanner(System.`in`)
        println("Введите название заметки:")

        val name = scanner.nextLine()

        while (name.trim().isEmpty()) {
            println("Вы не ввели название!")
            return
        }

        println("Введите текст заметки:")

        val text = scanner.nextLine()

        while (text.trim().isEmpty()) {
            println("Вы не ввели текст!")
            return
        }

        notes.add(Note(name, text))
        println("Заметка \"$name\" с текстом \"$text\" добавлена.")
    }

    fun showNoteMenu() {
        var exit = false
        while (!exit) {
            val namesList: MutableList<String> = ArrayList()
            for(note in notes) {
                namesList.add(note.name)
            }
            println("Список заметок в архиве:")

            val menu = Menu()
            val elementsCount = menu.printMenu("Создать заметку", namesList)
            val input = menu.getUserInput()
            menu.handleInput(input,
                elementsCount,
                { addNote()},
                {notes[input-1].readNote()},
                { exit = true })
        }

        return
    }
}
