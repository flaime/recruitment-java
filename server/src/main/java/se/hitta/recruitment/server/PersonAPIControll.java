package se.hitta.recruitment.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import com.google.gson.Gson;

public class PersonAPIControll extends HttpServlet
{
    private static DataKeper dk;
    
    @Override
    public void init() throws ServletException {
    	dk = new DataKeper();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
    	Gson gson = new Gson();
    	
    	resp.setCharacterEncoding("utf-8");
    	resp.setContentType("json");
    	if(req.getPathInfo().matches("\\/person\\/\\d+")){
    		int number =Integer.parseInt(req.getPathInfo().replaceAll("\\/person\\/", ""));//.split("\\/person\\/")[1]);
    		if(dk.getPerson(number) !=null){
    			String jsonInString = gson.toJson(dk.getPerson(number));
    			resp.getWriter().print(jsonInString);
    		}else{
    			//return fel TODO eller inget
    		}
    	}else{
    		if(req.getParameter("gender") != null){
    			if(req.getParameter("gender").equalsIgnoreCase("male"))
    				resp.getWriter().print(gson.toJson(dk.getAllMale()));
    			if(req.getParameter("gender").equalsIgnoreCase("female"))
    				resp.getWriter().print(gson.toJson(dk.getAllFemale()));
    		}
    	}
        
    }

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	String ret = "har kommer jag";
//    	JAXBContext jc;
//		try {
//			jc = JAXBContext.newInstance(Person.class);
//			StreamSource xml = new StreamSource(req.getInputStream());// ( req.getAsyncContext()); //"src/blog/defaults/input.xml");
//	        Unmarshaller unmarshaller = jc.createUnmarshaller();
//	        JAXBElement<Person> je1 = unmarshaller.unmarshal(xml, Person.class);
//	        Person customer = je1.getValue();
//	 
//	        JAXBElement<Person> je2 = new JAXBElement<Person>(new QName("customer"), Person.class, customer);
//	        Marshaller marshaller = jc.createMarshaller();
//	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//	        marshaller.marshal(je2, System.out);
//	        ret += "gick igenom";
//		} catch (JAXBException e) {
//			ret += "gick ej igenom";
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.addHeader("Location", "http://127.0.0.1:8080/person/123");
//        resp.se
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
}