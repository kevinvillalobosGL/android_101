package com.gl.app.pet.data.api

import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

/**
 * @author Kevin Villalobos
 */
object LocalJsonHelper {

    /**
     * Gson
     */
    val gson = Gson()

    /**
     * Get Response <T> from Resource
     *
     * @param filename String File name
     * @return instance of <T>
     */
    inline fun <reified T> getFromFile(filename: String): T {
        val input = openFile(filename)
        return gson.fromJson(input, T::class.java)
    }

    /**
     * Opens a File from the Project Resources
     *
     * @param filename String
     * @return String InputStream as String
     */
    @Throws(IOException::class)
    fun openFile(filename: String): String? {
        val inputStream =
            LocalJsonHelper::class.java.classLoader?.getResourceAsStream(filename)
        return inputStreamToString(inputStream)
    }

    /**
     * Input Stream To String
     */
    private fun inputStreamToString(inputStream: InputStream?): String? {
        return try {
            val bytes = ByteArray(inputStream?.available() ?: 0)
            inputStream?.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            null
        }
    }
}
