import java.io.File

//Puzzle 2016 day 04 före cleanUp
class Day04 {
    val f = File("src/main/resources/input.txt")


    fun part1() {
        val fList = f.readLines().map { it.split("\\s".toRegex()) }
        println(fList.count { it.size == it.toSet().size })
    }

    fun part2() {
        val fList2 = f.readLines().map { it.split(" ").map { it.toCharArray().sorted().joinToString("") } }
            .count { it.size == it.toSet().size }
        println(fList2)

    }
}

//Efter att jag kollat upp andras lösningar och hur man kan snygga upp koden
class Day04CleanUp(private val input: List<String>){

    fun part1CleanUp(): Int =
        input
            .map { it.split("\\s".toRegex()) }
            .count { it.size == it.toSet().size }

    fun part2CleanUp(): Int =
        input
            .map { it.split("\\s".toRegex()).map { it.toCharArray().sorted().joinToString(" ") } }
            .count { it.size == it.toSet().size}

}

//behövs för cleanup för att kunna läsa in "input: List<String>"
//behövs inte för första delen innan Cleanup
fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }



fun main(args: Array<String>) {
    //före cleanup
    val day04 = Day04()
    println(day04.part1())
    println(day04.part2())


    //efter cleanUp, lite jobbigt att behöva skapa en funktion för o läsa fil som en Lista innan den kan användas
    //i min funktioner med "input: List<String>"
    val stringArray = readFileAsLinesUsingUseLines("src/main/resources/input.txt")
    val day04Clean = Day04CleanUp(stringArray)
    println(day04Clean.part1CleanUp())
    println(day04Clean.part2CleanUp())
}