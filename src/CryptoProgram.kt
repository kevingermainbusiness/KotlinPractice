import java.nio.file.Files
import java.nio.file.Paths

interface CryptoInterface {

    fun encrypt(mData: ByteArray): ByteArray

    fun decrypt(encryptedData: ByteArray): ByteArray
}

class SymmetricCryptoBase : CryptoInterface {

    override fun encrypt(mData: ByteArray): ByteArray {
        val enc = ByteArray(mData.size)
        for (i in mData.indices) {
            enc[i] = (if (i % 2 == 0) mData[i] + 1 else mData[i] - 1).toByte()
        }
        return enc
    }

    override fun decrypt(encryptedData: ByteArray): ByteArray {
        val dec = ByteArray(encryptedData.size)
        for (i in encryptedData.indices) {
            dec[i] = (if (i % 2 == 0) encryptedData[i] - 1 else encryptedData[i] + 1).toByte()
        }
        return dec
    }

    val addLineBreak: Unit get() = println("\n")
}

fun main() {
    val symmetricCryptoBase = SymmetricCryptoBase()
    val actualData = "Hello, World"
    val encryptedData = String(symmetricCryptoBase.encrypt(actualData.toByteArray()))
    val decryptedData = String(symmetricCryptoBase.decrypt(encryptedData.toByteArray()))

    println("Original: $actualData")
    println("Encrypted: $encryptedData")
    println("Decrypted: $decryptedData")
    symmetricCryptoBase.addLineBreak

    // Referencing the file data1.txt in the src directory
    val data1: ByteArray = Files.readAllBytes(
        Paths.get(System.getProperty("user.dir") + "/src/data1.txt")
    )
    // encrypting this file
    val data2 = symmetricCryptoBase.encrypt(data1)
    // decrypting the encrypted file
    val data3 = symmetricCryptoBase.decrypt(data2)
    // creating files for the encrypted & decrypted files
    Files.write(Paths.get(System.getProperty("user.dir") + "/src/data2.txt"), data2)
    Files.write(Paths.get(System.getProperty("user.dir") + "/src/data3.txt"), data3)

    // SimpleTextCryptoMethod ENCRYPTION & DECRYPTION
    SimpleTextCryptoMethod.addLineBreak
    SimpleTextCryptoMethod.encrypt("Beniswa Letènèl, BonDye Gran e Puissant vre wi")
    SimpleTextCryptoMethod.decrypt()
}