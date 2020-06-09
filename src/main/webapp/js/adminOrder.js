$(document).ready(function (){

    $("[name='confirmRefund']").click(function (){
        var goodsid = $(this).parents("tr").find("td:eq(0)").text();
        var orderid = $(this).parents("[name='parent']").find("[name='ROrderId']").text();
        var refundInfo={};
        refundInfo.orderid = orderid;
        refundInfo.goodsid = goodsid;
        $.ajax({
            type:"POST",
            url:"/shop/admin/order/confirmRefund",
            contentType:"application/x-www-form-urlencoded; charset=utf-8",
            data:refundInfo,
            dataType:"json",
            success:function (result){
                swal("确认退货成功");
                $("button").click(function (){
                    location.reload();
                });
            },
            error:function (){
                swal("确认退货成功");
                $("button").click(function (){
                    location.reload();
                });
            }
        });
    });
});
