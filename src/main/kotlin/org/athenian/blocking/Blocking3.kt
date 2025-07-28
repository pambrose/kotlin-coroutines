package org.athenian.blocking

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.athenian.log

// For more info, see: https://kt.academy/article/interop-blocking-to-coroutines
fun main() {
  runBlocking {
    launch(Dispatchers.IO) {
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
