package serveltPackage;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class WebContext implements ServletContextListener {
	private ServletContext context=null;
	
	
	public ServletContext getContext() {
		return context;
	}


	public void setContext(ServletContext context) {
		this.context = context;
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		context=arg0.getServletContext();
	}
	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0){
		context=arg0.getServletContext();
		System.out.println("ServerContextListener started Now");
	}
}