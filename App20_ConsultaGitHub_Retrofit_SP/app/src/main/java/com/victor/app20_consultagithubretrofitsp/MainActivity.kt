package com.victor.app20_consultagithubretrofitsp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.victor.app20_consultagithubretrofitsp.domain.GithubService
import com.victor.app20_consultagithubretrofitsp.util.Network
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private lateinit var campoGithub: EditText
    private lateinit var botaoGithub: Button
    private lateinit var respostaGithub: TextView
    private lateinit var carregamentoGithub : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoGithub = findViewById(R.id.edtGithub)
        botaoGithub = findViewById(R.id.btnBuscarGithub)
        respostaGithub = findViewById(R.id.txtGithubResponse)
        carregamentoGithub = findViewById(R.id.prgLoading)

        botaoGithub.setOnClickListener {
            val github = campoGithub.text.toString()
            if(github.isNotEmpty()){
                buscarGithub(github)
            } else {
                campoGithub.error = "Digite um usuário válido"
            }
        }
    }

    fun buscarGithub(github: String){
        val retrofitClient = Network.retrofitConfig("https://api.github.com/users/")
        val servico = retrofitClient.create(GithubService::class.java)

        CoroutineScope(IO).launch {
            try {
                val response = servico.buscarGithub(github)

                withContext(Main){
                    changeLoadingVisibility(isVisibile = true)
                    delay(2000L)
                    if(response.isSuccessful){
                        changeLoadingVisibility(isVisibile = false)
                        respostaGithub.text = response.body().toString()
                    }
                }

            } catch (e: Exception){
                withContext(Main){
                    changeLoadingVisibility(isVisibile = false)
                    respostaGithub.text = "Não foi possível processar a sua solicitação."
                }
            }
        }
    }

    fun changeLoadingVisibility(isVisibile: Boolean){
        if(isVisibile){
            respostaGithub.text = ""
            carregamentoGithub.visibility = View.VISIBLE
            botaoGithub.visibility = View.INVISIBLE
        } else {
            carregamentoGithub.visibility = View.INVISIBLE
            botaoGithub.visibility = View.VISIBLE
        }
    }
}