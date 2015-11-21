package ie.eirwig.servlet;

import ie.eirwig.spring.entity.CsoCityEntity;
import ie.eirwig.spring.entity.CsoFileParser;
import ie.eirwig.spring.entity.CsoType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

/**
 * The Class CsoServlet services requests for CSO data.
 */
@WebServlet("/CSO")
public class CsoServlet extends BaseHttpServlet {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected void runPrintWriter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String key = request.getParameter("key");
		CsoFileParser parser = getCsoFileParser(key);
		printEachCityCsoToWriter(response, parser);
	}

	@SuppressWarnings("deprecation")
	private void printEachCityCsoToWriter(HttpServletResponse response, CsoFileParser parser) throws IOException {
		Map<String, Integer> cityCounts = new HashMap<String, Integer>();
		PrintWriter printWriter = response.getWriter();
		int total = 0;
		List<CsoCityEntity> csoData = parser.getCsoData();
		for (CsoCityEntity entity : csoData) {
			cityCounts.put(entity.getCity(), Integer.parseInt(entity.getCount()));

			// delay reload
			printWriter.print("retry: 30000\n");
			printWriter.print("data:" + "{\n");
			printWriter.print("data:\"date\": \"" + new Date().toLocaleString() + "\",\n");
			printWriter.print("data:\"city\": \"" + entity.getCity() + "\",\n");
			printWriter.print("data:\"lat\": " + entity.getLattitude() + ",\n");
			printWriter.print("data:\"lng\": " + entity.getLongditude() + ",\n");
			printWriter.print("data:\"count\": " + entity.getCount() + ",\n");
			printWriter.print("data:\"cities\": " + JSONValue.toJSONString(cityCounts) + ",\n");
			printWriter.print("data:\"total\": " + (total += Integer.parseInt(entity.getCount())) + "\n");
			printWriter.print("data:" + "}\n\n");
			printWriter.flush();

			try {
				Thread.currentThread();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private CsoFileParser getCsoFileParser(String key) throws IOException {
		if (key != null) {
			if ("single-m".equals(key)) {
				return new CsoFileParser(CsoType.T1_2SGLM);
			}
			if ("single-f".equals(key)) {
				return new CsoFileParser(CsoType.T1_2SGLF);
			}
			if ("single-t".equals(key)) {
				return new CsoFileParser(CsoType.T1_2SGLT);
			}
			if ("ethnic-ie".equals(key)) {
				return new CsoFileParser(CsoType.T2_1IEN);
			}
			if ("ethnic-uk".equals(key)) {
				return new CsoFileParser(CsoType.T2_1UKN);
			}
			if ("ethnic-pl".equals(key)) {
				return new CsoFileParser(CsoType.T2_1PLN);
			}
			if ("ethnic-lt".equals(key)) {
				return new CsoFileParser(CsoType.T2_1LTN);
			}
		}
		return new CsoFileParser(CsoType.T1_1AGETT);
	}

}
