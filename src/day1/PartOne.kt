package day1

import java.io.File
import kotlin.math.abs

fun main(){
    val leftColumn = mutableListOf<Int>()
    val rightColumn = mutableListOf<Int>()

    File("Day1Inputs.txt").forEachLine { line ->
        val list1 = line.split("   ")
        leftColumn.add(list1[0].toInt())
        rightColumn.add(list1[1].toInt())
    }

    val sortedLeftColumn = sortList(leftColumn)
    val sortedRightColumn = sortList(rightColumn)
    var difference = 0
    for (i in sortedLeftColumn.indices){
        difference += abs((sortedLeftColumn[i] - sortedRightColumn[i]))
    }

    print(difference)

}


fun sortList(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            if (list[i] > list[j]) {
                val a = list[i]
                list[i] = list[j]
                list[j] = a
            }
        }
    }

    return list
}