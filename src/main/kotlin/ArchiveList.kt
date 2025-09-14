import java.util.Scanner

class ArchiveList {
    val archives: MutableList<Archive> = ArrayList()

    fun addArchive() {
        val scanner = Scanner(System.`in`)
        println("Введите название архива:")

        val name = scanner.nextLine().trim()

        while (name.isEmpty()) {
            println("Вы не ввели название!")
            return
        }

        archives.add(Archive(name))
        println("Архив \"$name\" добавлен.")
    }

    fun showArchiveMenu() {
        var exit = false
        while (!exit) {
            val namesList: MutableList<String> = ArrayList()
            for(archive in archives) {
                namesList.add(archive.name)
            }

            println("Список архивов:")

            val menu = Menu()
            val elementsCount = menu.printMenu("Создать архив", namesList)
            val input = menu.getUserInput()
            menu.handleInput(input,
                elementsCount,
                { addArchive()},
                {archives[input-1].showNoteMenu()},
                { exit = true })
        }

        return
    }
}