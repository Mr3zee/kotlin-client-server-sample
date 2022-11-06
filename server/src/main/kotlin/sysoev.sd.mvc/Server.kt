package sysoev.sd.mvc

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main() {
    embeddedServer(CIO, port = 8080, host = "127.0.0.1") {
        routing {
            get("/") {
                call.respond("Hello")
            }
            static("/static") {
                resources()
            }
        }
    }.start(wait = true)
}
