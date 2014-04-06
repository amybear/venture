/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.50
 * Generated at: 2014-04-06 19:13:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userHomepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=US-ASCII");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=US-ASCII\">\n");
      out.write(" \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=no\", target-densitydpi=device-dpi />\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Codystar|Lobster|Londrina+Outline|Lato' rel='stylesheet' type='text/css'>\n");
      out.write("\t<link href=\"public/icons/css/fontello.css\" rel='stylesheet' type=\"text/css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"public/style.css\" />\n");
      out.write("    <title>Venture</title>\n");
      out.write("\n");
      out.write("\t<script>\n");
      out.write("\t\tvar lat;\n");
      out.write("\t\tvar lng;\n");
      out.write("\t\tvar form;\n");
      out.write("\t\t\n");
      out.write("\t\tfunction getLocation() {\n");
      out.write("\t\t \tif (navigator.geolocation) { \n");
      out.write("\t\t\t\tnavigator.geolocation.getCurrentPosition(showPosition);\n");
      out.write("\t\t  \t}\n");
      out.write("\t\t}\n");
      out.write("\t\tfunction showPosition(position) {\n");
      out.write("\t\t\tlat.value = position.coords.latitude;\n");
      out.write("\t\t\tlng.value = position.coords.longitude;\n");
      out.write("\t\t\tform.submit();\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\twindow.onload = function() {\n");
      out.write("\t\t\tlat = document.getElementById(\"latitude\");\n");
      out.write("\t\t\tlng = document.getElementById(\"longitude\");\n");
      out.write("\t\t\tform = document.getElementById(\"form\");\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t\n");
      out.write("\t<div id=\"content-wrapper\">\n");
      out.write("\t\t<div id=\"content\" style=\"\" class=\"container\">\n");
      out.write("\t\t    <span id=\"index\">Venture</span>\n");
      out.write("\t\t    \n");
      out.write("            <div id=\"button-container\">\n");
      out.write("            \t<form action=\"GenerateSuggestionsServlet\" id=\"form\" method=\"post\">\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"latitude\" name=\"latitude\">\t\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"longitude\" name=\"longitude\">\n");
      out.write("\t\t\t\t</form>\t\n");
      out.write("\t\t\t\t<button id=\"main1\" onclick=\"getLocation()\" class=\"btn btn-success btn-lg btn-block\" >Have an adventure</button>\n");
      out.write("            \t<button id=\"main2\" href=\"ShareAdventureServlet\" class=\"btn btn-info btn-lg btn-block\">Share an adventure</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"icon-container\"><span id=\"index\">\n");
      out.write("                <a href=\"about.html\"><span id=\"index\"><i class=\"icon-info\"></i></span></a>\n");
      out.write("                <a href=\"login.html\"><span id=\"index\"><i class=\"icon-user\"></i></span></a>\n");
      out.write("        \t</span></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
