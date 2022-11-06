package routing

import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Routing.indexRouting() {
    static("/") {
        resources("/")
        resource("/", "index.html")
    }
}
