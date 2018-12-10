package scptcg.server;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

//必須
//nameにサーブレット名を、urlPatternsにヒットするURLのリストを渡す。
//ワイルドカードを
@WebServlet(
        name = "HttpServlet",
        urlPatterns = {"/Test/*"})
@MultipartConfig (
        fileSizeThreshold= 32768 ,
        maxFileSize= 5242880 ,
        maxRequestSize= 27262976
)
// javax.servlet.http.HttpServletを継承することでサーブレットとして利用できる
public class HttpServlet extends javax.servlet.http.HttpServlet {

    // doGetメソッドがGETリクエストを受け取ったときに呼び出されるメソッド
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            // この辺はとりあえずおまじない。
            //文字コードとか色々
            response.setContentType("text/html; charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            request.setCharacterEncoding("utf-8");

            // PrintWiterをgetしておくことで、System.out.println()のように文字列を返却できる。
            out = response.getWriter();

            // request.getServletPath();でこのプロジェクトのルートから下でどのようなパスが入力されたかを受け取る。
            //今回は適当にswitchで分岐する。
            String path = request.getServletPath();
            String str = null;
            switch(path){
                case "/hoge":
                    // request.getParameter()でパラメータを受け取る。
                    // http://localhost:8080/Test/hoge?str=hage&str2=hige
                    // のようなURLの?str=hage&str2=higeの部分
                    str = request.getParameter("str");
                    break;
                case "/huga":
                    str = "huga";
                    break;
            }
            // strの中身を送り返す。
            out.println(path);
            out.println(str);
            // flushもちゃんと呼ぶこと。
            out.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }


}