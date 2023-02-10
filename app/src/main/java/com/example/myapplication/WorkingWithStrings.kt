package com.example.myapplication

import java.util.*

class WorkingWithStrings {

    fun main() {

        // invert string
        val subjectString: String = "aaba"
        var invertedString: String = ""
        for (s in subjectString) {
            invertedString = s + "" + invertedString
        }
        println(invertedString)

        // replace substrings
        val keyWords = mapOf("@test" to "laptop", "@okay" to "gone")
        val inputWord ="some random string @test challenge @okay"
        var outputWord=inputWord
        for(word in keyWords){
            outputWord = outputWord.replace(word.key,word.value)
        }
        println(outputWord)

        //validator
        val cardNumber = "1234567890123456"
        val cardExpDate = "01/99"
        println("Is $cardNumber with $cardExpDate valid: "+validate(cardNumber,cardExpDate))

    }
    private fun validate(number: String, exp: String): Boolean {
        return cardNumberValidator(number)&&
                validCardDate(exp)
    }

    private fun validCardDate(date: String): Boolean {
        val specialDig = listOf("-", "/", ",", ".", " ")
        var expDate = date
        for (d in specialDig) {
            expDate = expDate.replace(d, "")
        }
        var valid = false
        if (expDate.length < 4) return valid

        val m = expDate.substring(0, 2)
        val y = expDate.substring(2, 4)
        val month = m.toInt()
        val year = ("20"+y).toInt()
        val calendar: Calendar = Calendar.getInstance()
        val currentYear: Int = calendar.get(Calendar.YEAR)
        val currentMonth: Int = calendar.get(Calendar.MONTH)
        if (month > 12) valid = false
        valid = if (year < currentYear) false
        else !(year == currentYear && month < currentMonth)
        return valid
    }

    private fun cardNumberValidator(input: String): Boolean {
        var cardNumber = input
        val regex = "[0-9]{16}".toRegex()
        val specialDig = listOf("-", "/", ",", ".", " ")
        for (d in specialDig) {
            cardNumber = cardNumber.replace(d, "")
        }
        return cardNumber.matches(regex)
    }

}