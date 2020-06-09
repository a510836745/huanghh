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

        $('#oldPrice').val(oldPrice);
        $('#newPrice').val(newPrice);
        $('#isPay').val(isPay);
        $('#selectAddr').val(selectAddr);

        $('#orderSub').attr('action', '/shop/orderFinish');
        $('#orderSub').submit();

    });
});