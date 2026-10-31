package com.example.petagram

import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

object MailSender {

    // Debe llamarse desde un hilo secundario (no desde el hilo principal)
    fun enviar(nombre: String, correo: String, mensaje: String) {
        val props = Properties().apply {
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
            put("mail.smtp.host", "smtp.gmail.com")
            put("mail.smtp.port", "587")
        }

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(BuildConfig.MAIL_USER, BuildConfig.MAIL_PASS)
            }
        })

        val email = MimeMessage(session)
        email.setFrom(InternetAddress(BuildConfig.MAIL_USER))
        email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(BuildConfig.MAIL_USER))
        email.setReplyTo(arrayOf(InternetAddress(correo)))
        email.setSubject("Comentario desde Petagram de $nombre")
        email.setText("Nombre: $nombre\nCorreo: $correo\n\nMensaje:\n$mensaje")

        Transport.send(email)
    }
}