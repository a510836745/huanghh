<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/comment.js"></script>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script>

</head>
<body>

<div class="templatemo-flex-row">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <div class="templatemo-content-widget no-padding">
                    <div class="panel panel-default table-responsive">
                        <table id="goodsinfo" class="table  table-bordered templatemo-user-table">
                            <thead>
                            <tr>
                                <td>id</td>
                                <td>用户id</td>
                                <td>用户姓名</td>
                                <td>商品id</td>
                                <td>商品名称</td>
                                <td>星级</td>
                                <td>评论内容</td>
                                <td>评论时间</td>
                                <td>删除</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="comment">
                                <tr>
                                    <td>${comment.commentid}</td>
                                    <td>${comment.userid}</td>
                                    <td>${comment.username}</td>
                                    <td>${comment.goodsid}</td>
                                    <td>${comment.goodsName}</td>
                                    <td>${comment.point}</td>
                                    <td><a class="templatemo-link" commentid="${comment.commentid}">${comment.content}</a></td>
                                    <td>${comment.commenttime}</td>
                                    <td><button href="" class="templatemo-edit-btn" name="deleteComment">删除</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="pagination-wrap" id="page-div-nav">
                <div class="page-info" id="page-info-area">
                    当前第${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共${pageInfo.total}记录
                </div>
                <ul class="pagination">
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/comments/show?page=1" aria-label="Next">
                            <span aria-hidden="true">首页</span>
                        </a>
                    </li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/comments/show?page=${pageInfo.pageNum - 1}" aria-label="Previous">
                                <span aria-hidden="true"><i class="fa fa-backward"></i></span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNums">
                        <c:if test="${pageNums == pageInfo.pageNum}">
                            <li class="active"><a href="${pageContext.request.contextPath}/admin/comments/show?page=${pageNums}">${pageNums}</a></li>
                        </c:if>
                        <c:if test="${pageNums != pageInfo.pageNum}">
                            <li><a href="${pageContext.request.contextPath}/admin/comments/show?page=${pageNums}">${pageNums}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/comments/show?page=${pageInfo.pageNum + 1}" aria-label="Next">
                                <span aria-hidden="true"><i class="fa fa-forward"></i></span>
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/comments/show?page=${pageInfo.pages}" aria-label="Next">
                            <span aria-hidden="true">末页</span>
                        </a>
                    </li>
                </ul>
        </div>
    </div>
</div>

<!-- JS -->
<!-- Templatemo Script -->

<c:if test="${!empty msg}">
    <script type="text/javascript">
        $(document).ready(function () {
            swal('${msg}');
        });

    </script>
</c:if>
</body>
</html>

