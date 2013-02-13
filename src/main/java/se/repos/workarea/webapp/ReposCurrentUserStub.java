/**
 * Copyright (C) 2004-2012 Repos Mjukvara AB
 */
package se.repos.workarea.webapp;

import se.repos.authproxy.AuthFailedException;
import se.repos.authproxy.AuthRequiredException;
import se.repos.authproxy.ReposCurrentUser;

/**
 * Produces usernames as if there was a login system.
 */
public class ReposCurrentUserStub implements ReposCurrentUser {

	@Override
	public String getUsername() {
		return "singleuser";
	}
	
	@Override
	public String getPassword() {
		throw new UnsupportedOperationException("not needed in stub");
	}

	@Override
	public String getUsernameRequired(String arg0) throws AuthRequiredException {
		throw new UnsupportedOperationException("not needed in stub");
	}

	@Override
	public boolean isAuthenticated() {
		throw new UnsupportedOperationException("not needed in stub");
	}

	@Override
	public void setFailed(String arg0) throws AuthFailedException {
		throw new UnsupportedOperationException("not needed in stub");
	}

}
