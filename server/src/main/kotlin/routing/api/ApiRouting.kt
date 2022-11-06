package routing.api

import ClientName
import ServerGreeting
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.apiRouting() {
    route("/api") {
        post("/hello") {
            val client = call.receive<ClientName>()
            call.respond(ServerGreeting("Hi from server, ${client.name}"))
        }
    }
}
