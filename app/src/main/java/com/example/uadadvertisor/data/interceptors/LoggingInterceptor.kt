

package com.raywenderlich.android.petsave.common.data.api.interceptors

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Inject

class LoggingInterceptor @Inject constructor() : HttpLoggingInterceptor.Logger {
  override fun log(message: String) {
    Logger.i(message)
  }
}

object Logger {
  private val logger by lazy {
    TimberLogging()
  }

  fun init() {
    Timber.plant(logger)
  }

  fun d(message: String, t: Throwable? = null) = logger.d(t, message)

  fun i(message: String, t: Throwable? = null) = logger.i(t, message)

  fun e(t: Throwable? = null, message: String) = logger.e(t, message)

  fun wtf(t: Throwable? = null, message: String) = logger.wtf(t, message)
}

class TimberLogging: Timber.DebugTree() {
  override fun createStackElementTag(element: StackTraceElement): String? {
    return "(${element.fileName}:${element.lineNumber}) on ${element.methodName}"
  }
}