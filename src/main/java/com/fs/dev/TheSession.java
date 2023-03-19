package com.fs.dev;

@SuppressWarnings({"rawtypes"})
public class TheSession implements javax.servlet.http.HttpSessionListener {
	private static int sessions;
	public void sessionCreated(javax.servlet.http.HttpSessionEvent e) {
		sessions++;
		System.out.println("session created : "+e+", id="+e.getSession().getId());
	}
	public void sessionDestroyed(javax.servlet.http.HttpSessionEvent e) {
		if(sessions>0) sessions--;
		System.out.println("session destroyed : "+e+", id="+e.getSession().getId());
		java.util.Enumeration en = e.getSession().getAttributeNames();
		for(;en.hasMoreElements();) {
			Object key = en.nextElement();
			System.out.println("destroy("+e.getSession().getId()+") "+key+"="+e.getSession().getAttribute(key.toString()));
		}
	}
}
