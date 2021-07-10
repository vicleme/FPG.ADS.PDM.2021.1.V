package com.victor.app20_consultagithubretrofitsp.data.model

import com.google.gson.annotations.SerializedName

class Github(@SerializedName("name") val name: String,
             @SerializedName("location")val location: String,
             @SerializedName("public_repos")val public_repos: Int,
             @SerializedName("followers")val followers: Int) {

    override fun toString() : String {
        return "Nome: $name\nLocalização: $location\nRepositórios públicos: $public_repos\nSeguidores: $followers"
    }

}