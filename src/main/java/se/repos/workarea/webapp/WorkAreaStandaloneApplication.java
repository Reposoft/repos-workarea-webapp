/**
 * Copyright (C) 2004-2012 Repos Mjukvara AB
 */
package se.repos.workarea.webapp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class WorkAreaStandaloneApplication extends Application {

    public static final Lgr logger = LgrFactory.getLogger();

    private static Injector configure() {
        return Guice.createInjector(new WorkAreaModule());
    }

    @Override
    public Set<Object> getSingletons() {
        logger.info("Starting application");
        Injector context = WorkAreaStandaloneApplication.configure();
        Set<Object> resources = new HashSet<>();
        // TODO Add resources.
        // resources.add(context.getInstance(WorkAreaResource.class));
        return resources;
    }

}
