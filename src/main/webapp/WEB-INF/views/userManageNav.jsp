<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/11
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="templatemo-top-nav-container">
    <div class="row">
        <nav class="templatemo-top-nav col-lg-12 col-md-12">
            <ul class="text-uppercase">
                <li><a href="" class="active">所有用户</a></li>
            </ul>
        </nav>
        <form class="navbar-form navbar-right" role="search" method="get" action="${pageContext.request.contextPath}/js/userManage.js">
            <div class="form-group">
                <input type="text" id="userSearch" class="form-control" placeholder="Search" name="keyword">
            </div>
            <button type="submit" class="btn btn-default" id="search">
                <%--                        <span class="glyphicon glyphicon-search" aria-label="搜索"></span>--%>
                <a>搜索</a>
            </button>
        </form>
    </div>
</div>

