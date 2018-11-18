

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		PrintWriter wrt = response.getWriter();
		String myHostName = InetAddress.getLocalHost().getHostName();
		// String myIP= InetAddress.get
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String myIP = InetAddress.getByName(myHostName).toString();
		String remoteHost = request.getRemoteAddr();
		int nbProc= Runtime.getRuntime().availableProcessors();
		long totalMem = Runtime.getRuntime().freeMemory()/1024/1024;
		wrt.println("Time :"+ formatter.format(now) +"\n");
	 	wrt.println("JVM Hostaname / Ip address: "+ myIP+"\n");
		wrt.println("JVM Availaible processors: " + nbProc+"\n");
		wrt.println("JVM total memory: " + totalMem +"\n");
		wrt.println("Remote Host: " + remoteHost +"\n");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
