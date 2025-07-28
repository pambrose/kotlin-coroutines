package org.athenian.blocking

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.athenian.log
import java.util.concurrent.Executors
import kotlin.time.Duration.Companion.seconds

// For more info, see: https://kt.academy/article/interop-blocking-to-coroutines
fun main() {
  return runBlocking {
    val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
    // Give thread pool a chance to start
    delay(1.seconds)

    launch(dispatcher) {
      log("Before first sleep")
      Thread.sleep(5000)
      log("After first sleep")
    }

    launch {
      (1..10).forEach {
        log("I am here $it")
        delay(100)
      }
    }
  }
}
