var activity = [];
var currentPage = 1;
$(document).ready(function () {

    var path = $("#path").text();


    to_page(path, 1);

});


$(document).on("click",".description",function () {
    $(this).popover();
});

$(document).on("click",".templatemo-edit-btn",function () {
    $("#update-goods").modal({
        backdrop:'static'
    });

    //获取当前点击商品的数据
    var upGoodsid = $(this).parents("tr").find("td:eq(0)").text();
    var upGoodsname = $(this).parents("tr").find("td:eq(1)").text();
    var upGoodsPrice = $(this).parents("tr").find("td:eq(2)").text();
    var upGoodsNum = $(this).parents("tr").find("td:eq(3)").text();
    var upGoodsDes = $(this).parents("tr").find(".description").attr("data-content");

    $("#goodsid").text(upGoodsid);
    $("#goodsname").val(upGoodsname);
    $("#price").val(upGoodsPrice);
    $("#num").val(upGoodsNum);
    $("#description").val(upGoodsDes);
});

//修改商品信息
$(document).on("click","#saveUpdate",function () {
    var ugoodsid = $("#goodsid").text();
    var ugoodsname = $("#goodsname").val();
    var uprice = $("#price").val();
    var unum = $("#num").val();
    var udescription = $("#description").val();
    var ucategory = $("#category").val();
    if(ugoodsid!=''&&ugoodsname!=''&&uprice!=''&&unum!=''&&ucategory!=''){
        $.ajax({
            url:"/shop/admin/goods/update/",
            type:"POST",
            data:{
                goodsid:ugoodsid,
                goodsname:ugoodsname,
                price:uprice,
                num:unum,
                description:udescription,
                category:ucategory,
            },
            success:function(result){
                $("#update-goods").modal('hide');
                swal(result.msg,'','success');
                to_page('/shop',currentPage);
            },
            error:function(){
                alert("错误！！");
            }
        });
    }else {
        swal("修改数据不完整,无法修改")
    }
});

$(document).on("click",".templatemo-delete-btn",function () {
    var goodsname = $(this).parents("tr").find("td:eq(1)").text();
    var goodsid = $(this).parents("tr").find("td:eq(0)").text();
    var state = $(this).parents("tr").find("td:eq(6)").text();
    var btnState = "0";
    if(state == "已上架" ) {
        swal({
                title: "确定下架" + goodsname + "吗？",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定下架！",
                closeOnConfirm: false,
            },
            function () {
                /*swal("删除！", "你的虚拟文件已经被删除。", "success");*/
                $.ajax({
                    url: "/shop/admin/goods/delete/" + goodsid + "/"+btnState,
                    type: "DELETE",
                    success: function (result) {
                        swal(result.msg, "", "success");
                        to_page('/shop', currentPage);
                    },
                    error: function () {
                        to_page('/shop', currentPage);
                    }
                });
            });
    }else{
        swal("请勿重复下架");
    }
});
$(document).on("click",".templatemo-up-btn",function () {
    var goodsname = $(this).parents("tr").find("td:eq(1)").text();
    var goodsid = $(this).parents("tr").find("td:eq(0)").text();
    var state = $(this).parents("tr").find("td:eq(6)").text();
    var btnState = "1";
    if(state == "已下架") {
        swal({
                title: "确定上架" + goodsname + "吗？",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定上架！",
                closeOnConfirm: false,
            },
            function () {
                /*swal("删除！", "你的虚拟文件已经被删除。", "success");*/
                $.ajax({
                    url: "/shop/admin/goods/delete/" + goodsid + "/"+btnState,
                    type: "DELETE",
                    success: function (result) {
                        swal(result.msg, "", "success");
                        to_page('/shop', currentPage);
                    },
                    error: function () {
                        to_page('/shop', currentPage);
                    }
                });
            });
    }else{
        swal("请勿重复上架");
    }
});
function addGoods() {
    var addGoodsForm = document.getElementById('addGoodsForm');
    var addName = $("input[name='goodsname']").val();
    var addPrice = $("input[name='price']").val();
    var addNum = $("input[name='num']").val();
    var addDescription = $("input[name='description']").val();
    if(addName!=''&&addPrice!=''&&addNum!=''&& addDescription!=''){
        swal({
                title: "确定添加" + addName + "吗？",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定！",
                closeOnConfirm: false,
            },
            function (){
                addGoodsForm.submit();
                return true;
            });
        }else {
        swal("商品信息不完整,添加失败")
    }
}
function addActivity() {
    var addActivityForm = document.getElementById('addActivityForm');
    var activityName = $("input[name='activityname']").val();
    var discount = $("input[name='discount']").val();
    var fullprice = $("input[name='fullprice']").val();
    var reduceprice = $("input[name='reduceprice']").val();
    var fullnum = $("input[name='fullnum']").val();
    var reducenum = $("input[name='reducenum']").val();
    if(activityName!=''&&discount!=''&&fullprice!=''&&reduceprice!=''&&fullnum!=''&&reducenum!=''){
        if(discount > 1 || discount <= 0){
            swal("折扣输入错误,添加失败")
        }else if(reduceprice>fullprice){
            swal("满减金额大于满减标准金额,添加失败")
        }else if(reducenum>fullnum){
            swal("满免数量大于满免标准数量,添加失败")
        } else {
        swal({
                title: "确定添加" + activityName + "吗？",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定！",
                closeOnConfirm: false,
            },
            function (){
                addActivityForm.submit();
                swal("活动添加成功")
                return true;
            });
        }
    }else {
        swal("活动信息不完整,添加失败")
    }
}
/*$(document).on("click",".templatemo-activity-btn",function () {
    var goodsid = $(this).parents("tr").find("td:eq(0)").text();

});*/

