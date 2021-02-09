interface Mailer {
    fun sendMessage(email: String, message: String)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)

/**
 * Created for the sole purpose of outputting the email and message of the Mailer
 * @author Kevin Germain
 * */
class SimpleMailer : Mailer {
    override fun sendMessage(email: String, message: String) {
        println("$email : $message")
    }
}


fun sendMessageToClient(client: Client?, message: String?, mailer: SimpleMailer) {
    val personalInfo = client?.personalInfo
    val email = personalInfo?.email
    if (client != null && message != null && personalInfo != null && email != null) {
        mailer.sendMessage(email, message)
    }
}