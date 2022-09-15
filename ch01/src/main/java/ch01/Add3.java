package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")//서버프로그램이고 url은 /Add3(서버이름)
public class Add3 extends HttpServlet { //add3의 아버지는 HttpServlet
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 get방식으로 수행하면 얘를받음*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목표  : 1부터 누적값 전달
		int num = Integer.parseInt(request.getParameter("num"));//넘어오는 값은 무조건 문자
		String loc = request.getParameter("loc");
		System.out.println("Add3 num->" + num);
		int sum = 0;
		for(int i = 1 ; i <= num ; i ++) {
			sum +=i;
		}
		//서블릿은 미국 기준이라 인코딩 방식을 다시 설정해주어야 함
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 공식 -->사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.printf("<h4>LOC --> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		//파라메터명은 name속성 값은 value로 input태그의 값이 전부 넘어온다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 post방식으로 받으면 얘로감*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		System.out.println("doPost 시작");
		doGet(request, response);
	}

}
