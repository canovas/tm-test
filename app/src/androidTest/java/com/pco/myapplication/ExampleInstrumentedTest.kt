package com.pco.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pco.myapplication.conn.TMResult
import com.pco.myapplication.managers.TMManager
import com.pco.myapplication.networking.responses.GraphData
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    val tmManager: TMManager = TMManager.getInstance()!!


    @Test
    suspend fun testDayCenterCategory() {
        val result: TMResult = tmManager.getDayCenterCategory()
        assertNotNull(result)
        assertEquals(result, TMResult.Success)


        when(tmManager.getDayCenterCategory()){

        }
    }
}