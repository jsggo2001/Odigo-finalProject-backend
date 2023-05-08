package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class AppInitListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("root", application.getContextPath());
		System.out.println("root set..................");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
