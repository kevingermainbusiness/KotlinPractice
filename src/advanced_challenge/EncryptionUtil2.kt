package advanced_challenge

import interfaces.CryptographicInterface

/**
 * WARNING: DOCUMENTATION MERITS REVISION.
 * @author Kevin Germain
 * */
// Second version (inside of an object)
object StringCryptoProtocol : CryptographicInterface.SimpleEncryption<String, CharArray> {

    private var individualChars: Char = '\u0000'

    override val specialKey: Int get() = 6

    override var lastEncryptedData: CharArray = charArrayOf()

    /**
     * @param dataBeforeEncryption is the original data to be encrypted
     **
     * [individualChars] will take individual characters in the now [CharArray] dataBeforeEncryption variable
     **
     * [specialKey] the number of steps to jump forward to, to replace individual characters
     * (for example a becomes g) 6 steps forward
     **
     * [lastEncryptedData] takes each [individualChars] thar are now encrypted
     * */
    override fun encrypt(dataBeforeEncryption: String) {
        for (charInArray in dataBeforeEncryption.toCharArray()) {
            individualChars = charInArray
            individualChars += specialKey
            lastEncryptedData += individualChars
            print(individualChars)
        }
    }

    /**
     * [newLine] invokes println()
     **
     * The for() loop, loops through [lastEncryptedData] to get each [Char] from it
     **
     * [specialKey] the number of steps to jump backwards to, to replace individual characters
     * (for example g becomes a) 6 steps backwards
     **
     * */
    override fun decrypt() {
        newLine
        for (c in lastEncryptedData) {
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
