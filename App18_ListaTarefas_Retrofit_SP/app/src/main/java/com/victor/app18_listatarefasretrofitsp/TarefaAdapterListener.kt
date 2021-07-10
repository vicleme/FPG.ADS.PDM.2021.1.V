package com.victor.app18_listatarefasretrofitsp

import com.victor.app18_listatarefasretrofitsp.data.model.Tarefa

interface TarefaAdapterListener {
    fun excluirTarefa(tarefa: Tarefa)
}
