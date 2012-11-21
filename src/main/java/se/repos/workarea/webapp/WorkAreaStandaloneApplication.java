package se.repos.workarea.webapp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;
import se.repos.workarea.rest.WorkAreaResource;

public class WorkAreaStandaloneApplication extends Application {

	public static final Lgr logger = LgrFactory.getLogger();
	
	@Override
	public Set<Class<?>> getClasses() {
		logger.info("getClasses called");
		Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(WorkAreaResource.class);
        return classes;
	}
	
}
