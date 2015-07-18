package com.joecwu.jcwutil.test

import java.text.SimpleDateFormat
import java.util.{TimeZone, Locale}

import org.scalatest.FlatSpec
import com.joecwu.jcwutil.ObjFormatter._

/**
 * Test spec for ObjFormatter
 * Created by Joe on 2015/7/19.
 */
class ObjFormatterTest extends FlatSpec {
  private val SDF_RFC3339 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
  private val SDF_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH)

  behavior of "LongFormatter"
  it should "convert Long to Date(RFC3339) format:(yyyy-MM-dd'T'HH:mm:ss'Z')" in {
    val ts = System.currentTimeMillis()
    val date = new java.util.Date(ts)
    SDF_RFC3339.setTimeZone(TimeZone.getTimeZone("UTC"))
    val dateStr = SDF_RFC3339.format(date)
    assertResult(ts.toStringRFC3339())(dateStr)
  }
  it should "convert Long to Date(ISO8601) format:(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)" in {
    val ts = System.currentTimeMillis()
    val date = new java.util.Date(ts)
    SDF_ISO8601.setTimeZone(TimeZone.getTimeZone("UTC"))
    val dateStr = SDF_ISO8601.format(date)
    assertResult(ts.toStringISO8601())(dateStr)
  }

  behavior of "DateFormatter"
  it should "convert Long to Date(RFC3339) format:(yyyy-MM-dd'T'HH:mm:ss'Z')" in {
    val ts = System.currentTimeMillis()
    val date = new java.util.Date(ts)
    SDF_RFC3339.setTimeZone(TimeZone.getTimeZone("UTC"))
    val dateStr = SDF_RFC3339.format(date)
    assertResult(date.toStringRFC3339())(dateStr)
  }
  it should "convert Long to Date(ISO8601) format:(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)" in {
    val ts = System.currentTimeMillis()
    val date = new java.util.Date(ts)
    SDF_ISO8601.setTimeZone(TimeZone.getTimeZone("UTC"))
    val dateStr = SDF_ISO8601.format(date)
    assertResult(date.toStringISO8601())(dateStr)
  }

}
