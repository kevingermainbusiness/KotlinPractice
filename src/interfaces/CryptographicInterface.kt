package interfaces

/**
 * This interface aims to help build a simple symmetric encryption protocol.
 **
 * I Recommend to use it with [ByteArray] but it can be used with any types of data.
 **
 * [specialKey] Special key that helps encrypt & decrypt the bytes
 **
 * [newLine] Adds new line in the terminal.
 **
 * [encrypt] should be implemented as a symmetric encryption function
 * using [specialKey] as key
 **
 * [decrypt] should be implemented as a symmetric decryption function
 * using [specialKey] as key
 * @author Kevin Germain
 * */
interface CryptographicInterface {

    interface Base {

        val specialKey: Int

        val newLine: Unit get() = println()
    }

    interface SimpleEncryption<A, B> : Base {

        fun encrypt(dataBeforeEncryption: A)

        var lastEncryptedData: B

        fun decrypt()
    }

    interface AdvancedSymmetricEncryption<T> : Base {

        fun encrypt(mData: T): T

        fun decrypt(encryptedData: T): T

        var lastEncryptedData: T

        fun decryptLastEncryptedData(): T = lastEncryptedData

        fun lastEncryptedDataToString(): String = ""

    }
}