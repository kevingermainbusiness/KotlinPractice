/**
 * WARNING: DOCUMENTATION MERITS REVISION.
 * @author Kevin Germain
 * */
// Second version (inside of an object)
object StringCryptoProtocol : CryptographicInterface.SimpleEncryption<String> {

    private var individualChars: Char = '\u0000'
    private var mDataToCharArray = charArrayOf()
    var mDataIndividualCharacters = ""

    override val specialKey: Int
        get() = 6

    /**
     * This algorithm encrypts a text by adding the [specialKey]th character
     * from the encoding that it belongs to, after each characters from the [mData] String.
     * How it does it?
     *
     * It takes the [mData] text, decomposes each characters into a [CharArray] where
     * each element in the [mData] String is considered a [Char].
     *
     * [mDataToCharArray] now containing each characters from the [mData] text,
     * the function performs a loop through the [mDataToCharArray]
     * for each loop that occurs, each characters is replaced by the [specialKey]th character
     * from the encoding that it belongs to, for example UTF-16; then [mDataIndividualCharacters]
     * gets every character from [individualChars]
     * */
    override fun encrypt(mData: String) {
        mDataToCharArray = mData.toCharArray()
        for (charInArray in mDataToCharArray) {
            individualChars = charInArray
            individualChars += specialKey
            mDataIndividualCharacters += individualChars
            print(individualChars)
        }
    }

    override fun decrypt() {
        newLine
        val allTextCharacters = mDataIndividualCharacters.toCharArray()
        for (c in allTextCharacters) {
            individualChars = c
            individualChars -= specialKey
            print(individualChars)
        }
    }
}

fun main() {
    StringCryptoProtocol.encrypt("Beniswa Letènèl, BonDye Gran e Puissant vre wi")
    StringCryptoProtocol.decrypt()
}