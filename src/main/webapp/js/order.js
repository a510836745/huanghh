$(document).ready(function () {
    $("#confirm-orders").click(function () {
        // alert("safd");
        var selectAddr =  $('input:radio[name="addressid"]:checked').val();
        if(selectAddr == null) {
            swal("请先添加地址");
            return;
        }
        var isPay = $('#pay-select').val();
        var oldPrice = $('#total-old').text();
        var newPrice = $('#total-new').text();
        var userid = $('#user').val();
        $.ajax({
            url: "/shop/orderFinish",
            //url: "/shop/alipay/pay",
            type: "POST",
            data: {
                oldPrice: oldPrice,
                newPrice: newPrice,
                isPay: isPay,
                addressid: selectAddr
            },
            success: function () {
                swal("购买成功", "", "success");
                location.href = "/shop/goPay?userid="+userid;
            },
            error: function () {
                swal("购买失败，无法连接到服务器！");
            }
        });
    });
});