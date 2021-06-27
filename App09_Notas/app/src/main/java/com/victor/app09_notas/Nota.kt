package com.victor.app09_notas

import android.graphics.drawable.Drawable

data class Nota(
    var foto: Drawable?=null,
    var titulo: String,
    var descricao: String,
)