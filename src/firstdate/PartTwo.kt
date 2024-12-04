package firstdate

import java.io.File

fun main() {
    val leftColumn = mutableListOf<Int>()
    val rightColumn = mutableListOf<Int>()

    File("FirstDate.txt").forEachLine { line ->
        val list1 = line.split("   ")
        leftColumn.add(list1[0].toInt())
        rightColumn.add(list1[1].toInt())
    }


    var sum = 0
    for (i in leftColumn) {
        var appearanceElement = 0
        for (j in rightColumn) {
            if (i == j) {
                appearanceElement++
            }
        }
        sum+=i*appearanceElement
    }

    print(sum)

}