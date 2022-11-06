package sysoev.sd.mvc.server

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*


fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    routing {
        static("/") {
            resources("/")
            resource("/", "index.html")
        }
    }
}
