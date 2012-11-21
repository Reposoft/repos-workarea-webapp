package se.repos.workarea.webapp;

import org.apache.wink.common.internal.lifecycle.LifecycleManagersRegistry;
import org.apache.wink.guice.server.internal.lifecycle.GuiceInjectorLifeCycleManager;
import org.apache.wink.guice.server.internal.lifecycle.WinkGuiceModule;
import org.apache.wink.server.handlers.Handler;
import org.apache.wink.server.internal.DeploymentConfiguration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class DependencyInjectionDeploymentConfiguration
//	extends GuiceDeploymentConfiguration {
//
//	private static final Lgr logger = LgrFactory.getLogger();
//	
//	@Override
//	public Module[] createModules() {
//		logger.info("Setting up dependency injection modules");
//		ArrayList<Module> modules = new ArrayList<Module>();
//		for (Module wink : super.createModules()) {
//			modules.add(wink);
//		}
//		modules.add(new WorkAreaModule());
//		return modules.toArray(new Module[]{});
//	}
	extends DeploymentConfiguration {

	public DependencyInjectionDeploymentConfiguration() {
		LifecycleManagersRegistry lifecycleManagersRegistry = new LifecycleManagersRegistry();
		setOfFactoryRegistry(lifecycleManagersRegistry);
		injector = Guice.createInjector(createModules());
		lifecycleManagersRegistry.addFactoryFactory(new GuiceInjectorLifeCycleManager(injector));
	}

	public Module[] createModules() {
		return new Module[] {new WinkGuiceModule() ,
				new WorkAreaModule()
		};
	}

	private final Injector injector;

	@Override
	protected <T extends Handler> T createHandler(Class<T> cls) {
		try {
			return injector.getInstance(cls);
		} catch (Throwable th) {
			return super.createHandler(cls);
		}
	}

}
