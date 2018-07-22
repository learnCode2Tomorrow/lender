
$(function() {
	//账号验证
	$("#userAccount").bind({
		"focus":function(){
			$("label[for='errorTip']").html("");
			$("label[for='inputAccount']").html("");
			$("label[for='inputPassword']").html("");
			$("#userAccount").css({'border':'1px solid #ced4da'});
		}/*,
		"blur":function(){
			if(!$("#userAccount").val()){
				$("label[for='inputAccount']").html("<span style='color:red;'>账号或手机号不能为空</span>")
			}else{
				if(!/^[1][3,4,5,7,8][0-9]{9}$/.test($("#userAccount").val())){
					$("#userAccount").css({'border':'1px solid red'});
					$("label[for='inputAccount']").html("<span style='color:red;'>账号有误,请重新输入</span>")
					return true;
				}else{
					$("#userAccount").css({'border':'1px solid #ced4da'});
					return false;
				}
			}
		}*/
	})
	
	//密码验证
	$("#userPassword").bind({
		"focus":function(){
			$("label[for='errorTip']").html("");
			$("label[for='inputPassword']").html("");
			$("#userPassword").css({'border':'1px solid #ced4da'});
		}/*,
		"blur":function(){
			if(!$("#userPassword").val()){
				$("label[for='inputPassword']").html("<span style='color:red;'>密码不能为空</span>")
			}else{
				if(!/^\d{6}$/.test($("#userPassword").val())){
					$("#userPassword").css({'border':'1px solid red'});
					$("label[for='inputPassword']").html("<span style='color:red;'>密码有误,请重新输入</span>")
					return true;
				}else{
					$("#userPassword").css({'border':'1px solid #ced4da'});
					return false;
				}
			}
		}*/
	})
	
	//验证码验证
	$("#valiCode").on("focus",function(){
			$("label[for='errorTip']").html("");
	})
	
	//验证通过发送登录请求功能
	$("#login").on("click",function(){
		var loginInfo = {
				"userTelephone" : $("#userTelephone").val(),
				"userPassword" : $("#userPassword").val(),
				"vrifyCode" : $("#valiCode").val()
			}
//		if(loginInfo.userAccount == ""){
//			$("label[for='errorTip']").html("<span style='color:red;'>账号不能为空</span>");
//			return
//		}else if(loginInfo.userPassword == ""){
//			$("label[for='errorTip']").html("<span style='color:red;'>密码不能为空</span>");
//			return
//		}else if(loginInfo.vrifyCode == ""){
//			$("label[for='errorTip']").html("<span style='color:red;'>验证码不能为空</span>");
//			return
//		}else{
//			//账号再次验证
//			$("#userAccount").bind({
//				"focus":function(){
//					$("label[for='errorTip']").html("");
//					$("label[for='inputAccount']").html("");
//					$("label[for='inputPassword']").html("");
//					$("#userAccount").css({'border':'1px solid #ced4da'});
//				},
//				"blur":function(){
//					if(!$("#userAccount").val()){
//						$("label[for='inputAccount']").html("<span style='color:red;'>账号或手机号不能为空</span>")
//					}else{
//						if(!/^[1][3,4,5,7,8][0-9]{9}$/.test($("#userAccount").val())){
//							$("#userAccount").css({'border':'1px solid red'});
//							$("label[for='inputAccount']").html("<span style='color:red;'>账号有误,请重新输入</span>")
//							return true;
//						}else{
//							$("#userAccount").css({'border':'1px solid #ced4da'});
//							return false;
//						}
//					}
//				}
//			})
//			
//			//密码再次验证
//			$("#userPassword").bind({
//				"focus":function(){
//					$("label[for='errorTip']").html("");
//					$("label[for='inputAccount']").html("");
//					$("label[for='inputPassword']").html("");
//					$("#userPassword").css({'border':'1px solid #ced4da'});
//				},
//				"blur":function(){
//					if(!$("#userPassword").val()){
//						$("label[for='inputPassword']").html("<span style='color:red;'>密码不能为空</span>")
//					}else{
//						if(!/^\d{6}$/.test($("#userPassword").val())){
//							$("#userPassword").css({'border':'1px solid red'});
//							$("label[for='inputPassword']").html("<span style='color:red;'>密码有误,请重新输入</span>")
//							return true;
//						}else{
//							$("#userPassword").css({'border':'1px solid #ced4da'});
//							return false;
//						}
//					}
//				}
//			})
		
			$.post({
				url:"/lender/loginCtrl/login",
				data:{"loginInfo" : JSON.stringify(loginInfo)},
				type: "post",
				dataType:"json",	
				success:function(data){
					console.log(data)
					if(data.result == false){
						$("label[for='errorTip']").html("<span style='color:red;'>用户名或密码错误</span>");
					}
					else{
						window.location.href="/page/main.html"
					}
				},
				error:function(error){
					alert('登录失败')
				}
			})
//		}
	})
})