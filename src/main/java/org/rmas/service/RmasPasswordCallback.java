package org.rmas.service;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class RmasPasswordCallback implements CallbackHandler {

	private Map<String, String> users;

	public RmasPasswordCallback(Map<String, String> args) {
		this.users = args;
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

		if (users.containsKey(pc.getIdentifier())) {
			pc.setPassword(users.get(pc.getIdentifier()));
		}

	}

}
