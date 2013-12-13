/**
 * Copyright (C) Repos Mjukvara AB
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

    @Override
    public Set<Object> getSingletons() {
        logger.info("Starting application");
        Set<Object> resources = new HashSet<Object>();
        Injector context = Guice.createInjector(new WorkAreaModule());
        resources.add(context.getInstance(WorkAreaResource.class));
        return resources;
    }
}
