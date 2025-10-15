package com.example.resources;

import com.example.Medicament;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/medicaments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicamentResource {
    private static List<Medicament> medicaments = new ArrayList<>();

    static {
        medicaments.add(new Medicament("one", 1000.3));
        medicaments.add(new Medicament("two", 32.3));
        medicaments.add(new Medicament("three", 300.3));
    }

    @GET
    public List<Medicament> getAll() {
        return medicaments;
    }

    @POST
    public Response create(Medicament medicament) {
        medicaments.add(medicament);
        return Response.ok(medicament).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        Medicament medicament = medicaments.stream()
                .filter((m) -> m.getId() == id)
                .findFirst().orElse(null);

        return medicament != null
                ? Response.ok(medicament).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Medicament updatedMedicament) {
        for (Medicament m2 : medicaments) {
            if(m2.getId() == id) {
                m2.setName(updatedMedicament.getName());
                m2.setPrice(updatedMedicament.getPrice());
                return Response.ok(m2).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response update(@PathParam("id") int id) {
        for (Medicament m2 : medicaments) {
            if(m2.getId() == id) {
                medicaments.remove(medicaments.indexOf(m2));
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
