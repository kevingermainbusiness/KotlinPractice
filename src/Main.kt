fun main() {
    // using own toString method && testing the any function on a collection
    val options = mutableListOf("Fast", "Worship singing", "Pray", "Coding", "Learning")
    val numbers = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12)
    if (numbers.containsEven) println(options.stringifyOptions)

    // send mail
    val client = Client(PersonalInfo("kevingermainbusiness@gmail.com"))
    sendMessageToClient(client, "The mail I want to send", SimpleMailer())

    // creating a smart cast system, eval() fun comes from the SmartCast_ kotlin file
    println("SmartCast_ : " + eval(Sum(Num(3), Num(6))))

    // Determine if a division returns a rational number
    val division = RationalNumber(8, 0)
    division.printOutRationalResult
}