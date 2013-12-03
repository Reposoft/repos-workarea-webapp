/**
 * Copyright (C) 2004-2012 Repos Mjukvara AB
 */
package se.repos.workarea.webapp;

import java.io.File;

import se.repos.authproxy.ReposCurrentUser;
import se.repos.backend.file.CmsItemLookupFilesystem;
import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;
import se.repos.workarea.WorkArea;
import se.repos.workarea.WorkAreaConfiguration;
import se.repos.workarea.WorkAreaConfigurationPerUserImpl;
import se.repos.workarea.dropbox.DropboxTokenStore;
import se.repos.workarea.dropbox.DropboxTokenStoreTempfile;
import se.repos.workarea.dropbox.WorkAreaDropBox;
import se.repos.workarea.rest.WorkAreaResource;
import se.repos.workarea.webapp.staffantest.DropboxTokenStoreMemory;
import se.simonsoft.cms.item.CmsRepository;
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
		//bind(DropboxTokenStore.class).to(DropboxTokenStoreTempfile.class);
		bind(DropboxTokenStore.class).to(DropboxTokenStoreMemory.class);
		
		
		
		// per repository services
		MapBinder<CmsRepository, CmsItemLookup> cmsItemLookupBinder
			= MapBinder.newMapBinder(binder(), CmsRepository.class, CmsItemLookup.class);
		
		CmsRepository testrepo = new CmsRepository("http://localhost/svn/testrepo");

		File testrepoFilesystem = new File("/tmp/repos-test");
		cmsItemLookupBinder.addBinding(testrepo).toInstance(new CmsItemLookupFilesystem(testrepo,testrepoFilesystem));
		
		DropboxTokenStore tokenstore = new DropboxTokenStoreTempfile();
		bind(DropboxTokenStore.class).annotatedWith(Names.named("tokenstore")).toInstance(tokenstore);
		
		
	}

}
