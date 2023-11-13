package com.coffeesupply

import com.coffeesupply.dto.Coffee
import com.coffeesupply.repository.CoffeeRepository
import org.jboss.resteasy.annotations.jaxrs.QueryParam
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.persistence.EntityManager
import jakarta.inject.Inject
import jakarta.persistence.PersistenceContext
import org.jboss.logging.Logger


@Path("/coffee")
class CoffeeResource(val repository: CoffeeRepository) {
    private val log = Logger.getLogger(CoffeeResource::class.java)

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // fun findAll(): Response = Response.ok(repository.listAll()).build()

    // @GET
    // @Path("/search")
    // @Produces(MediaType.APPLICATION_JSON)
    // fun findByOriginCountry(
    //         @QueryParam originCountry: String
    // ): Response = Response.ok(repository.findByOriginCountry(originCountry)).build()

    @Inject
    @PersistenceContext
    lateinit var entityManager: EntityManager

    // Create a new Coffee entry
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun create(coffee: Coffee): Response {
        // log.debug("coffeeClassCheck: ${coffee::class.simpleName}")
        println("Received coffee of type: ${coffee::class.simpleName}")
        val isManaged = entityManager.contains(coffee)
        println("Received coffee isManaged: $isManaged")
        entityManager.merge(coffee)
        // repository.persist(coffee)
        return Response.ok(coffee).status(201).build()
    }

    // // Delete a Coffee entry
    // @DELETE
    // @Path("/{id}")
    // @Transactional
    // @Produces(MediaType.APPLICATION_JSON)
    // fun delete(
    //         @PathParam("id") id: Long
    // ): Response {
    //     repository.deleteById(id)
    //     return Response.ok("Item id $id deleted.").build()
    // }

    // // Update a Coffee entry
    // @PUT
    // @Path("/{id}")
    // @Transactional
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // fun update(coffee: CoffeeEntity, @PathParam("id") id: Long): Response {
    //     repository.update("" +
    //             "sku = ${coffee.sku}, " +
    //             "productName = '${coffee.productName}', " +
    //             "price = ${coffee.price}, " +
    //             "description = '${coffee.description}', " +
    //             "originCountry = '${coffee.originCountry}' " +
    //             "where id = $id")
    //     return Response.ok(repository.findById(id)).build()
    // }
}
