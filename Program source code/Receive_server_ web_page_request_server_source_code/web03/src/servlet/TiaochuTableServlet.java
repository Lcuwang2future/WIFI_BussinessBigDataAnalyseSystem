package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handle.TiaochuHandler;
import net.sf.json.JSONObject;

public class TiaochuTableServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject jo=new JSONObject();
		double[] r=TiaochuHandler.GetHisRate();
		String[] rate=TiaochuHandler.FormatRate(r);
		String[] status=TiaochuHandler.GetRateStatus(r);
		jo.put("rate", rate);
		jo.put("status", status);
		resp.getOutputStream().write(jo.toString().getBytes());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
