
$.validator.setDefaults({
	submitHandler: function() {
		form.submit();
	}
});
//手机号码验证
jQuery.validator.addMethod("isMobile", function(value, element) {
	var length = value.length;
	var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
	return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写手机号码");

$(document).ready(function() {
	$('#form').validate({
		rules: {
			username: "required",
            telephone: {
				required: true,
				minlength: 11,
				isMobile: true,
			},
            email: {
				required: true,
				email: true,
			},
            password: {
				required: true,
				minlength: 8,
			},
			confirmPassword: {
				required: true,
				minlength: 8,
				equalTo: "#password",
			}
		},
		messages: {
            username: "用户名不能为空",
            telephone: {
            	required: "联系电话不能为空",
				minlength: "电话号码不能小于11位",
				isMobile: "请输入一个正确的联系电话",
			},
            email: {
				required: "邮箱输入不能为空",
				email: "请输入一个正确的邮箱",
			},
            password: {
				required: "密码输入不能为空",
				minlength: "密码长度不能小于8位",
			},
			confirmPassword: {
				required: "输入不能为空",
				minlength: "密码长度不能小于8位",
				equalTo: "两次密码输入不一致",
			}
		}
	});
});