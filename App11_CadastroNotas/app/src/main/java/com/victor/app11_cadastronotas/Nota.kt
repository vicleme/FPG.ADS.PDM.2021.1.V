package com.victor.app11_cadastronotas

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class Nota(
    var foto: Bitmap?=null,
    var nome: String,
    var email: String,
    var categoria: Categoria,
    var estagio: Estagio,
    var urgente: Boolean
)
