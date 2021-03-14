import interfaces.CryptographicInterface

class ByteArrayCryptoProtocol : CryptographicInterface.AdvancedSymmetricEncryption<ByteArray> {

    override val specialKey: Int get() = 1

    override var lastEncryptedData: ByteArray = byteArrayOf()

    override fun encrypt(mData: ByteArray): ByteArray {
        val enc = ByteArray(mData.size)
        for (i in mData.indices) {
            enc[i] = (if (i % 2 == 0) mData[i] + specialKey else mData[i] - specialKey).toByte()
            lastEncryptedData = enc
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

    override fun decryptLastEncryptedData(): ByteArray {
        val dec = ByteArray(lastEncryptedData.size)
        for (i in lastEncryptedData.indices) {
            dec[i] = (if (i % 2 == 0) lastEncryptedData[i] - specialKey else lastEncryptedData[i] + specialKey).toByte()
        }
        return dec
    }
}

fun main() {
    val byteArrayCryptoProtocol = ByteArrayCryptoProtocol()
    val actualData = "Simple data to encrypt - (Insert any data here to encrypt)"
    val encryptedData = String(byteArrayCryptoProtocol.encrypt(actualData.toByteArray()))
    val decryptedData = String(byteArrayCryptoProtocol.decryptLastEncryptedData())

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
//        Paths.get(System.getProperty("user.dir") + "/src/files/data1.txt")
//    )
//    // encrypting this file
//    val data2 = byteArrayCryptoProtocol.encrypt(data1)
//    // decrypting the encrypted file
//    val data3 = byteArrayCryptoProtocol.decryptLastEncryptedData()
//    // creating files for the encrypted & decrypted files
//    Files.write(Paths.get(System.getProperty("user.dir") + "/src/files/data2.txt"), data2)
//    Files.write(Paths.get(System.getProperty("user.dir") + "/src/files/data3.txt"), data3)
}