package com.github.digitallyrefined.androidipcamera.helpers

import org.junit.Assert.assertEquals
import org.junit.Test

class CameraGlPipeTest {
    @Test
    fun `portrait picture from a 90 degree sensor gets a portrait frame`() {
        assertEquals(1080 to 1920, CameraGlPipe.frameSize(1920, 1080, sensorOrientation = 90, rotation = 0))
        assertEquals(1080 to 1920, CameraGlPipe.frameSize(1920, 1080, sensorOrientation = 270, rotation = 0))
        assertEquals(1080 to 1920, CameraGlPipe.frameSize(1920, 1080, sensorOrientation = 90, rotation = 180))
    }

    @Test
    fun `a quarter turn of the rotate control brings the frame back to landscape`() {
        assertEquals(1920 to 1080, CameraGlPipe.frameSize(1920, 1080, sensorOrientation = 90, rotation = 90))
        assertEquals(1920 to 1080, CameraGlPipe.frameSize(1920, 1080, sensorOrientation = 90, rotation = 270))
        assertEquals(1920 to 1080, CameraGlPipe.frameSize(1920, 1080, sensorOrientation = 90, rotation = -90))
    }

    @Test
    fun `sensors already upright keep the camera shape`() {
        assertEquals(1280 to 720, CameraGlPipe.frameSize(1280, 720, sensorOrientation = 0, rotation = 0))
        assertEquals(800 to 600, CameraGlPipe.frameSize(800, 600, sensorOrientation = 180, rotation = 360))
    }
}
