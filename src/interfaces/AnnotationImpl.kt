package interfaces

import java.lang.reflect.Field
import java.util.*
import java.util.stream.Collectors
import java.util.HashMap
import java.util.Objects.requireNonNull

// Created by Kevin Germain to learn how Annotations work

/**
 * Is thrown if an object does not implement the [JsonSerializable] annotation
 * */
class JsonSerializeException(message: String?) : Exception(message) {
    companion object {
        private const val serialVersionUID = -8845242379503538623L
    }
}

/**
 * As we can see, our first annotation has runtime visibility,
 * and we can apply it to types (classes). Moreover, it has no methods,
 * and thus serves as a simple marker to mark classes that can be serialized into JSON.
 * */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class JsonSerializable

/**
 * In the same fashion, we create our second annotation,
 * to mark the fields that we are going to include in the generated JSON:
 * */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class JsonField(val declaredFieldName: String = "")

/**
 * Let's imagine that, before serializing an object to a JSON string, we want
 * to execute some method to initialize an object. For that reason,
 * we're going to create an annotation to mark this method:
 * */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class InitSerialization

@JsonSerializable
data class SimplePerson(
    @JsonField
    var firstName: String,
    @JsonField
    var lastName: String,
    @JsonField(declaredFieldName = "personAge")
    val age: String,
    @JsonField
    val address: String,
) {
    @InitSerialization
    private fun initNames() {
        firstName = (firstName.substring(0, 1).toUpperCase() + firstName.substring(1))
        lastName = (lastName.substring(0, 1).toUpperCase() + lastName.substring(1))

        println("initNames() invoked: $firstName and $lastName \n")
    }
}

/**
 * Verifies if a non-null object implements  the [JsonSerializable] annotation
 * @throws [JsonSerializeException] in case it does not implement the annotation
 * */
private fun checkIfSerializable(mObject: Any) {
    requireNonNull(mObject)
    val clazz: Class<*> = mObject.javaClass
    if (!clazz.isAnnotationPresent(JsonSerializable::class.java)) {
        throw JsonSerializeException("The class  ${clazz.simpleName} is not annotated with JsonSerializable")
    }
}

/**
 * Iterates through a [JsonSerializable] object to find the object's functions that
 * implements the [InitSerialization] annotation, then method.isAccessible = true,
 * causes the execution of these functions through the [invoke] call.
 * */
private fun initSerializableObject(mObject: Any) {
    val clazz: Class<*> = mObject.javaClass
    for (method in clazz.declaredMethods) {
        if (method.isAnnotationPresent(InitSerialization::class.java)) {
            method.isAccessible = true
            method.invoke(mObject)
        }
    }
}

/**
 * Checks if the object implements [JsonSerializable] through [checkIfSerializable]
 * Initializes methods in the object marked with the
 * [InitSerialization] annotation via [initSerializableObject]
 * Iterates through the object's declaredFields, then
 * make them accessible using [Field.isAccessible] = true
 * Checks the fields marked with the [JsonField] annotation,
 * then add them to the jsonFieldsMap [MutableMap]
 * Then finally, it converts the  jsonFieldsMap [MutableMap] to a  Json-like String
 * by returning [mapToJsonString]
 * @return [mapToJsonString]
 * */
private fun serialize(mObject: Any): String {
    checkIfSerializable(mObject)
    initSerializableObject(mObject)
    val jsonFieldsMap: MutableMap<String, String> = HashMap()
    val clazz: Class<*> = mObject.javaClass
    val fields = clazz.declaredFields
    for (field in fields) {
        field.isAccessible = true
        if (field.isAnnotationPresent(JsonField::class.java)) {
            jsonFieldsMap[field.getSerializedKey()!!] = field[mObject] as String
        }
    }
    return mapToJsonString(jsonFieldsMap)
}

/**
 * Converts a [MutableMap] of any type to a [String]
 * */
private fun mapToJsonString(mutableMap: Map<*, *>): String {
    val elementsString = mutableMap.entries
        .stream()
        .map { entry: Map.Entry<*, *> -> (" '${entry.key}': '${entry.value}' ") }
        .collect(Collectors.joining(","))
    return "{$elementsString}"
}

/**
 * Takes a [Field] that implements a [JsonField] annotation and returns its defined
 * [JsonField.declaredFieldName], but if the field does not implement the [JsonField] annotation
 * it returns the field name
 * */
private fun Field.getSerializedKey(): String? {
    val declaredFieldName = this.getAnnotation(JsonField::class.java).declaredFieldName
    return if (declaredFieldName.isEmpty()) this.name else declaredFieldName
}

fun main() {
    val person = SimplePerson("Kevin", "Germain", "09", "UNDEFINED")
    print(serialize(person))
}

