package tdw.library.restring.repository

import tdw.library.restring.PluralKeyword

internal fun generateStrings(count: Int): Map<String, String> {
    val strings = mutableMapOf<String, String>()
    for (i in 0 until count) {
        strings["key$i"] = "value$i"
    }
    return strings
}

internal fun generateStringArrays(count: Int): Map<String, Array<CharSequence>> {
    val stringArrays = mutableMapOf<String, Array<CharSequence>>()

    for (i in 0 until count) {
        stringArrays["key$i"] = "value$i ".repeat(10).trimEnd().split( " ")
                .map { it }
                .toTypedArray()
    }
    return stringArrays
}

internal fun generateQuantityStrings(count: Int): Map<String, Map<PluralKeyword, CharSequence>> {
    val quantityStrings = mutableMapOf<String, Map<PluralKeyword, CharSequence>>()

    for (i in 0 until count){
        val quantities = mutableMapOf<PluralKeyword, CharSequence>()
        PluralKeyword.values().forEach { quantities[it] =  "value${it.name} "}

        quantityStrings["key$i"] = quantities
    }
    return quantityStrings
}