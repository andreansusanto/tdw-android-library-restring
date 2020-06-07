package tdw.library.restring.example

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity

import tdw.library.restring.Restring
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(Restring.wrapContext(newBase)))
    }

    override fun getResources(): Resources {
        return Restring.wrapContext(baseContext).resources
    }
}
