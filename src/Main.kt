fun joinOptions(options: Collection<String>) = options.joinToString()

/**
 * I feel a sense of pride for having created this function even though it's after looking into the implementation
 * The fact that I tried doing it my way, gives me a sense of achievement
 * @author Kevin Germain
 * */
fun Collection<String>.joinToString(prefix: String = "[", separator: String = ",", postfix: String = "]"): String {
    val count = this.size
    var items = "$prefix "
    this.forEachIndexed { index, el ->
        items += if (index == count - 1) el else el + separator
    }
    return items + postfix
}

/** Thought of the it % 2 but had to search on another project for the == 0 rest of the algorithm */
fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }


fun main() {
    // using own toString method && testing the any function on a collection
    val options = mutableListOf("Fast", "Worship singing", "Pray", "Coding", "Learning")
    val numbers = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12)
    if (containsEven(numbers)) println(joinOptions(options))

    // send mail
    val client = Client(PersonalInfo("kevingermainbusiness@gmail.com"))
    sendMessageToClient(client, "The mail I want to send", SimpleMailer())

    // creating a smart cast system, eval() fun comes from the SmartCast_ kotlin file
    println("SmartCast_ : " + eval(Sum(Num(3), Num(6))))

    // Determine if a division returns a rational number
    val division = RationalNumber(2, 4)
    if (division.isRationalNumber()) {
        println("Rational Number: " + division.toRationalNumberResult())
    }
}