/**
 * Copyright (C) 2004-2012 Repos Mjukvara AB
 */
package se.repos.workarea.webapp;

import java.io.File;

import se.repos.authproxy.ReposCurrentUser;
import se.repos.backend.file.CmsCommitFilesystem;
import se.repos.backend.file.CmsItemLookupFilesystem;
import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;
import se.repos.workarea.WorkAreaConfiguration;
import se.repos.workarea.WorkAreaConfigurationPerUserImpl;
import se.repos.workarea.rest.WorkAreaResource;
import se.simonsoft.cms.item.CmsRepository;
import se.simonsoft.cms.item.commit.CmsCommit;
import se.simonsoft.cms.item.info.CmsItemLookup;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;

public class WorkAreaModule extends AbstractModule {

	private static final Lgr logger = LgrFactory.getLogger();
	
	@Override
	protected void configure() {
		logger.info("Configuring work area services");
		
		// REST resources
		bind(WorkAreaResource.class);

		// global services
		bind(ReposCurrentUser.class).to(ReposCurrentUserStub.class);
		bind(WorkAreaConfiguration.class).to(WorkAreaConfigurationPerUserImpl.class);
		
		// per repository services
		MapBinder<CmsRepository, CmsItemLookup> cmsItemLookupBinder
			= MapBinder.newMapBinder(binder(), CmsRepository.class, CmsItemLookup.class);
		
		CmsRepository testrepo = new CmsRepository("http://localhost/svn/testrepo");
		// original //File testrepoFilesystemRoot = new File("/tmp/repos-testrepo");
		// current test folder
		File testrepoFilesystemRoot = new File("tmp/repos-test/");
		
		// this is the future per-repository configuration
		cmsItemLookupBinder.addBinding(testrepo).to(CmsItemLookupFilesystem.class);
		
		// we don't have per-repository binding now so we set up a single repository config as global
		bind(CmsRepository.class).toInstance(testrepo);
		bind(File.class).annotatedWith(Names.named("root")).toInstance(testrepoFilesystemRoot);
		bind(CmsItemLookup.class).to(CmsItemLookupFilesystem.class);
		bind(CmsCommit.class).to(CmsCommitFilesystem.class);
	}

}
