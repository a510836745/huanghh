var currentPage = 1;
$(document).ready(function (){
    var commentId={};

    $("[name='deleteComment']").click(function (){
        var comment={};
        comment.commentid=$(this).parent().prev().prev().children().attr("commentid");
        //comment.commentid = 6;
        swal({
                title: "确定删除该条评论吗？",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定删除！",
                closeOnConfirm: false,
            },
            function (){
                ok(comment);
            });
    });
});
function ok(comment){
    $.ajax({
        type: "POST",
        url: "/shop/admin/comments/delete",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: comment,
        dataType: "json",
        success: function (result) {
            swal(result.msg, "", "success");
            window.location.reload();
        },
        error: function () {
            swal("删除失败");
        },

    });
}