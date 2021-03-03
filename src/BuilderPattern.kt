import java.util.*

class BuilderPattern(
    private val id: Long, summary: String, description: String, done: Boolean,
    dueDate: Date
) {
    private var summary = ""
    private var description = ""
    private var done = false
    private var dueDate: Date
    fun setSummary(summary: String): BuilderPattern {
        this.summary = summary
        return this
    }

    fun setDescription(description: String): BuilderPattern {
        this.description = description
        return this
    }

    fun setDone(done: Boolean): BuilderPattern {
        this.done = done
        return this
    }

    fun setDueDate(dueDate: Date): BuilderPattern {
        this.dueDate = Date(dueDate.time)
        return this
    }

    fun build(): BuilderPattern {
        return BuilderPattern(id, summary, description, done, dueDate)
    }

    init {
        this.summary = summary
        this.description = description
        this.done = done
        this.dueDate = dueDate
    }
}

fun main() {
    BuilderPattern(1L, "Summary", "Desc", false, Date())
        .setDescription("")
        .setDone(false)
        .setSummary("")
        .build()
}