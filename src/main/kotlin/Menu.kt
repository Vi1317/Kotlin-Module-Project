import java.util.Scanner

class Menu {
    fun printMenu(createName: String, items: List<String>): Int {
        var i = 0
        print("${i++}. $createName \n")

        for (item in items) {
            println("$i. $item")
            i++
        }

        println("$i. Выход")
        return i
    }

    fun getUserInput(): Int {
        val scanner = Scanner(System.`in`)

        while (!scanner.hasNextInt()) {
            scanner.next()
            println("Вы ввели не число!")
        }

        return scanner.nextInt()
    }

    fun handleInput(userChoice: Int, elementsCount: Int, createNew: () -> Unit, showItem: () -> Unit, goBack: () -> Unit) {
        when (userChoice) {
            0 -> createNew()
            in 1..(elementsCount - 1) -> showItem()
            elementsCount -> goBack()
            else -> println("Вы ввели неизвестную команду, попробуйте снова!")
        }
    }

}