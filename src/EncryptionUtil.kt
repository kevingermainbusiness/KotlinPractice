/**
 * @author Kevin Germain
 * */
fun String.encryptText() {

    val allTextCharacters = this.toCharArray()
    var eachCharacters: Char
    var charactersList = ""

    for (c in allTextCharacters) {
        eachCharacters = c
        eachCharacters += DEFAULT_KEY
        print(eachCharacters)
        charactersList += eachCharacters
    }
    LAST_ENCRYPTED_TEXT = charactersList
}

fun String.decryptText() {
    val allTextCharacters = this.toCharArray()
    var eachCharacters: Char
    var charactersList = ""

    for (c in allTextCharacters) {
        eachCharacters = c
        eachCharacters -= DEFAULT_KEY
        print(eachCharacters)
        charactersList += eachCharacters
    }
}

// Second version (inside of an object)
object SimpleTextCryptoMethod {
    private var individualCharacters: Char = '\u0000'
    var fullTextOfIndividualCharacters = ""

    /**
     * This algorithm encrypts a text by adding the [DEFAULT_KEY]th character
     * from the encoding that it belongs to, after each characters from the [message] String.
     * How it does it?
     *
     * It takes the [message] text, decomposes each characters into a [CharArray] where
     * each element in the [message] String is considered a [Char].
     *
     * [messageTextToCharArray] now containing each characters from the [message] text,
     * the function performs a loop through the [messageTextToCharArray]
     * for each loop that occurs, each characters is replaced by the [DEFAULT_KEY]th character
     * from the encoding that it belongs to, for example UTF-16; then [fullTextOfIndividualCharacters]
     * gets every character from [individualCharacters]
     * */
    fun encrypt(message: String) {
        val messageTextToCharArray = message.toCharArray()
        for (c in messageTextToCharArray) {
            individualCharacters = c
            individualCharacters += DEFAULT_KEY
            fullTextOfIndividualCharacters += individualCharacters
            print(individualCharacters)
        }
    }

    fun decrypt() {
        print("\n")
        val allTextCharacters = fullTextOfIndividualCharacters.toCharArray()
        for (c in allTextCharacters) {
            individualCharacters = c
            individualCharacters -= DEFAULT_KEY
            print(individualCharacters)
        }
    }

    val addLineBreak: Unit get() = println("\n")
}

const val DEFAULT_KEY: Int = 6
var LAST_ENCRYPTED_TEXT: String = ""