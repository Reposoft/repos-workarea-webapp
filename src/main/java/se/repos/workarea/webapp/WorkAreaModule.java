/**
 * Copyright (C) 2004-2012 Repos Mjukvara AB
 */
package se.repos.workarea.webapp;

import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;

import com.google.inject.AbstractModule;

public class WorkAreaModule extends AbstractModule {

    private static final Lgr logger = LgrFactory.getLogger();

    @Override
    protected void configure() {
        logger.info("Configuring work area services");
        // TODO Bind classes to stubs, run user test.
    }

}
