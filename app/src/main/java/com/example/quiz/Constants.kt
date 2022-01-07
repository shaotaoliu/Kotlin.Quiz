package com.example.quiz

object Constants {
    fun getQuestions(): Array<Question> {
        return arrayOf(
            Question("Which state is the largest one in the United States?",
                arrayOf("California", "Alaska", "Texas", "Florida"),
                intArrayOf(1)
            ),
            Question("Which state is the most populous in the United States?",
                arrayOf("California", "Alaska", "Texas", "Florida"),
                intArrayOf(0)
            ),
            Question("Which states are in the western of the United States?",
                arrayOf("Florida", "California", "Oregon", "New York", "Washington"),
                intArrayOf(1, 2, 4)
            ),
            Question("Which city is the most populous city in the United States?",
                arrayOf("Houston", "Washington, D.C.", "Miami", "New York", "Los Angeles"),
                intArrayOf(3)
            ),
            Question("Which city is the capital of California?",
                arrayOf("Los Angeles", "San Diego", "San Francisco", "Sacramento"),
                intArrayOf(3)
            ),
            Question("Which cities are in the State of California?",
                arrayOf("Los Angeles", "San Diego", "Las Vegas", "Phoenix", "San Jose"),
                intArrayOf(0, 1, 4)
            ),
            Question("Which countries border the United States?",
                arrayOf("Canada", "Japan", "Russia", "Mexico"),
                intArrayOf(0, 3)
            ),
            Question("What is the capital of the United States?",
                arrayOf("Washington, D.C.", "Los Angeles", "New York", "Philadelphia"),
                intArrayOf(0)
            ),
            Question("Where is the Statue of Liberty?",
                arrayOf("Washington, D.C.", "Los Angeles", "New York", "Philadelphia"),
                intArrayOf(2)
            ),
            Question("Who was the first President of the United States?",
                arrayOf("James Madison", "Thomas Jefferson", "John Adams", "George Washington"),
                intArrayOf(3)
            )
        )
    }
}