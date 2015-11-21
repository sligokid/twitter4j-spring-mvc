package ie.eirwig.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ticker")
public class TickerServlet extends BaseHttpServlet {

	private static final long	serialVersionUID	= 1L;

	@SuppressWarnings("deprecation")
	@Override
	protected void runPrintWriter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		while (true) {
			printWriter.print("id: " + "TickerServlet" + "\n");
			printWriter.print("data: " + new Date().toLocaleString() + "\n\n");
			printWriter.flush();
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
