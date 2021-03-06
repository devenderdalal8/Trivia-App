package com.infinitybiz.triviaapp.Model

// Make Data Model
class User {
    var id: Int = 0
    var name: String? = null
    var value: String? = null
    var list: String? = null
    var time: String? = null

    constructor(){

    }

    constructor(id: Int, name: String?, value: String?, list: String?, time: String?) {
        this.id = id
        this.name = name
        this.value = value
        this.list = list
        this.time = time
    }

    constructor(name: String?, value: String?, list: String?, time: String?) {
        this.name = name
        this.value = value
        this.list = list
        this.time = time
    }

}