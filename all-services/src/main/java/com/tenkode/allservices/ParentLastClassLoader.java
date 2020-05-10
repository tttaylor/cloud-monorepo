package com.tenkode.allservices;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParentLastClassLoader extends URLClassLoader {

	public ParentLastClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}

	@Override
	public URL getResource(String name) {
		URL res = findResource(name);
		if (res == null) {
			res = super.getResource(name);
		}
		return res;
	}

	@Override
	public InputStream getResourceAsStream(String name) {
		final URL url = getResource(name);
		try {
			return url != null ? url.openStream() : null;
		} catch (final IOException e) {
		}
		return null;
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		final List<URL> allResources = new LinkedList<>();

		final Enumeration<URL> childResources = findResources(name);
		if (childResources != null) {
			while (childResources.hasMoreElements()) {
				allResources.add(childResources.nextElement());
			}
		}

		final Enumeration<URL> parentResources = super.findResources(name);
		if (parentResources != null) {
			while (parentResources.hasMoreElements()) {
				allResources.add(parentResources.nextElement());
			}
		}

		return new Enumeration<URL>() {
			Iterator<URL> it = allResources.iterator();

			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public URL nextElement() {
				return it.next();
			}
		};
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		synchronized (getClassLoadingLock(name)) {
			// First, check if the class has already been loaded
			Class<?> c = findLoadedClass(name);
			if (c == null) {
				try {
					c = findClass(name);
				} catch (final ClassNotFoundException e) {
					// ClassNotFoundException thrown if class not found
					// from the non-null parent class loader
					c = super.loadClass(name);
				}

			}
			if (resolve) {
				resolveClass(c);
			}
			return c;
		}
	}
}
