package tdw.library.restring

import android.os.Build
import java.util.*

internal object LocaleUtil {

    fun toLanguageTag(locale: Locale): String {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return locale.toLanguageTag()
        }

        val language = locale.language
        val country = locale.country

        if (language.isNotEmpty() && country.isNotEmpty()) {
            return "$language-$country"
        }
        return language
    }

    fun fromLanguageTag(locale: String): Locale {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return Locale.forLanguageTag(locale)
        }

        if (locale.contains("-")) {
            val language = locale.split("-")[0]
            val country = locale.split("-")[1]

            return Locale(language, country)
        }

        return Locale(locale)
    }
}