import kotlin.math.sqrt

// 1. Сумма первой и последней цифры
fun task1() {
    print("Введите положительное целое число: ")
    val number = readln().toInt()
    val first = number.toString().first().digitToInt()
    val last = number % 10
    println("Сумма первой и последней цифры: ${first + last}")
}

// 2. Ввод чисел до 0
fun task2() {
    var count = 0
    var sum = 0.0

    println("Вводите числа. Для завершения введите 0:")
    while (true) {
        val number = readln().toDouble()
        if (number == 0.0) break
        count++
        sum += number
    }

    println("Количество введенных чисел: $count")
    println("Общая сумма: $sum")
    if (count > 0) {
        println("Среднее арифметическое: ${sum / count}")
    } else {
        println("Среднее арифметическое: 0.0")
    }
}

// 3. Угадай число
fun task3() {
    val a = (0..10).random()
    println("Я загадал число от 0 до 10. Попробуйте угадать.")

    while (true) {
        print("Ваш вариант: ")
        val b = readln().toInt()

        when {
            b > a -> println("Много")
            b < a -> println("Мало")
            else -> {
                println("Угадал")
                break
            }
        }
    }
}

// 4. Первые n простых чисел
fun isPrime(number: Int): Boolean {
    if (number < 2) return false
    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

fun task4() {
    print("Сколько простых чисел вывести? ")
    val n = readln().toInt()

    var count = 0
    var number = 2

    while (count < n) {
        if (isPrime(number)) {
            count++
            println("$count-е простое число: $number")
        }
        number++
    }
}

// 5. Элементы массива, которые больше обоих соседей
fun task5() {
    val array = intArrayOf(1, 5, 2, 8, 3, 7, 4)

    println("Массив: ${array.joinToString()}")

    print("for: ")
    for (i in 1 until array.lastIndex) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            print("${array[i]} ")
        }
    }
    println()

    print("while: ")
    var i = 1
    while (i < array.lastIndex) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            print("${array[i]} ")
        }
        i++
    }
    println()

    print("forEach: ")
    array.withIndex().forEach { (index, value) ->
        if (index > 0 && index < array.lastIndex &&
            value > array[index - 1] && value > array[index + 1]
        ) {
            print("$value ")
        }
    }
    println()
}

// 6. Произведение, min и max
fun task6() {
    val array = intArrayOf(2, 3, 4, 5)

    var productFor = 1
    var minFor = array[0]
    var maxFor = array[0]
    for (value in array) {
        productFor *= value
        if (value < minFor) minFor = value
        if (value > maxFor) maxFor = value
    }

    var productWhile = 1
    var minWhile = array[0]
    var maxWhile = array[0]
    var i = 0
    while (i < array.size) {
        productWhile *= array[i]
        if (array[i] < minWhile) minWhile = array[i]
        if (array[i] > maxWhile) maxWhile = array[i]
        i++
    }

    var productForEach = 1
    var minForEach = array[0]
    var maxForEach = array[0]
    array.forEach { value ->
        productForEach *= value
        if (value < minForEach) minForEach = value
        if (value > maxForEach) maxForEach = value
    }

    val productReduce = array.reduce { acc, value -> acc * value }
    val minFunction = array.min()
    val maxFunction = array.max()

    println("Массив: ${array.joinToString()}")
    println("for: product=$productFor, min=$minFor, max=$maxFor")
    println("while: product=$productWhile, min=$minWhile, max=$maxWhile")
    println("forEach: product=$productForEach, min=$minForEach, max=$maxForEach")
    println("reduce(): product=$productReduce")
    println("min()/max(): min=$minFunction, max=$maxFunction")
}

// 7. Квадратное уравнение
fun sqr(n: Double): Double = n * n

