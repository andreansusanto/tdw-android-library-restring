package tdw.library.restring.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tdw.library.restring.R

import tdw.library.restring.Restring
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class TestActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(Restring.wrapContext(newBase)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat)
        setContentView(R.layout.test_layout)
    }
}
