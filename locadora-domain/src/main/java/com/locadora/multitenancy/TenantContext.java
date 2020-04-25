package com.locadora.multitenancy;

public class TenantContext {

	private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

	private TenantContext() {
	}

	public static String get() {
		return TenantContext.currentTenant.get();
	}

	public static void set(String tenant) {
		TenantContext.currentTenant.set(tenant);
	}

	public static void remove() {
		TenantContext.currentTenant.remove();
	}

}
