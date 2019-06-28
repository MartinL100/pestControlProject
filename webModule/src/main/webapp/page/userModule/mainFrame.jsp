<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <base href="<%=basePath%>">
  <jsp:include page="../../head.jsp"></jsp:include>
  <title>森林病虫害防治系统</title>
</head>
<body class="layui-layout-body">

  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">


      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" lay-href="home/console.html">
            <span>森林病虫害防治系统</span>
          </div>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
<c:forEach var="menuObj" items="${menuVOList}">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">

                <cite>${menuObj.firstMenu.powerName}</cite>
              </a>
              <dl class="layui-nav-child">
<<<<<<< HEAD
                <dd data-name="console" class="layui-this">
                  <a href="../drugModule/outwarehouseUpdate.html" target="frameName">虫害一览</a>
                </dd>
                <dd data-name="console">
                  <a href="../drugModule/drugPanel.html" target="frameName">病害一览</a>
                </dd>
                <dd data-name="console">
                  <a href="userPanel.html" target="frameName">鼠害一览</a>
                </dd>
              </dl>
            </li>

            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">

                <cite>灾情防治</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" class="layui-this">
                  <a href="../drugModule/outwarehouseUpdate.html" target="frameName">区域一览</a>
                </dd>
                <dd data-name="console">
                  <a href="../drugModule/drugPanel.html" target="frameName">小班管理</a>
                </dd>
                <dd data-name="console">
                  <a href="../drugModule/drugPanel.html" target="frameName">事件记录</a>
                </dd>
              </dl>
            </li>


            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">

                <cite>专家会商</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" class="layui-this">
                  <a href="../drugModule/outwarehouseUpdate.html" target="frameName">专家一览</a>
                </dd>
                <dd data-name="console">
                  <a href="../drugModule/drugPanel.html" target="frameName">会商灾情</a>
                </dd>
              </dl>
            </li>


            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">

                <cite>药剂器械出库管理</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" class="layui-this">
                  <a href="drugPanelPageServlet.lovo" target="frameName">药剂器械管理</a>
                </dd>

                <dd data-name="console">
                  <a href="outwarehousePanelServlet.lovo" target="frameName">出库管理</a>
                </dd>
              </dl>
            </li>

            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">

                <cite>系统信息</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" class="layui-this">
                  <a href="findUserServlet" target="frameName">用户管理</a>
                </dd>
=======
<%--                <dd data-name="console" class="layui-this">--%>
<%--                  <a href="../drugModule/outwarehouseUpdate.html" target="frameName">虫害一览</a>--%>
<%--                </dd>--%>
<%--                <dd data-name="console">--%>
<%--                  <a href="../drugModule/drugPanel.html" target="frameName">病害一览</a>--%>
<%--                </dd>--%>
  <c:forEach items="${menuObj.secendMenu}" var="secendMenuObj">
>>>>>>> origin/master
                <dd data-name="console">
                  <a href="${secendMenuObj.powerResource}" target="frameName">${secendMenuObj.powerName}</a>
                </dd>
  </c:forEach>
              </dl>
            </li>
</c:forEach>
<%--            <li data-name="home" class="layui-nav-item layui-nav-itemed">--%>
<%--              <a href="javascript:;" lay-tips="主页" lay-direction="2">--%>

<%--                <cite>灾情防治</cite>--%>
<%--              </a>--%>
<%--              <dl class="layui-nav-child">--%>
<%--                <dd data-name="console" class="layui-this">--%>
<%--                  <a href="findAreaServlet" target="frameName">区域一览</a>--%>
<%--                </dd>--%>
<%--                <dd data-name="console">--%>
<%--                  <a href="findClassServlet" target="frameName">小班管理</a>--%>
<%--                </dd>--%>
<%--                <dd data-name="console">--%>
<%--                  <a href="../drugModule/drugPanel.html" target="frameName">事件记录</a>--%>
<%--                </dd>--%>
<%--              </dl>--%>
<%--            </li>--%>


<%--            <li data-name="home" class="layui-nav-item layui-nav-itemed">--%>
<%--              <a href="javascript:;" lay-tips="主页" lay-direction="2">--%>

<%--                <cite>专家会商</cite>--%>
<%--              </a>--%>
<%--              <dl class="layui-nav-child">--%>
<%--                <dd data-name="console" class="layui-this">--%>
<%--                  <a href="specialistMain" target="frameName">专家一览</a>--%>
<%--                </dd>--%>
<%--                <dd data-name="console">--%>
<%--                  <a href="conferenceEvent" target="frameName">会商灾情</a>--%>
<%--                </dd>--%>
<%--              </dl>--%>
<%--            </li>--%>


<%--            <li data-name="home" class="layui-nav-item layui-nav-itemed">--%>
<%--              <a href="javascript:;" lay-tips="主页" lay-direction="2">--%>

<%--                <cite>药剂器械出库管理</cite>--%>
<%--              </a>--%>
<%--              <dl class="layui-nav-child">--%>
<%--                <dd data-name="console" class="layui-this">--%>
<%--                  <a href="../drugModule/outwarehouseUpdate.html" target="frameName">药剂器械管理</a>--%>
<%--                </dd>--%>
<%--                <dd data-name="console">--%>
<%--                  <a href="../drugModule/drugPanel.html" target="frameName">出库管理</a>--%>
<%--                </dd>--%>
<%--              </dl>--%>
<%--            </li>--%>

<%--            <li data-name="home" class="layui-nav-item layui-nav-itemed">--%>
<%--              <a href="javascript:;" lay-tips="主页" lay-direction="2">--%>

<%--                <cite>系统信息</cite>--%>
<%--              </a>--%>
<%--              <dl class="layui-nav-child">--%>
<%--                <dd data-name="console" class="layui-this">--%>
<%--                  <a href="findUserServlet" target="frameName">用户管理</a>--%>
<%--                </dd>--%>
<%--                <dd data-name="console">--%>
<%--                  <a href="recordLogsServlet" target="frameName">日志一览</a>--%>
<%--                </dd>--%>
<%--              </dl>--%>
<%--            </li>--%>
          </ul>
        </div>
      </div>




      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body" style="margin-top: -100px">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="" frameborder="0" class="layadmin-iframe" name="frameName"></iframe>
        </div>
      </div>

      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>


  <script>
  layui.config({
    base: 'layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use('index');
  </script>
</body>
</html>


