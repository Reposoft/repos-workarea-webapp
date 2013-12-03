package se.repos.workarea.webapp.staffantest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.repos.lgr.Lgr;
import se.repos.lgr.LgrFactory;
import se.repos.workarea.dropbox.DropboxTokenStore;

public class DropboxTokenStoreMemory implements DropboxTokenStore {

	private static final Lgr logger = LgrFactory.getLogger();
	
	private Map<String, List<String>> tokens = new HashMap<String, List<String>>();
	
	@Override
	public List<String> read(String userName) {
		logger.debug("Tokens for user", userName, tokens.get(userName));
		return tokens.get(userName);
	}

	@Override
	public void write(String userName, List<String> tokens) {
		this.tokens.put(userName, tokens);
		logger.info("Token stored for user", userName, tokens);
	}

}
