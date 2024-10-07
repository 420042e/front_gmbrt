package com.example.gambarte3.util

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import android.util.Base64

object EncryptionUtils {

    // Cambia estas claves por valores seguros en producción
    private const val SECRET_KEY = "1234567890123456" // Debe ser de 16 bytes para AES-128
    private const val IV = "1234567890123456" // Debe ser de 16 bytes para AES

    // Método para encriptar un texto
    fun encrypt(plainText: String): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val secretKeySpec = SecretKeySpec(SECRET_KEY.toByteArray(Charsets.UTF_8), "AES")
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, IvParameterSpec(IV.toByteArray(Charsets.UTF_8)))
        val encryptedBytes = cipher.doFinal(plainText.toByteArray(Charsets.UTF_8))
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT) // Cambia a android.util.Base64
    }

    // Método para desencriptar un texto
    fun decrypt(encryptedText: String): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val secretKeySpec = SecretKeySpec(SECRET_KEY.toByteArray(Charsets.UTF_8), "AES")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, IvParameterSpec(IV.toByteArray(Charsets.UTF_8)))
        val decryptedBytes = cipher.doFinal(Base64.decode(encryptedText, Base64.DEFAULT)) // Cambia a android.util.Base64
        return String(decryptedBytes, Charsets.UTF_8)
    }
}