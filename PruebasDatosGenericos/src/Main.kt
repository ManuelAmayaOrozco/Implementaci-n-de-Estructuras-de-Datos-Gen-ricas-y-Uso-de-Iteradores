import java.util.Collections.reverse
import kotlin.collections.iterator

fun main() {
    var numbers = listOf("one", "two", "three", "four")
    var numbersRev = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")
    println(numbersRev)

    //Realiza la misma prueba, pero con listas de otros tipos de datos...
    //por ejemplo una lista que combine valores numéricos Int, Float y Double

    var numbers2 = listOf(15, 23.4, 888, 9)
    var numbers2Rev = reverse(numbers2)
    if (!listOf(9, 888, 23.4, 15).equals(numbers2Rev))
        println("Error")
    else
        println("Correcto")
    println(numbers2Rev)


    //Otra con una lista de cualquier data class que te inventes.

    var personas = listOf(Persona("Manuel","Amaya", 19),
        Persona("Araceli","Garcia", 34),
        Persona("Javier","Del Rio", 23))
    var personasRev = reverse(personas)
    if (!listOf(Persona("Javier","Del Rio", 23),Persona("Araceli","Garcia", 34),Persona("Manuel","Amaya", 19)).equals(personasRev))
        println("Error")
    else
        println("Correcto")
    println(personasRev)

    //Comprueba también si podemos hacerlo con una lista de tipos de datos distintos...
    //por ejemplo con una lista que contenga tipos de datos String, Int, Float, Usuario("Pepe", 30), Boolean...

    var varios = listOf(15, "almejas", 88.8,Persona("Manuel","Amaya", 19))
    var variosRev = reverse(varios)
    if (!listOf(Persona("Manuel","Amaya", 19), 88.8, "almejas", 15).equals(variosRev))
        println("Error")
    else
        println("Correcto")
    println(variosRev)

    //¿Por qué es posible usarla si parece que la lista contiene tipos de datos diferentes?

    /**
     * Ya que al usar los iteradores, la funcion toma todos los tipos de valores por igual, fijándose en su posición
     * dentro de la lista más que en su tipo de dato, por lo que es capaz de cambiarlos de sitio a pesar de ser datos
     * distintos.
     */
}

data class Persona(val nombre: String, val apellido: String, val edad: Int)

fun reverse(lista: Pila<Any>): List<Any> {
    val iterator = lista.iterator()
    while (iterator.hasNext()) {
        lista.push(iterator.next())
    }
    val reverseLista = mutableListOf<Any>()
    for (valor in lista) {
        lista.pop()?.let { reverseLista.add(it) }
    }
    return reverseLista.toList()
}

abstract class Pila<T> (var value: List<T>) {

    abstract operator fun iterator(): Iterator<T>
    abstract operator fun hasNext(): Boolean
    abstract operator fun next(): T

    fun top(): T {
        return value.last()
    }

    fun push(valor: T) {
        value = value + valor
    }

    fun pop(): T? {
        if (value.isNotEmpty()) {
            val valor = value.first()
            value = value.drop(1)
            return valor
        }
        else {
            return null
        }
    }

    fun isEmpty(): Boolean {
        return value.isEmpty()
    }

}