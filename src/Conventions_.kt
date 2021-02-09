data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

fun main() {
    val myDate = MyDate(2021, 2, 2)
    println(myDate.compareTo(MyDate(2020, 1, 10))) // always return 1 for some reason
}