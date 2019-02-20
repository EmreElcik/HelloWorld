package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TAuto-generated method stub
		
		PrintWriter out = resp.getWriter();
		System.out.println("Filter is invoked before");
		
		chain.doFilter(req, resp);
		
		System.out.println("Filter is invoked after");
		
	}

	
}
