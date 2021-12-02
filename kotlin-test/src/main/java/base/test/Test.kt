package base.test

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/17 11:06
 * @Description:
 **/
class InitOrderDemo(name: String) {
    var name: String = name
        get() = field + "11"
        set(value) {
            if (value > "") {
                field = value
            }
        }
    lateinit var age: Int
    constructor(name: String, age: Int) : this(name) {

    }

}

fun main() {
    InitOrderDemo("hello")
}