/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-12-16 03:13:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	//???????????? ????????????(221216 ??????)
	Calendar c = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //mm(??????) MM(???)
	String today = sdf.format(c.getTime());
	
	//
	request.setCharacterEncoding("utf-8");
	int custno = Integer.parseInt(request.getParameter("custno"));
	
	String sql ="select * from member_tbl_02 where custno=?";
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","ezen");		
		pst = conn.prepareStatement(sql);
		pst.setInt(1,custno);		//???? custno ?????? set
		rs = pst.executeQuery(); 	//select ??? executeQuery()

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Update Page</title>\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<script type=\"text/javascript\" src=\"check.js\"></script>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("<section>\n");
      out.write("<h2>????????? ???????????? ??????</h2>\n");
      out.write("<form action=\"updateProcess.jsp\" method=\"post\" onsubmit=\"return check_form(this)\">\n");
      out.write("		<table>\n");
      out.write("			");
 if(rs.next()){
      out.write("	<!-- ????????? ???????????? ?????? ???????????? ?????? -->\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????(????????????)</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"custno\" value=\"");
      out.print( rs.getInt(1) );
      out.write("\" readonly=\"readonly\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"custname\" value=\"");
      out.print( rs.getString(2) );
      out.write("\" ></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"phone\" value=\"");
      out.print( rs.getString(3) );
      out.write("\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"address\" value=\"");
      out.print( rs.getString(4) );
      out.write("\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"joindate\" value=\"");
      out.print( today );
      out.write("\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????[A:VIP,B:??????,C:??????]</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"grade\" value=\"");
      out.print( rs.getString(6) );
      out.write("\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th><B>????????????</B></th>\n");
      out.write("				<td><input type=\"text\" name=\"city\" value=\"");
      out.print( rs.getString(7) );
      out.write("\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<td colspan=\"2\">\n");
      out.write("				<input type=\"submit\" value=\"??????\">&nbsp;&nbsp;&nbsp;\n");
      out.write("				<input type=\"button\" value=\"??????\" onclick=\"location.href='list.jsp'\">\n");
      out.write("				</td>\n");
      out.write("				\n");
      out.write("			</tr>\n");
      out.write("			");
 } 
      out.write("	 \n");
      out.write("		</table>\n");
      out.write("	\n");
      out.write("	</form>\n");
      out.write("</section>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write('\n');
		
	} catch (Exception e){	
		e.printStackTrace();	
	} finally {
		if(rs!=null) rs.close();
		if(pst!=null) pst.close();
		if(conn!=null) conn.close();
	}
	 
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
