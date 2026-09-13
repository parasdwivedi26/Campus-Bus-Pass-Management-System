package com.campusbuspass.dao;

import com.campusbuspass.db.DB;
import com.campusbuspass.model.Route;
import java.util.List;

/** CRUD operations for {@link Route}. IDs are auto-assigned when not provided. */
public class RouteDAO {

    /** Adds a route; assigns an auto-increment id if the route has none. */
    public void add(Route route) {
        if (route.getId() <= 0) {
            route.setId(nextId());
        }
        DB.routes().add(route);
        DB.save();
    }

    /** Finds a route by its numeric id. */
    public Route findById(int id) {
        for (Route r : DB.routes()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    /** Returns all routes (live view). */
    public List<Route> findAll() {
        return DB.routes();
    }

    /** Replaces the fields of an existing route. */
    public boolean update(Route updated) {
        Route existing = findById(updated.getId());
        if (existing == null) {
            return false;
        }
        existing.setRouteName(updated.getRouteName());
        existing.setSource(updated.getSource());
        existing.setDestination(updated.getDestination());
        existing.setDistance(updated.getDistance());
        existing.setFee(updated.getFee());
        DB.save();
        return true;
    }

    /** Removes a route by id. */
    public boolean delete(int id) {
        boolean removed = DB.routes().removeIf(r -> r.getId() == id);
        if (removed) {
            DB.save();
        }
        return removed;
    }

    public int count() {
        return DB.routes().size();
    }

    private int nextId() {
        return DB.routes().stream().mapToInt(Route::getId).max().orElse(0) + 1;
    }

    public int addRoute(String name, String source, String destination, double fee) {
        Route route = new Route(0, name, source, destination, 0, fee);
        add(route);
        return route.getId();
    }

    public List<Route> listAll() { return findAll(); }
}