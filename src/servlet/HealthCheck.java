package servlet;

//サーブレット（コントローラ）

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Health;
import servlet.HealthCheckLogic;

@WebServlet("/HealthCheck") //URLパターン（/クラス名）
public class HealthCheck extends HttpServlet {
  private static final long serialVersionUID = 1L; //serialVersionUIDフィールド※Eclipseでサーブレット作成すると自動生成

  protected void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {

    //フォワード
    //サーブレットから他のサーブレットやJSPなどにリクエストを転送して処理を委託する(ディスパッチ)
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp"); //移動先を決定
    dispatcher.forward(request, response); //移動先のページへ移動
  }

  protected void doPost(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {

    //リクエストパラメータを取得
    String height = request.getParameter("height"); //身長
    String weight = request.getParameter("weight"); //体重

    //入力値をプロパティに設定
    Health health = new Health();
    health.setHeight(Double.parseDouble(height)); //文字列を数値へ変換
    health.setWeight(Double.parseDouble(weight)); //文字列を数値へ変換
    //健康診断を実行し結果を設定
    HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
    /* インスタンスの引数
     * メソッドにインスタンスを引数で渡した場合、呼び出し先のメソッドで引数のインスタンスを変更すると呼び出し元のインスタンスも変更される
     * そのため、execute()メソッド内で引数のHealthインスタンスにBMIと体型を設定すると、サーブレットクラスのHealthインスタンスにもBMIと体型が設定される
     * このしくみを参照渡しと呼ぶ
     */
    healthCheckLogic.execute(health); //healthCheckLogicのexecuteメソッド呼び出し
    
    SQLExecution sqlExecution = new SQLExecution();
    sqlExecution.insert(health);

    //リクエストスコープに保存(setAttributeメソッド)
    request.setAttribute("health", health);

    //フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
    dispatcher.forward(request, response);
  }
}