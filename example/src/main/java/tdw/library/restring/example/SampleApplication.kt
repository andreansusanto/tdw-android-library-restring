package tdw.library.restring.example

import android.app.Application
import dev.b3nedikt.app_locale.AppLocale
import tdw.library.restring.Restring
import tdw.library.restring.RestringConfig
import tdw.library.restring.example.Locales.LOCALE_AUSTRIAN_GERMAN
import dev.b3nedikt.reword.RewordInterceptor
import io.github.inflationx.viewpump.ViewPump
import java.util.*


class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppLocale.supportedLocales = listOf(Locale.ENGLISH, Locale.US, LOCALE_AUSTRIAN_GERMAN)

        Restring.init(this,
                RestringConfig.Builder()
                        .stringsLoader(SampleStringsLoader)
                        .localeProvider(AppLocaleLocaleProvider)
                        .build()
        )

        ViewPump.init(ViewPump.builder()
                .addInterceptor(RewordInterceptor)
                .build()
        )
    }
}