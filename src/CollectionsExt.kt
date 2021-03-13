/**
 * I feel a sense of pride for having created this function even though it's after looking into the implementation
 * The fact that I tried doing it my way, gives me a sense of achievement
 * @author Kevin Germain
 * */
fun Collection<String>.joinToString(prefix: String = "[", separator: String = ",", postfix: String = "]"): String {
    val count = this.size
    var items = "$prefix "
    this.forEachIndexed { index, el ->
        items += if (index == count - 1) el else el + separator
    }
    return items + postfix
}

val Collection<String>.stringifyOptions: String get() = this.joinToString()

/** Thought of the it % 2 but had to search on another project for the == 0 rest of the algorithm */
val Collection<Int>.containsEven: Boolean get() = this.any { it % 2 == 0 }