package com.example.myapplication

class functionsexample {

    fun main() {
        // val vs var
        val noChangeVar = "can not change"
        var changeVar = "can change"
        // noChangeVar = "can not make change" // can not compile
        changeVar = "change"
        println(changeVar)

        //null safety
        var nullSafety: String? = null
        var nullCheck = nullSafety?: "hello"

        println(nullCheck!!)
        if (nullSafety != null) {
            println(nullSafety?.get(0))
        }
        else
            println("nullSafety is null")

        //dataclass + scope functions
        Citizen("Smith Apples", "X876P").let {
            it.ssn = 987654321

            println(it)

            with(it){
                println("calls citizen ssn: ${this.ssn}")
            }
        }

        val citizen1 = Citizen("Bread Baker", "B192O").apply {
            ssn=1234567890
        }
        citizen1
            .also {println(citizen1)  }
            .run {
            println(this.ssn)
        }
        // sealed class
        val obj = Demo.A()
        obj.display()

        // inline fun
        higherfun("A Computer Science portal for Geeks",::print)

        //constructors
        var names = Person("Katty", "Cat")
        names = Person("Dog")

        //obj singleton
        //to create an object we must call the class
        val objAnimal = Animal()
        println(objAnimal.name)

        //to create a singleton notice we do not use the () after calling the class
        //we are not creating a new instance each time
        val singletonCat = Cat
        println(singletonCat.name)

        //access to the companion object can be using only the class name
        val mammalsObj = Animal.create()
        println("Mammals have: ${mammalsObj.gotMilk}")

        //extension fun
        val circle = Circle(4.5)

        println("Radius   : ${circle.radius}")
        println("Area     : ${circle.area()}")
        println("Perimeter: ${circle.perimeter()}")
    }
    // dataclass
    data class Citizen(
        var name: String,
        var id: String,
    )
    {
        var ssn: Int = 0
    }

    sealed class Demo {
        class A:Demo(){
            fun display(){
                println("Subclass A of sealed class")
            }
        }
    }

    inline fun higherfun( str : String, mycall :(String)-> Unit){
        // inovkes the print() by passing the string str
        mycall(str)
    }

    class Person {

        constructor(name: String) {
            println("This is primary constructor: $name")
        }

        constructor(firstName: String, lastName:String)
        {
            var fullName = "$firstName $lastName"
            println("this name is $fullName")
        }
    }

    class Animal{
        companion object Mammals {
            fun create(): Animal = Animal()
            val milk = "milk"
        }
        val name = "animal"
        val gotMilk = milk
    }

    object Cat {
        val name = "cat"
    }

    /*
* Extension Function -> Let’s you extend a class functionality without having to inherit it
*/

    class Circle(
        val radius: Double
    ) {

        fun area(): Double {
            return Math.PI * radius * radius
        }

    }

// Extension Function

    fun Circle.perimeter(): Double {
        return 2 * Math.PI * radius
    }

    fun Circle.perimeter1() = 2 * Math.PI * radius

}