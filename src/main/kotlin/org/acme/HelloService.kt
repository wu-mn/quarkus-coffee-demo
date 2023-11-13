package org.acme

import org.acme.Greeter
import org.acme.HelloReply
import org.acme.HelloRequest
import io.quarkus.grpc.GrpcService
import io.smallrye.mutiny.Uni


@GrpcService
class HelloService : Greeter {
    override fun sayHello(request: HelloRequest): Uni<HelloReply> {
        //環境変数検査ため
        // System.getProperties().forEach { key, value ->
        //         println("System Property: $key = $value")
        //     }
        // System.getenv().forEach { key, value ->
        //         println("Environment Variable: $key = $value")
        //     }
        return Uni.createFrom().item {
            HelloReply.newBuilder()
                .setMessage("Hello ${request.name}")
                .setTete("Hello ${request.name}")
                .build()
        }
    }
}
