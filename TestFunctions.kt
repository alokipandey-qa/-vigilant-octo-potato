package com.example.myfirstapicall


fun countAlphabets(str: String): Int {
    var count = 0
    for (i in 0 until str.length - 1) {
        if (Character.isLetter(str.get(i))) count++
    }
    return count
}


fun numberOfPrime(beg: Int, end: Int): Array<Int> {
    val primeNums: Array<Int> = arrayOf()
    for (i in beg + 1..end - 1) {
        for (j in 2..i / 2) {
            if (i % j == 0) {
                primeNums.set(primeNums.lastIndex + 1, i)
            }
        }
    }
    return primeNums
}


fun countVowels(str: String): Int {
    var count = 0
    for (i in 0..str.length - 1) {
        val char = str.get(i)
        if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u') {
            count++
        }
    }
    return count
}


fun countSentences(str: String): Int {
    var count = 0
    for (i in 0..str.length - 1) {
        val char = str.get(i)
        if (char == '.' || char == '!') count++
    }
    return count
}

fun countWords(str: String): Int {
    var count = 0
    var words = str.split("\\s+")
    return words.size
}


fun removeDuplicates(arr: Array<Int>): ArrayList<Int> {
    val temp = HashMap<Int, Boolean>()
    val arr2: ArrayList<Int> = arrayListOf()
    for (i in arr) {
        if (temp.get(i) == null) {
            temp.put(i, true)
            arr2.add(i)
        }
    }
    return arr2
}


fun cardDeck(player1: ArrayList<ArrayList<String>>, player2: ArrayList<ArrayList<String>>): String {
    val transactionMap = HashMap<String, Int>()
    transactionMap.put("SP", 100); transactionMap.put("CL", 50); transactionMap.put("HT", -100);
    transactionMap.put("DD", -50)

    var p1Amount = 1000;
    var p2Amount = 1000

    for (i in 0..player1.size) {
        p1Amount += transactionMap.get(player1[i][0])!!
        p1Amount += transactionMap.get(player1[i][1])!!

        p2Amount += transactionMap.get(player2[i][0])!!
        p2Amount += transactionMap.get(player2[i][1])!!
    }
    if (p1Amount > p2Amount) return "Winner:Player1"
    if (p1Amount == p2Amount) return "Winner:Match Tie"
    else return "Winner:Player2"
}