function showActInfo(activityNum) {
    $('#activityname').text(activity[activityNum].activityname);
    $('#activitydes').text(activity[activityNum].activitydes);
    $('#discount').text(activity[activityNum].discount);
    $('#fullprice').text(activity[activityNum].fullprice);
    $('#reduceprice').text(activity[activityNum].reduceprice);
    $('#fullnum').text(activity[activityNum].fullnum);
    $('#reducenum').text(activity[activityNum].reducenum);
}

$("#activity-id").change(function () {
    showActInfo($(this).find("option:selected").text());

});

function getActivity() {
    $.ajax({
        url: "/shop/admin/activity/showjson",
        type: "post",
        success: function (result) {
            if(result.code==100) {
                $("#activity-id").empty();
                activity = result.info.activity;
                $.each(activity, function (index,item) {
                    $("#activity-id").append($("<option></option>").attr("value",item.activityid).append(index));
                });
                showActInfo(1);
            } else {
                alert("获取活动信息失败");
            }
        }
    });
}

//保存活动信息
$(document).on("click","#saveActivity",function () {
    var goodsid = $("#activity-goodsid").text();
    var activityid = $("#activity-id").val();

    $.ajax({
        url:"/shop/admin/activity/update/",
        type:"POST",
        data:{
            goodsid:goodsid,
            activityid:activityid
        },
        success:function(result){
            $("#activity-goods").modal('hide');
            swal(result.msg,'','success');
            to_page('/shop', currentPage);
        },
        error:function(){
            alert("错误！！");
        }
    });
});

function to_page(path, page) {
    $.ajax({
        url: path + "/admin/goods/showjson",
        data: "page=" + page,
        type: "get",
        success: function (result) {

            //解析显示
            build_goods_table(path, result);

            //页面信息
            build_page_info(path, result);

            //分页
            build_page_nav(path, result);

            currentPage = page;
        }
    });
}

