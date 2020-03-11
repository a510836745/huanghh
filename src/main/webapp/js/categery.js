var currentPage = 1;
$(document).ready(function (){
    var cateId={};

   $("[name='changCate']") .click(function (){
       $("#update-cate").modal({
           backdrop:'static'
       });
       $("#categoryName").val($(this).parent().prev().prev().prev().children().text());
       cateId=$(this).parent().prev().children().attr("cateId");
   });

   $("#saveCatename").click(function (){
       var category={};
       category.cateid=cateId;
       category.catename=$("#categoryName").val();
       if(category.catename!= null){
           $.ajax({
               type:"POST",
               url:"/shop/admin/goods/saveCate",
               contentType:"application/x-www-form-urlencoded; charset=utf-8",
               data:category,
               dataType:"json",
               success:function (result){
                   if (result.msg=="名字已经存在")
                   {
                       swal(result.msg);
                   }
                   else {
                       swal(result.msg);
                       $("button").click(function (){
                           location.reload();
                       });
                   }
               },
               error:function (){
                   alert("更新失败");
               }
           });
       }else {
           swal("类别名称不能为空!!!");
       }
   })
    $("[name='upBtn']").click(function (){
        var category={};
        category.cateid=$(this).parent().prev().prev().children().attr("cateId");
        category.state = $("#up").val();
        var cateName = $(this).parent().prev().prev().children().attr("cateName");

        swal({
                title: "确定上架" + cateName + "吗？",
                text:"上架时会同时上架该类商品",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定上架！",
                closeOnConfirm: false,
            },
            function (){
                ok(category);
            });
        })
    $("[name='downBtn']").click(function (){
        var category={};
        category.cateid=$(this).parent().prev().prev().children().attr("cateId");
        category.state =  $("#down").val();
        var cateName = $(this).parent().prev().prev().children().attr("cateName");

        swal({
                title: "确定下架" + cateName + "吗？",
                text:"下架时会同时下架该类商品",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定下架！",
                closeOnConfirm: false,
            },
            function (){
                ok(category);
            });
    })
});
function ok(category){
    $.ajax({
        type: "POST",
        url: "/shop/admin/goods/setCateState",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: category,
        dataType: "json",
        success: function (result) {
            swal(result.msg, "", "success");
            window.location.reload();
        },
        error: function () {
            swal("设置失败");
        },

    });
}
function addCate() {
    //var cateName = $("[id='addName']").val;
    var addCategoryForm = document.getElementById('addCategoryForm');
    var cateName = $('#addName').val();
    if(cateName!=null&&cateName!=''&&cateName!=undefined){
        swal({
                title: "确定添加" + cateName + "吗？",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定！",
                closeOnConfirm: false,
            },
            function (){
                addCategoryForm.submit();
                return true;
            });
    }else {
        swal("类名不能为空");
        return false;
    }
}
