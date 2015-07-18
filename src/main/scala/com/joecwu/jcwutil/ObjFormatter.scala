package com.joecwu.jcwutil

import java.text.SimpleDateFormat
import java.util.{Locale, TimeZone}
import scalaz._, Scalaz._

/**
 * Created by Joe on 2015/7/19.
 */
object ObjFormatter {
  private val SDF_RFC3339 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
  private val SDF_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH)
  val TIMEZONE_UTC = TimeZone.getTimeZone("UTC")

  implicit def LongFormatter(v:Long) = LongFormatHandler(v)
  implicit def DateFormatter(date : java.util.Date) = DateFormatHandler(date)

  protected case class LongFormatHandler(v:Long) {
    def toStringRFC3339(implicit timeZone:Option[TimeZone]=TIMEZONE_UTC.some) : String = DateFormatHandler(new java.util.Date(v)).toStringRFC3339
    def toStringISO8601(implicit timeZone:Option[TimeZone]=TIMEZONE_UTC.some) : String = DateFormatHandler(new java.util.Date(v)).toStringISO8601
  }

  protected case class DateFormatHandler(date:java.util.Date) {
    def toStringRFC3339(implicit timeZone:Option[TimeZone]=TIMEZONE_UTC.some) : String = {
      timeZone.map(SDF_RFC3339.setTimeZone)
      SDF_RFC3339.format(date)
    }
    def toStringISO8601(implicit timeZone:Option[TimeZone]=TIMEZONE_UTC.some) : String = {
      timeZone.map(SDF_ISO8601.setTimeZone)
      SDF_ISO8601.format(date)
    }
  }
}
