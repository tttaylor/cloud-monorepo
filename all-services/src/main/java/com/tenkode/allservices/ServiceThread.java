package com.tenkode.allservices;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ServiceThread extends Thread {
	private final String applicationMainClassName;

	public ServiceThread(String applicationMainClassName) {
		this.applicationMainClassName = applicationMainClassName;
		this.setName(applicationMainClassName + "-thread");
	}

	@Override
	public void run() {
		final String mainClassRelativePath = applicationMainClassName.replace(".class", "").replace(".", "/")
				.concat(".class");
		final URL mainClassUrl = this.getClass().getClassLoader().getSystemResource(mainClassRelativePath);
		final int classesIndex = mainClassUrl.toString().indexOf("/classes");
		try {
			final URL baseUrl = new URL(mainClassUrl.toString().substring(0, classesIndex + 1));
			final URL classesUrl = new URL(mainClassUrl.toString().substring(0, classesIndex + 1).concat("classes/"));
			final ClassLoader classLoader = new URLClassLoader(new URL[] { baseUrl, classesUrl },
					this.getContextClassLoader());
			this.setContextClassLoader(classLoader);
			final Class applicationClass = classLoader.loadClass(applicationMainClassName.replace(".class", ""));
			Method mainMethod;
			try {
				mainMethod = applicationClass.getMethod("main", String[].class);
				mainMethod.invoke(null, new Object[] { new String[] {} });
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (final MalformedURLException | ClassNotFoundException e) {
		}
	}
}
