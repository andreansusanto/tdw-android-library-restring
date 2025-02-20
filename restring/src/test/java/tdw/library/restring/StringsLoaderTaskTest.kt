package tdw.library.restring

import android.os.Build
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.*
import kotlin.collections.HashMap

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class StringsLoaderTaskTest {

    @Before
    fun setUp() {
    }

    @Test
    fun shouldLoadStringsAndSaveInRepository() {
        val locales = listOf(Locale.ENGLISH, Locale.GERMAN)
        val enStrings = HashMap<String, String>()
        enStrings["string1"] = "value1"
        enStrings["string2"] = "value2"
        val deStrings = HashMap<String, String>()
        deStrings["string3"] = "value3"
        deStrings["string4"] = "value4"

        val loader = mock<Restring.StringsLoader>()
        whenever(loader.locales).thenReturn(locales)
        whenever(loader.getStrings(Locale.ENGLISH)).thenReturn(enStrings)
        whenever(loader.getStrings(Locale.GERMAN)).thenReturn(deStrings)

        val repository = mock<StringRepository>()

        val task = StringsLoaderTask(loader, repository)
        task.execute()

        Robolectric.flushBackgroundThreadScheduler()
        Robolectric.flushForegroundThreadScheduler()

        val enCaptor = argumentCaptor<Map<String,String>>()
        verify(repository).setStrings(eq(Locale.ENGLISH), enCaptor.capture() )
        assertEquals(enStrings, enCaptor.firstValue)

        val deCaptor = argumentCaptor<Map<String,String>>()
        verify(repository).setStrings(eq(Locale.GERMAN), deCaptor.capture())
        assertEquals(deStrings, deCaptor.firstValue)
    }
}