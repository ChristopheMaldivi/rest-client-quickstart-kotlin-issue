package org.acme.restclient

import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.resteasy.annotations.jaxrs.PathParam

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.CompletionStage

@Path("/country")
class CountriesResource {

    @Inject
    @RestClient
    internal var countriesService: CountriesService? = null


    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun name(@PathParam name: String): Set<Country> {
        return countriesService!!.getByName(name)
    }

    @GET
    @Path("/name-async/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun nameAsync(@PathParam name: String): CompletionStage<Set<Country>> {
        return countriesService!!.getByNameAsync(name)
    }
}
