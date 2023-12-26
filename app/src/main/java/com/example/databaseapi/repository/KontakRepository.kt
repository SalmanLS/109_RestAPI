package com.example.databaseapi.repository

import com.example.databaseapi.model.Kontak
import com.example.databaseapi.service_api.KontakService
import java.io.IOException

interface KontakRepository {
    /** Fetches list of Kontak from kontakAPI */
    suspend fun getKontak(): List<Kontak>

    suspend fun inserKontak(kontak: Kontak)

    suspend fun updateKontak(id: Int, kontak: Kontak)

    suspend fun deleteKontak(id: Int)

    suspend fun getKontakById(id: Int): Kontak


}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /**Fetches list of Kontak from kontakAPI*/
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    override suspend fun inserKontak(kontak: Kontak) = kontakApiService.insertKontak(kontak)

    override suspend fun updateKontak(id: Int, kontak: Kontak) = kontakApiService.updateKontak(id, kontak)

    override suspend fun deleteKontak(id: Int) {
        try {
            val response = kontakApiService.deleteKontak(id)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete kontak. HTTP Status Code: " + " ${response.code()}")

            }
            else{
                response.message()
                println(response.message())
            }
        }
        catch (e:Exception){
            throw e
        }
    }

    override suspend fun getKontakById(id: Int): Kontak {
        return kontakApiService.getKontakById(id)
    }

}