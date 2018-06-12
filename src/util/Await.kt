package util

import org.w3c.fetch.Response
import kotlin.coroutines.experimental.*
import kotlin.js.Promise

external fun fetch(url: String): Promise<Response> = definedExternally

suspend fun <T> Promise<T>.await(): T = suspendCoroutine {
    then(it::resume).catch(it::resumeWithException)
}

fun <T> async(block: suspend () -> T) = Promise<T> { resolve, reject ->
    block.startCoroutine(completion = object : Continuation<T> {
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resume(value: T) {
            resolve(value)
        }

        override fun resumeWithException(exception: Throwable) {
            reject(exception)
        }
    })
}