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
