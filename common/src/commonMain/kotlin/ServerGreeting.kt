import kotlinx.serialization.Serializable

@Serializable
data class ClientName(val name: String)

@Serializable
data class ServerGreeting(val greeting: String)
