package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import docoTsubu.*;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//呟きをアプリケーションスコープ（アプリの開始から終了まで保持している領域）から取得
		ServletContext application = this.getServletContext();
		
		//型指定でリストに格納する
		List<Mutter> mutterList =(List<Mutter>) application.getAttribute("mutterList");
		
		//取得できなかった場合は新規作成してアプリケーションスコープに保存
		if(mutterList ==null) {
			mutterList = new ArrayList<Mutter>();
			application.setAttribute("mutterList", mutterList);
		}
		
		//ログインしているかどうか確認する為にセッションスコープからユーザ情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser==null) {
			//@WebServlet("/Main")で指定しているURLと違うので、リダイレクトする
			response.sendRedirect("./");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータ
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力チェック
		if(text != null && text.length() !=0) {
			//アプリケーションスコープ内のつぶやきリストを取得
			ServletContext application = this.getServletContext();
			List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
			
			//セッションスコープに保存された情報を取得
			HttpSession session =request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//つぶやきをつぶやきリストに追加(参照渡し＜mutterList＞）
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogin postMutterLogin = new PostMutterLogin();
			postMutterLogin.execute(mutter,mutterList);
			
			//アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList", mutterList);
		}
		else {
			request.setAttribute("errorMSG", "つぶやきが入力されていません");
		}
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