fun discriminant(a: Double, b: Double, c: Double): Double =
    sqr(b) - 4.0 * a * c

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    return when {
        discriminant(a, b, c) > 0 -> 2
        discriminant(a, b, c) == 0.0 -> 2
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    require(a != 0.0) { "Коэффициент a не должен быть равен 0." }

    val d = discriminant(a, b, c)

    when {
        d > 0 -> {
            val x1 = (-b + sqrt(d)) / (2.0 * a)
            val x2 = (-b - sqrt(d)) / (2.0 * a)
            println("Два различных корня:")
            println("x1 = $x1")
            println("x2 = $x2")
        }
        d == 0.0 -> {
            val x = -b / (2.0 * a)
            println("Два совпадающих (кратных) корня:")
            println("x1 = $x")
            println("x2 = $x")
        }
        else -> println("Действительных корней нет")
    }
}

fun task7() {
    print("Введите a, b, c через пробел: ")
    val (a, b, c) = readln().trim().split(Regex("\\s+")).map { it.toDouble() }

    println("sqr(b) = ${sqr(b)}")
    println("Дискриминант = ${discriminant(a, b, c)}")
    println("Количество корней = ${rootsNumber(a, b, c)}")
    quadraticRoot(a, b, c)
}

// 8. Класс с массивом
class NumberArray(private val array: IntArray) {
    fun sumPositive(): Int = array.filter { it > 0 }.sum()

    fun product(): Long {
        var result = 1L
        for (value in array) result *= value
        return result
    }

    fun average(): Double = array.average()
}

fun task8() {
    val obj = NumberArray(intArrayOf(-2, 3, 4, -1, 5))
    println("Сумма положительных: ${obj.sumPositive()}")
    println("Произведение: ${obj.product()}")
    println("Среднее арифметическое: ${obj.average()}")
}

// 9. Вектор в трехмерном пространстве
class Vector(val x: Double, val y: Double, val z: Double) {
    fun length(): Double = sqrt(sqr(x) + sqr(y) + sqr(z))

    fun scalarProduct(other: Vector): Double =
        x * other.x + y * other.y + z * other.z

    infix fun dot(other: Vector): Double = scalarProduct(other)

    operator fun times(other: Vector): Double = scalarProduct(other)

    override fun toString(): String = "Vector($x, $y, $z)"
}

fun scalarProduct(v1: Vector, v2: Vector): Double = v1.scalarProduct(v2)

fun task9() {
    val v1 = Vector(1.0, 2.0, 3.0)
    val v2 = Vector(3.0, 2.0, 1.0)

    println("v1 = $v1")
    println("Длина v1 = ${v1.length()}")
    println("v2 = $v2")
    println("Длина v2 = ${v2.length()}")
    println("Скалярное произведение методом = ${v1.scalarProduct(v2)}")
    println("Скалярное произведение infix = ${v1 dot v2}")
    println("Скалярное произведение через * = ${v1 * v2}")
    println("Скалярное произведение внешней функцией = ${scalarProduct(v1, v2)}")
}

// 10. Vehicle и наследники
open class Vehicle(
    open val speed: Int = 0,
    open val name: String = "Транспортное средство"
) {
    open fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }

    open fun stop() {
        println("$name остановился")
    }
}

class Boat(
    override val speed: Int = 30,
    override val name: String = "Лодка"
) : Vehicle(speed, name)

class Airplane(
    override val speed: Int = 800,
    override val name: String = "Самолет"
) : Vehicle(speed, name)

class Tank(
    override val speed: Int = 60,
    override val name: String = "Танк"
) : Vehicle(speed, name)

fun task10() {
    val vehicles: List<Vehicle> = listOf(Boat(), Airplane(), Tank())

    vehicles.forEach {
        it.start()
        it.stop()
    }
}

fun main() {
    println("Лабораторная работа №0: Основы Kotlin")
    println("Выберите задание 1-10:")
    val task = readln().toInt()

    when (task) {
        1 -> task1()
        2 -> task2()
        3 -> task3()
        4 -> task4()
        5 -> task5()
        6 -> task6()
        7 -> task7()
        8 -> task8()
        9 -> task9()
        10 -> task10()
        else -> println("Неверный номер задания.")
    }
}

