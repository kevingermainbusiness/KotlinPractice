import java.nio.file.Files
import java.nio.file.Paths

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

    interface SimpleEncryption<T> : Base {

        fun encrypt(mData: T)

        fun decrypt()
    }

    interface AdvancedSymmetricEncryption<T> : Base {

        fun encrypt(mData: T): T

        fun decrypt(encryptedData: T): T
    }

}

class ByteArrayCryptoProtocol : CryptographicInterface.AdvancedSymmetricEncryption<ByteArray> {

    override val specialKey: Int
        get() = 1

    override fun encrypt(mData: ByteArray): ByteArray {
        val enc = ByteArray(mData.size)
        for (i in mData.indices) {
            enc[i] = (if (i % 2 == 0) mData[i] + specialKey else mData[i] - specialKey).toByte()
        }
        return enc
    }

    override fun decrypt(encryptedData: ByteArray): ByteArray {
        val dec = ByteArray(encryptedData.size)
        for (i in encryptedData.indices) {
            dec[i] = (if (i % 2 == 0) encryptedData[i] - specialKey else encryptedData[i] + specialKey).toByte()
        }
        return dec
    }
}

fun main() {
    val byteArrayCryptoProtocol = ByteArrayCryptoProtocol()
    val actualData = "Simple data to encrypt - (Insert any data here to encrypt)"
    val encryptedData = String(byteArrayCryptoProtocol.encrypt(actualData.toByteArray()))
    val decryptedData = String(byteArrayCryptoProtocol.decrypt(encryptedData.toByteArray()))

    println("Original: $actualData")
    println("Encrypted: $encryptedData")
    println("Decrypted: $decryptedData")
    byteArrayCryptoProtocol.newLine

    /**
     * UNCOMMENT THIS SECTION IF YOU WANT TO READ A TEXT FILE, THEN ENCRYPT THE TEXT FILE,
     * SAVE THE ENCRYPTED TEXT FILE, DECRYPT SAID TEXT FILE, THEN SAVE THE DECRYPTED TEXT FILE TO THIS DIRECTORY.
     * I ALREADY CREATED A TEXT FILE IN THIS DIRECTORY CALLED "data1.txt"
     * */
//    // Referencing the file data1.txt in the src directory
//    val data1: ByteArray = Files.readAllBytes(
//        Paths.get(System.getProperty("user.dir") + "/src/data1.txt")
//    )
//    // encrypting this file
//    val data2 = byteArrayCryptoProtocol.encrypt(data1)
//    // decrypting the encrypted file
//    val data3 = byteArrayCryptoProtocol.decrypt(data2)
//    // creating files for the encrypted & decrypted files
//    Files.write(Paths.get(System.getProperty("user.dir") + "/src/data2.txt"), data2)
//    Files.write(Paths.get(System.getProperty("user.dir") + "/src/data3.txt"), data3)
}
