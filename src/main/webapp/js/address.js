$(document).ready(function (){
    var addresId;
    $("[name='changeAddr']").click(function (){
        $("#update-addr").modal({
            backdrop:'static'
        });

        $("#name").val($(this).parents("#parent").find("#conname").text());
        $("#telephone").val($(this).parents("#parent").find("#contel").text());
        $("#detailaddress").val($(this).parents("#parent").find("#detailaddr").text());
         addresId=$(this).parents("#parent").find("#table").attr("address-id");

    });


    $("#saveAddr").click(function (){
        var saveAddr={};

        var province=$("#provinceUpdate").val();
        var city=$("#cityUpdate").val();
        var county=$("#countyUpdate").val();
        var detailaddr=$("#detailaddress").val();
        var conname=$("#name").val();
        var contel=$("#telephone").val();

        saveAddr.addressid=addresId;
         saveAddr.province=province;
         saveAddr.city=city;
         saveAddr.county=county;
         saveAddr.detailaddr=detailaddr;
         saveAddr.conname=conname;
         saveAddr.contel=contel;
    if(province != "" && city != "" && county != "" && detailaddr != "" && conname != "" && contel != "") {
        $.ajax({
            type: "POST",
            url: "/shop/saveAddr",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: saveAddr,
            dateType: "json",
            success: function (result) {
                if (result.msg == "更新失败") {
                    swal(result.msg);
                } else {
                    $("#update-info").modal('hide');
                    swal("修改成功", "", "success");
                    $("button").click(function () {
                        location.reload();
                    });
                }
            },
            error: function () {
                alert("更新失败");
            }
        });
        }else {
        swal("修改地址信息不完整!");
    }
    });

    $("[name='deleteAddr']").click(function (){
        addresId=$(this).parents("#parent").find("#table").attr("address-id");
        var address={};
        address.addressid=addresId;
        $.ajax({
            type: "POST",
            url: "/shop/deleteAddr",
            contentType:"application/x-www-form-urlencoded; charset=utf-8",
            data:address,
            dateType:"json",
            success:function (result){
                swal(result.msg);
                $("button").click(function (){
                    location.reload();
                });
            },
            error:function (){
                alert("删除失败");
            }
            });
    });

    $("[name='insertAddr']").click(function () {
        $("#insert-addr").modal({
            backdrop:'static'
        });
    });

    $("#insertAddr").click(function (){
        var insertAddr={};

        var province=$("#provinceInsert").val();
        var city=$("#cityInsert").val();
        var county=$("#countyInsert").val();
        var detailaddr=$("#detailaddressInsert").val();
        var conname=$("#nameInsert").val();
        var contel=$("#telephoneInsert").val();


       insertAddr.province=province;
       insertAddr.city=city;
        insertAddr.county=county;
        insertAddr.detailaddr=detailaddr;
        insertAddr.conname=conname;
       insertAddr.contel=contel;
        if(province != "" && city != "" && county != "" && detailaddr != "" && conname != "" && contel != "") {
            $.ajax({
                type:"POST",
                url:"/shop/insertAddr",
                contentType:"application/x-www-form-urlencoded; charset=utf-8",
                data:insertAddr,
                dataType:"json",
                success:function (result){
                    swal(result.msg);
                    $("button").click(function (){
                        location.reload();
                    });
                },
                error:function (){
                    alert("添加失败");
                }
            });
        }else {
            swal("新增地址信息不完整!");
        }

    });
});