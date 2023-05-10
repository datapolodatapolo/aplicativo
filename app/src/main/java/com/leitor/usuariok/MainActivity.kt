package com.leitor.usuariok

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.leitor.usuariok.databinding.ActivityMainBinding

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.http.promisesBody
import retrofit2.http.GET as GET1
import java.lang.reflect.Type as Type1


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     //   val view = binding.root





        binding.button.setOnClickListener {
    //        val navegarSegundaTela = Intent(this,  Main_Leitor::class.java)
    //        startActivity(navegarSegundaTela)

            val usuario1 = usuario()
            //  val dados = LEITOR()

   //         usuario1.lEITOR_LEITURA = binding.wleitura.text.toString()
            usuario1.ordem = "45178"
            usuario1.cilindro = binding.wleitura.text.toString()
            usuario1.produto = binding.wproduto.text.toString()
            usuario1.recarga = binding.wrecarga.text.toString()
            usuario1.teste = binding.whidro.text.toString()
            usuario1.local = binding.wlocal.text.toString()
            usuario1.area = binding.warea.text.toString()
            usuario1.cliente_id = "1388"
            println("Inspeção Realizada aqui" + usuario1.local)
            Toast.makeText(getApplicationContext(), "favor informar dados", Toast.LENGTH_LONG)
            //        .show()

            GET1 "http://192.168.15.67:8081/produtos/"
            val Content = null
            Content-Type1: application/json

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

            //     if (usuario1.cilindro != null && usuario1.cilindro.length == 8) {
       //         try {
       //             val url = "https://192.168.3.212:3000"
       //     HttpURLConnection connection = HttpURLConnection
       //     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       //     connection.setRequestMethod("GET");
       //     connection.setRequestProperty("Content-type", "application/json");
       //     connection.setRequestProperty("Accept", "application/json");
       //     connection.setDoOutput(true);
       //     connection.setConnectTimeout(5000);
        //    connection.connect();

         //fun post (json: String) {

       //       val url = "https://192.168.0.104:8081/produtos"
                //+ this.binding.wleitura + "/json/"

     //           val cabec = "applicantion/json; charset=utf-8".toMediaTypeOrNull()

      //          val scaner = OkHttpClient()
                //val gleitura = json.toRequestBody(cabec)

            //    val body = RequestBody.create(cabec, json)
            //    var requis = Request.Builder().url(url).post(body).build()
           //     val wmessage = scaner.newCall(requis).execute()

              //  return wmessage.body.toString()

                // criar requisicao  GET
              //val request = Request.Builder().url(url).get().build()
                //    retrofit
                //    addConverterFactory(GsonConverterFactory.create())
                //  .baseUrl(url)
                // val request = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                //   .baseUrl(url)
                //     .build()

                // enviar requisicao para servidor

                //val response = scaner.newCall(request).execute()
                // extrair body da requsicao

                //val leitura = response.


        //    val servjund = Gson()

          //  val inspecaoJson = servjund.toJson(usuario1)

         //   val resultado: String = inspecaoJson.toString()

       //     println("Inspeção Realizada" + inspecaoJson)

        //    Log.d("Resultado:", resultado)
        //    val c = inspecaoJson
        //    Toast.makeText(getApplicationContext(), "favor informar dados", Toast.LENGTH_LONG)
        //        .show()



                    }
                }





                //  fazer retorno json para objeto tela

//            var gson1 = usuario()

                //          gson1 = servjund.fromJson(inspecaoJson, usuario::class.java)

                //       println("retorno inspeçao" + gson1)


                // usuario1.nome = binding!!.editTextTextPersonName.text.toString()
                // usuario1.senha = binding!!.editTextNumberPassword.text.toString()


    private fun exibeToast(respostaservidor: Boolean) {
        if (respostaservidor) {
            Toast.makeText(this, "Usuário autenticado", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Usuário ou senha incorreta", Toast.LENGTH_LONG).show()
        }
    }



}

