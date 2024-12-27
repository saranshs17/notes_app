package com.example.notes_app.presentation.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun formatTimeStampToDDMMYYYY(timestamp:String) : String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(timestamp,formatter)

    val zoneId = ZoneId.of("Asia/Kolkata")
    val istDateTime = zonedDateTime.withZoneSameInstant(zoneId)

    val day = istDateTime.dayOfMonth.toString().padStart(2,'0')
    val month = istDateTime.monthValue.toString().padStart(2,'0')
    val year = istDateTime.year.toString()

    return "$day-$month-$year"
}