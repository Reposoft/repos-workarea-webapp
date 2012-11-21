package se.repos.workarea.webapp;

import se.repos.workarea.rest.WorkAreaResource;

import com.google.inject.AbstractModule;

public class WorkAreaModule extends AbstractModule {

	@Override
	protected void configure() {
	
		bind(WorkAreaResource.class);

	}

}
