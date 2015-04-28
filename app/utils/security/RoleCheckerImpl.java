package utils.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.user.Permission;
import models.user.Role;
import play.Logger;
import play.db.jpa.JPA;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import dao.GenericDAO;

@Singleton
public class RoleCheckerImpl implements RoleChecker {

	protected GenericDAO<Role, Long> dao;

	private Map<String, Map<String, List<String>>> roles;

	@Inject
	public RoleCheckerImpl(@Named("RoleDAO") GenericDAO<Role, Long> dao) {
		this.dao = dao;
		roles = new HashMap<String, Map<String, List<String>>>();
		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				loadPermissions();
			}
		});

		if (Logger.isDebugEnabled()) {
			for (String role : roles.keySet()) {
				Logger.debug("Role: " + role);

				for (String function : roles.get(role).keySet()) {
					Logger.debug("      Function: " + role);

					for (String method : roles.get(role).get(function)) {
						Logger.debug("                Method:" + method);
					}

				}
			}
		}
	}

	private void loadPermissions() {
		List<Role> dbroles;
		try {
			dbroles = dao.getAll();
		} catch (Exception e) {
			Logger.error("Failed to load permissions.", e);
			return;
		}

		Map<String, List<String>> functionRoleList;
		List<String> functionList;
		for (Role role : dbroles) {
			functionRoleList = new HashMap<String, List<String>>();

			for (Permission permission : role.getPermissions()) {
				if (functionRoleList.containsKey(permission.getFunction())) {
					functionRoleList.get(permission.getFunction()).add(
							permission.getHttpMethod());
				} else {
					functionList = new ArrayList<String>();
					functionList.add(permission.getHttpMethod());
					functionRoleList
							.put(permission.getFunction(), functionList);
				}
			}
			roles.put(role.getName(), functionRoleList);
		}
	}

	@Override
	public boolean isAllowed(String role, String function, String httpMethod) {
		boolean isallowed = false;
		try {
			Map<String, List<String>> roleMap = roles.get(role);
			List<String> functionList = roleMap.get(function);
			isallowed = functionList.contains(httpMethod);

		} catch (NullPointerException e) {
			isallowed = false;
		}
		return isallowed;
	}
}
