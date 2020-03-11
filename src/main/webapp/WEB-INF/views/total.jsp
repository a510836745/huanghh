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
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/templatemo-script.js"></script>
    <script src="https://code.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script src="https://code.highcharts.com.cn/highcharts/modules/exporting.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>


</head>
<body>
<div class="templatemo-flex-row">
    <jsp:include page="sidebar.jsp"></jsp:include>
        <div class="templatemo-content col-1 light-gray-bg">
            <div class="templatemo-top-nav-container">
                <c:forEach items="${totalList}" var="totalList">
                    <input type="hidden"  value="${totalList.catename}" id="val${totalList.cateid}">
                    <input type="hidden"  value="${totalList.saleNum}" id="val1${totalList.cateid}">
                    <input type="hidden"  value="${totalList.cateid}" id="val11${totalList.cateid}">
                </c:forEach>
                <div id="container" style="min-width:300px;height:800px">
                    <script>
                        var res = [];
                            for(var i =0;i<=50;i++){
                                var cateName = $("#val"+i).val();
                                var saleNum = $("#val1"+i).val();
                                var cateId = $("#val11"+i).val();
                                var data = [];
                                if(cateId !== undefined) {
                                    data.push(cateName)
                                    data.push(Number(saleNum))
                                    res.push(data);
                                    data = [];
                                }
                            }

                        var chart = Highcharts.chart('container', {
                            chart: {
                                type: 'column'
                            },
                            title: {
                                text: '泰购乐分类销售统计'
                            },
                            subtitle: {
                                text: '数据截止 2020-03，来源: <a href="https://en.wikipedia.org/wiki/List_of_cities_proper_by_population">Wikipedia</a>'
                            },
                            xAxis: {
                                type: 'category',
                                labels: {
                                    rotation: -45  // 设置轴标签旋转角度
                                }
                            },
                            yAxis: {
                                min: 0,
                                title: {
                                    text: '数量 (件)'
                                }
                            },
                            legend: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '销售总量: <b>{point.y} 件</b>'
                            },
                            series: [{
                                name: '总人口',
                                data: res,
                                dataLabels: {
                                    enabled: true,
                                    rotation: -90,
                                    color: '#FFFFFF',
                                    align: 'right',
                                    format: '{point.y}',
                                    y: 100
                                }
                            }]
                        });
                    </script>
                </div>
            </div>
        </div>
</div>
</body>
</html>

