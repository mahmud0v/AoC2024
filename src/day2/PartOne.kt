package day2

import java.io.File
import kotlin.math.abs

fun main() {
    // row numbers are all either all increasing or all decreasing
    // adjacent levels differ by at least one and at most three

    var safeReportNumber = 0
    File("Day2Inputs.txt").forEachLine { line ->
        val rowElements = line.split(" ")
        var allIncreasingResult = false
        var allDecreasingResult = false
        for (i in 1 until rowElements.size) { // 1 2 7 8 9
            val a = rowElements[i - 1].toInt()
            val b = rowElements[i].toInt()
            if (a > b && (abs((a - b)) in 1..3)) {
                allDecreasingResult = true
            } else if (a < b && (abs((a - b)) in 1..3)) {
                allIncreasingResult = true
            } else if (allIncreasingResult && allDecreasingResult) {
                break
            }else {
                allIncreasingResult = true
                allDecreasingResult = true
                break
            }
        }

        if (!(allIncreasingResult && allDecreasingResult)) {
            safeReportNumber++
        }
    }

    print(safeReportNumber)
}