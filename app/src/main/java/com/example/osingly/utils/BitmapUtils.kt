package com.example.osingly.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore

object BitmapUtils {
    fun getCameraIntent(): Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

    fun extractBitmapFromResult(data: Intent?): Bitmap? {
        return data?.extras?.get("data") as? Bitmap
    }

    fun uriToBitmap(context: Context, uri: Uri): Bitmap {
        val source = ImageDecoder.createSource(context.contentResolver, uri)
        return ImageDecoder.decodeBitmap(source)
    }
}
