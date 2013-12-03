/**
 * Copyright (C) 2004-2012 Repos Mjukvara AB
 */
package se.repos.workarea.webapp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.google.inject.Guice;
import com.google.inject.Injector;

import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;
import se.repos.workarea.rest.WorkAreaResource;

public class WorkAreaStandaloneApplication extends Application {

	public static final Lgr logger = LgrFactory.getLogger();

	Injector configure() {
		return Guice.createInjector(
				new WorkAreaModule()
				);
	}
	
	@Override
	public Set<Object> getSingletons() {
		logger.info("Starting application");
		Injector context = configure();
		Set<Object> resources = new HashSet<Object>();
		resources.add(context.getInstance(WorkAreaResource.class));
		return resources;
	}
	
}
