/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-10-27 12:47:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>容灾管理系统</title>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/logo1.ico\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"fixed-sidebar full-height-layout gray-bg\" style=\"overflow:hidden\">\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<!--左侧导航开始-->\r\n");
      out.write("        <nav class=\"navbar-default navbar-static-side\" role=\"navigation\">\r\n");
      out.write("            <div class=\"nav-close\"><i class=\"fa fa-times-circle\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"sidebar-collapse\">\r\n");
      out.write("                <ul class=\"nav\" id=\"side-menu\">\r\n");
      out.write("                    <li class=\"nav-header\">\r\n");
      out.write("                         <div class=\"dropdown profile-element\">\r\n");
      out.write("                            <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">\r\n");
      out.write("                                <span class=\"clear\">\r\n");
      out.write("                                <span class=\"block m-t-xs\"><strong class=\"font-bold\">");
      if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_page_context))
        return;
      out.write("</strong></span>\r\n");
      out.write("                               \t<span class=\"text-muted text-xs block\">角色<b class=\"caret\"></b></span>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <ul class=\"dropdown-menu animated fadeInRight m-t-xs\">\r\n");
      out.write("                            \t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            \t<li class=\"divider\"></li>\r\n");
      out.write("                                <li><a class=\"J_menuItem\" href=\"#\">修改密码</a></li>\r\n");
      out.write("                                <li><a href=\"logout\">安全退出</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a class=\"J_menuItem\" href=\"home\" data-index=\"0\"><i class=\"fa fa-home\"></i> <span class=\"nav-label\">主页</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                <!--     <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <i class=\"fa fa-automobile\"></i>\r\n");
      out.write("                            <span class=\"nav-label\">定时任务</span>\r\n");
      out.write("                            <span class=\"fa arrow\"></span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul class=\"nav nav-second-level\">\r\n");
      out.write("                        \t<li><a class=\"J_menuItem\" href=\"schedule/job/index\">任务管理</a></li>\r\n");
      out.write("                        \t<li><a class=\"J_menuItem\" href=\"schedule/joblog/index\">任务日志</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <i class=\"fa fa-automobile\"></i>\r\n");
      out.write("                            <span class=\"nav-label\">系统配置</span>\r\n");
      out.write("                            <span class=\"fa arrow\"></span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <ul class=\"nav nav-second-level\">\r\n");
      out.write("                            <li><a class=\"J_menuItem\" href=\"sys/user/index\">用户管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"sys/role/index\">角色管理</a></li>\r\n");
      out.write("                            <li><a class=\"J_menuItem\" href=\"sys/menu/index\">菜单管理</a></li>\r\n");
      out.write("                            <li><a class=\"J_menuItem\" href=\"sys/config/index\">参数管理</a></li>\r\n");
      out.write("                            <li><a class=\"J_menuItem\" href=\"#\">SQL监控</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"#\">组织管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"#\">系统日志</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"#\">代码生成器</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("\t\t\t\t        <a href=\"#\"> \r\n");
      out.write("\t\t\t\t          <i class=\"fa fa fa-bar-chart-o\"></i> \r\n");
      out.write("\t\t\t\t          <span class=\"nav-label\">测试管理</span> <span class=\"fa arrow\"></span>\r\n");
      out.write("\t\t\t\t\t    </a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"nav nav-second-level\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"report?method=list\">运营统计报表</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"report?method=list_daily\">运营统计日报表</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"report?method=list_detail\">运营统计详单</a></li>\r\n");
      out.write("\t\t\t\t\t   </ul>\r\n");
      out.write("\t\t\t\t  </li> -->\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  <menu-item v-for=\"item in menu\" v-bind:item=\"item\"></menu-item>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!--左侧导航结束-->\r\n");
      out.write("        <!--右侧部分开始-->\r\n");
      out.write("        <div id=\"page-wrapper\" class=\"gray-bg dashbard-1\">\r\n");
      out.write("        \t<div class=\"row border-bottom\">\r\n");
      out.write("                <nav class=\"navbar navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\r\n");
      out.write("                    <div class=\"navbar-header\"><a class=\"navbar-minimalize minimalize-styl-2 btn btn-primary \" href=\"#\"><i class=\"fa fa-bars\"></i> </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <ul class=\"nav navbar-top-links navbar-right\">\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                                <i class=\"fa fa-bell\"></i> <span class=\"label label-primary\">8</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-alerts\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"mailbox.html\">\r\n");
      out.write("                                        <div>\r\n");
      out.write("                                            <i class=\"fa fa-envelope fa-fw\"></i> 您有16条未读消息\r\n");
      out.write("                                            <span class=\"pull-right text-muted small\">4分钟前</span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"divider\"></li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"profile.html\">\r\n");
      out.write("                                        <div>\r\n");
      out.write("                                            <i class=\"fa fa-qq fa-fw\"></i> 3条新回复\r\n");
      out.write("                                            <span class=\"pull-right text-muted small\">12分钟钱</span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"divider\"></li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <div class=\"text-center link-block\">\r\n");
      out.write("                                        <a class=\"J_menuItem\" href=\"notifications.html\">\r\n");
      out.write("                                            <strong>查看所有 </strong>\r\n");
      out.write("                                            <i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"dropdown hidden-xs\">\r\n");
      out.write("                            <a class=\"right-sidebar-toggle\" aria-expanded=\"false\">\r\n");
      out.write("                                <i class=\"fa fa-tasks\"></i> 主题\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        \t<div class=\"row content-tabs\">\r\n");
      out.write("                <button class=\"roll-nav roll-left J_tabLeft\"><i class=\"fa fa-backward\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <nav class=\"page-tabs J_menuTabs\">\r\n");
      out.write("                    <div class=\"page-tabs-content\">\r\n");
      out.write("                        <a href=\"javascript:;\" class=\"active J_menuTab\" data-id=\"home\">首页</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <button class=\"roll-nav roll-right J_tabRight\"><i class=\"fa fa-forward\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <div class=\"btn-group roll-nav roll-right\">\r\n");
      out.write("                    <button class=\"dropdown J_tabClose\" data-toggle=\"dropdown\">关闭操作<span class=\"caret\"></span>\r\n");
      out.write("\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <ul role=\"menu\" class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                        <li class=\"J_tabCloseAll\"><a>关闭全部选项卡</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"divider\"></li>\r\n");
      out.write("                        <li class=\"J_tabCloseOther\"><a>关闭其他选项卡</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <a href=\"logout\" class=\"roll-nav roll-right J_tabExit\"><i class=\"fa fa fa-sign-out\"></i> 退出</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        \t<div class=\"row J_mainContent\" id=\"content-main\">\r\n");
      out.write("                <iframe class=\"J_iframe\" name=\"iframe0\" width=\"100%\" height=\"100%\" src=\"home\" frameborder=\"0\" data-id=\"home\" seamless></iframe>\r\n");
      out.write("            </div>\r\n");
      out.write("        \t<div class=\"footer\">\r\n");
      out.write("                <div class=\"pull-right\">&copy; 2017-2099 <a href=\"http://www.gp1701.com/\" target=\"_blank\">GP1701</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--右侧部分结束-->\r\n");
      out.write("        \r\n");
      out.write("        <!--右侧边栏开始-->\r\n");
      out.write("        <div id=\"right-sidebar\">\r\n");
      out.write("            <div class=\"sidebar-container\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"tab-content\">\r\n");
      out.write("                    <div id=\"tab-1\" class=\"tab-pane active\">\r\n");
      out.write("                        <div class=\"sidebar-title\">\r\n");
      out.write("                            <h3> <i class=\"fa fa-comments-o\"></i> 主题设置</h3>\r\n");
      out.write("                            <small><i class=\"fa fa-tim\"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"skin-setttings\">\r\n");
      out.write("                            <div class=\"title\">主题设置</div>\r\n");
      out.write("                            <div class=\"setings-item\">\r\n");
      out.write("                                <span>收起左侧菜单</span>\r\n");
      out.write("                                <div class=\"switch\">\r\n");
      out.write("                                    <div class=\"onoffswitch\">\r\n");
      out.write("                                        <input type=\"checkbox\" name=\"collapsemenu\" class=\"onoffswitch-checkbox\" id=\"collapsemenu\">\r\n");
      out.write("                                        <label class=\"onoffswitch-label\" for=\"collapsemenu\">\r\n");
      out.write("                                            <span class=\"onoffswitch-inner\"></span>\r\n");
      out.write("                                            <span class=\"onoffswitch-switch\"></span>\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"setings-item\">\r\n");
      out.write("                                <span>固定顶部</span>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"switch\">\r\n");
      out.write("                                    <div class=\"onoffswitch\">\r\n");
      out.write("                                        <input type=\"checkbox\" name=\"fixednavbar\" class=\"onoffswitch-checkbox\" id=\"fixednavbar\">\r\n");
      out.write("                                        <label class=\"onoffswitch-label\" for=\"fixednavbar\">\r\n");
      out.write("                                            <span class=\"onoffswitch-inner\"></span>\r\n");
      out.write("                                            <span class=\"onoffswitch-switch\"></span>\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"setings-item\">\r\n");
      out.write("                                <span>固定宽度 </span>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"switch\">\r\n");
      out.write("                                    <div class=\"onoffswitch\">\r\n");
      out.write("                                        <input type=\"checkbox\" name=\"boxedlayout\" class=\"onoffswitch-checkbox\" id=\"boxedlayout\">\r\n");
      out.write("                                        <label class=\"onoffswitch-label\" for=\"boxedlayout\">\r\n");
      out.write("                                            <span class=\"onoffswitch-inner\"></span>\r\n");
      out.write("                                            <span class=\"onoffswitch-switch\"></span>\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"title\">皮肤选择</div>\r\n");
      out.write("                            <div class=\"setings-item default-skin nb\">\r\n");
      out.write("                                <span class=\"skin-name \">\r\n");
      out.write("                         \t\t\t<a href=\"#\" class=\"s-skin-0\">默认皮肤</a>\r\n");
      out.write("                    \t\t\t</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"setings-item blue-skin nb\">\r\n");
      out.write("                                <span class=\"skin-name \">\r\n");
      out.write("                        \t\t\t<a href=\"#\" class=\"s-skin-1\">蓝色主题</a>\r\n");
      out.write("                    \t\t\t</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"setings-item yellow-skin nb\">\r\n");
      out.write("                                <span class=\"skin-name \">\r\n");
      out.write("                        \t\t\t<a href=\"#\" class=\"s-skin-3\">黄色主题</a>\r\n");
      out.write("                    \t\t\t</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                   \r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t<!--右侧边栏结束-->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 全局js -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- vue -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/vue.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- fastjson -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/FastJson-1.0.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("\t<!--导航-->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/metisMenu/jquery.metisMenu.js\"></script>\r\n");
      out.write("    <!--滚动条-->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/slimscroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("\t<!--浮层-->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/layer/layer.min.js\"></script>\r\n");
      out.write("\t<!--进度条 -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/pace/pace.min.js\"></script>\r\n");
      out.write("\t<!-- 自定义js -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/script/hplus.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/script/contabs.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/script/modules/index.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_shiro_005fprincipal_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent(null);
    // /WEB-INF/jsp/index.jsp(32,85) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fprincipal_005f0.setProperty("userName");
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/index.jsp(37,29) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/index.jsp(37,29) '${sessionScope.roles}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${sessionScope.roles}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/index.jsp(37,29) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("role");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            \t\t<li><a href=\"#\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${role}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</a></li>\r\n");
          out.write("                            \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}