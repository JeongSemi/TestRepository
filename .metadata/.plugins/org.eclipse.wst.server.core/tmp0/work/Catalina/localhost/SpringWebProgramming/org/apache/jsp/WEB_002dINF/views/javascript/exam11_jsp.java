/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2017-06-06 17:05:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.javascript;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class exam11_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link href=\"");
      out.print(application.getContextPath());
      out.write("/resources/bootstrap-3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <script src=\"");
      out.print(application.getContextPath());
      out.write("/resources/jquery/jquery-3.2.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"");
      out.print(application.getContextPath());
      out.write("/resources/bootstrap-3.3.7/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            function handleBtn1() {\r\n");
      out.write("//                var img = document.querySelector(\"img\"); //제일 첫번째 이미지 객체의 번지를 리턴\r\n");
      out.write("//                img.src = \"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo02.jpg\";\r\n");
      out.write("\r\n");
      out.write("                var imgArray = document.querySelectorAll(\"img\"); //이미지를 모두 찾아서 배열로 리턴\r\n");
      out.write("                for (var i = 0; i < imgArray.length; i++) {\r\n");
      out.write("                    imgArray[i].src = \"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo02.jpg\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function handleBtn2() {\r\n");
      out.write("                var img1 = document.querySelector(\"#img1\");\r\n");
      out.write("                img1.src = \"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo03.jpg\";\r\n");
      out.write("            }\r\n");
      out.write("            function handleBtn3() {\r\n");
      out.write("                var class1 = document.querySelectorAll(\".class1\");\r\n");
      out.write("                for (var i = 0; i < class1.length; i++) {\r\n");
      out.write("                    class1[i].src = \"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo04.jpg\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>DOM 사용하기</h1>\r\n");
      out.write("        <div>\r\n");
      out.write("            <button class=\"btn btn-warning\" onclick=\"handleBtn1()\">이미지 변경</button><br/>\r\n");
      out.write("            <img src=\"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo01.jpg\" width=\"100px\" height=\"100px\"/>\r\n");
      out.write("            <img src=\"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo02.jpg\" width=\"100px\" height=\"100px\"/>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <button class=\"btn btn-success\" onclick=\"handleBtn2()\" >img1의 이미지 변경</button>\r\n");
      out.write("            <button class=\"btn btn-success\" onclick=\"handleBtn3()\">class1의 이미지 변경</button><br/>\r\n");
      out.write("            <img id=\"img1\" src=\"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo01.jpg\" width=\"100px\" height=\"100px\"/>\r\n");
      out.write("            <img class=\"class1\" src=\"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo02.jpg\" width=\"100px\" height=\"100px\"/>\r\n");
      out.write("            <img class=\"class1\" src=\"");
      out.print(application.getContextPath());
      out.write("/resources/image/photo02.jpg\" width=\"100px\" height=\"100px\"/>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}