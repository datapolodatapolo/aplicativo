package com.leitor.usuariok

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.http.promisesBody


class httphelper {


    fun get() {

        val url = "http://192.168.15.67:8081/produtos/"
        //+ this.binding.wleitura + "/json/"

        val scaner = OkHttpClient()
        // cria requisicao GET
        val request = Request.Builder().url(url).get().build()
        // enviar a requisicao para o servidor
        val response = scaner.newCall(request).execute()
        // extrair o body da requisição
        val responseBody = response.promisesBody()
        // exibir o resposta
        if (responseBody != null) {
            val json = responseBody.toString()
            println("Inspeção Realizada" + json)
        }
    }
}
