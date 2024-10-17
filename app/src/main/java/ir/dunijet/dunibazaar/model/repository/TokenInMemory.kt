package ir.dunijet.dunibazaar.model.repository

object TokenInMemory {

    var username: String? = null
        private set

    var token: String? = null
        private set

    var password:String? =null

    fun refreshToken(username: String? , newToken: String?  ) {
        this.username = username
        this.token = newToken
    }

}