package tdw.library.restring.example

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.ContentFrameLayout
import dev.b3nedikt.app_locale.AppLocale
import dev.b3nedikt.reword.Reword
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val localeStrings = AppLocale.supportedLocales.map { it.language + " " + it.country }
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, localeStrings)

        spinner.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                AppLocale.desiredLocale = AppLocale.supportedLocales[position]

                val rootView = window.decorView.findViewById<ContentFrameLayout>(android.R.id.content)
                Reword.reword(rootView)

                stringArrayTextView.text = resources.getStringArray(R.array.string_array)
                        .joinToString("\n")

                quantityStringTextView.text = (0 until 3)
                        .joinToString("\n")
                        { resources.getQuantityString(R.plurals.quantity_string, it, it) }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }
    }
}
