package tdw.library.restring.example

import dev.b3nedikt.app_locale.AppLocale
import tdw.library.restring.PluralKeyword
import tdw.library.restring.Restring
import tdw.library.restring.example.Locales.LOCALE_AUSTRIAN_GERMAN
import java.util.*

/**
 * A example of a [Restring.StringsLoader].
 * In real applications, you might call an API to get your strings.
 */
object SampleStringsLoader : Restring.StringsLoader {

    override val locales = AppLocale.supportedLocales

    override fun getStrings(locale: Locale): Map<String, CharSequence> {
        val map = mutableMapOf<String, CharSequence>()
        when (locale) {
            Locale.ENGLISH -> {
                map["title"] = "Title (from restring)."
                map["subtitle"] = "Subtitle (from restring)."
            }
            Locale.US -> {
                map["title"] = "Title US (from restring)."
                map["subtitle"] = "Subtitle US (from restring)."
            }
            LOCALE_AUSTRIAN_GERMAN -> {
                map["title"] = "Titel (aus restring)."
                map["subtitle"] = "Untertitel (aus restring)."
            }
        }
        return map
    }

    override fun getStringArrays(locale: Locale): Map<String, Array<CharSequence>> {
        return mapOf(
                "string_array"
                        to
                        arrayOf<CharSequence>("String Array 1 $locale (from restring)",
                                "String Array 2 $locale (from restring)")
        )
    }

    override fun getQuantityStrings(locale: Locale): Map<String, Map<PluralKeyword, CharSequence>> {
        return mapOf(
                "quantity_string"
                        to
                        mapOf(PluralKeyword.ONE to "%d quantity string $locale (from restring)",
                                PluralKeyword.OTHER to "%d quantity strings $locale (from restring)")
        )
    }
}