function build_goods_table(path,result) {
    $("#goodsinfo tbody").empty();
    var goods = result.info.pageInfo.list;
    $.each(goods, function (index,item) {
        var goodsid = $("<td></td>").append(item.goodsid);
        var goodsname = $("<td></td>").append(item.goodsname);
        var price = $("<td></td>").append(item.price);
        var num = $("<td></td>").append(item.num);
        var category = $("<td></td>").append(item.cateName);
        var activityid = $("<td></td>").append(item.activityid);

        var state = null;
            if(item.state==1){
                state = $("<td></td>").append("已上架");
            }
            if(item.state==0){
                state = $("<td></td>").append("已下架");
            }


        // var detailA = $('<a tabindex="0" class="btn btn-sm description" role="button" placement="top" data-toggle="popover" data-trigger="focus" title="描述" ></a>').append("描述");
        var detailBtn = $('<button type="button" class="description" data-container="body" data-toggle="popover" data-placement="top"></button>').append("描述");

        detailBtn = detailBtn.attr("data-content",item.description);

        var detailA = $("<a></a>").addClass("templatemo-link").attr("href","/shop/detail?goodsid="+item.goodsid).append("详情");

        var editBtn = $("<button></button>").addClass("templatemo-edit-btn").append("编辑");
        var deleteBtn = $("<button></button>").addClass("templatemo-delete-btn").append("下架");
        var upBtn = $("<button></button>").addClass("templatemo-up-btn").append("上架");

        var desTd = $("<td hidden></td>").append(detailBtn);

        //活动按钮
        var actBtn = $("<button></button>").addClass("templatemo-activity-btn").attr("data-actGoodsid",item.goodsid).append("添加");
        actBtn.click(function () {
            $("#activity-goods").modal({
                backdrop:'static'
            });
            $("#activity-goodsid").text($(this).attr("data-actGoodsid"));
            getActivity();
        });

        var actTd = $("<td></td>").append(actBtn);

        var detailTd = $("<td></td>").append(detailA);
        var editTd = $("<td></td>").append(editBtn);
        var setTd = null;
        if(item.state == 1){
            setTd = $("<td></td>").append(deleteBtn);
        }else {
            setTd = $("<td></td>").append(upBtn);
        }
        $("<td></td>").append();
        $("<tr></tr>").append(goodsid).append(goodsname).append(price).append(num).append(category).append(activityid).append(state).append(desTd).append(detailTd).append(editTd).append(setTd).append(actTd).appendTo("#goodsinfo tbody");
    })
}

function build_page_info(path,result) {
    $("#page-info-area").empty();
    $("#page-info-area").append("当前第"+ result.info.pageInfo.pageNum +"页，总共"+ result.info.pageInfo.pages +"页，总共"+ result.info.pageInfo.total +"记录")
}

function build_page_nav(path,result) {
    $("#page-div-nav ul").empty();
    var pageUl = $("<ul></ul>").addClass("pagination")

    var firstPage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"></span>")
            .append("首页")));

    var prePage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"><i class=\"fa fa-backward\"></i></span>")));

    if(!result.info.pageInfo.hasPreviousPage) {
        prePage.addClass("li-none");
    } else {
        prePage.click(function () {
            to_page('/shop',result.info.pageInfo.prePage);
        });
    }

    //跳转
    firstPage.click(function () {
        to_page('/shop',1);
    });

    var nextPage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"><i class=\"fa fa-forward\"></i></span>")));

    var lastPage = $("<li></li>").append($("<a aria-label=\"Next\"></a>")
        .append($("<span aria-hidden=\"true\"></span>")
            .append("末页")));

    if(!result.info.pageInfo.hasNextPage) {
        nextPage.addClass("li-none");
    } else {
        nextPage.click(function () {
            to_page('/shop',result.info.pageInfo.nextPage);
        });
    }

    lastPage.click(function () {
        to_page('/shop',result.info.pageInfo.lastPage);
    });

    pageUl.append(firstPage).append(prePage);

    $.each(result.info.pageInfo.navigatepageNums,function (index,item) {
        var numLi = $("<li></li>").append($("<a></a>")
            .append($("<span aria-hidden=\"true\"></span>").append(item)));
        if(result.info.pageInfo.pageNum === item) {
            numLi.addClass("active");
        }
        numLi.click(function () {
            to_page('/shop',item);
        });
        pageUl.append(numLi);
    });

    pageUl.append(nextPage).append(lastPage).appendTo("#page-div-nav");
}

