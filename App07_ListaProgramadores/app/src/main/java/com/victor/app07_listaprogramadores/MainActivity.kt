package com.victor.app07_listaprogramadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome="Victor", email="vic@pdm.com", stack= Stack.BACKEND, senioridade= Senioridade.SENIOR, foto=resources.getDrawable(R.drawable.tails)),
            Usuario(nome="Gabriel", email="gabs@pdm.com", stack= Stack.FULLSTACK, senioridade= Senioridade.JUNIOR, foto=resources.getDrawable(R.drawable.mario)),
            Usuario(nome="Ana", email="ana@pdm.com", stack= Stack.FRONTEND, senioridade= Senioridade.PLENO, foto=resources.getDrawable(R.drawable.gatinho))
        )

        rv.adapter = UsuarioAdapter(lista)

        // Exibe os itens em uma coluna única no padrão vertical
        rv.layoutManager = LinearLayoutManager(this)

        // Exibe os itens em uma coluna única no padrão horizontal
        // rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Exibe os itens em uma tabela com x colunas
        // rv.layoutManager = GridLayoutManager(this, 2)

        // Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
        // rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}