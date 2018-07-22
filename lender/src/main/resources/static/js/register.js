/**
 * 
 */
$(function() {
	
	var userIdentityCardVlidateRule = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
	var userTelephoneVlidateRule = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
	//��֤
	function validate(val,name){
        var regexp = /^\s*$/;
        if(!val || val==" " || regexp.test(val)){
            $('input[name="'+name+'"]').addClass('required');
            return false;
        }else{
            $('input[name="'+name+'"]').removeClass('required');
            //$('select[name="'+name+'"]').removeClass('required');
            return true;
        }  
	}
	
	$("#register").on("click",function(){
		register();
	})
	
	function register(){
		var registerInfo ={
				"userAccount" : $("#userAccount").val(),
				"userName" : $("#userName").val(),
				"userIdentityCard" : $("#userIdentityCard").val(),
				"userTelephone" : $("#userTelephone").val(),
				"userEmail" : $("#userEmail").val(),
				"userAddress" : $("#userAddress").val(),
				"userPassword" : $("#userPassword").val(),
				"confirmPassword" : $("#repeatPassword").val()
			}
		
		var validateMsg;
		if(userIdentityCardVlidateRule.rest(registerInfo.userIdentityCard) != true)
		{
			validateMsg = "身份证号码不合法";
			$('#')
		}
		
		if(userTelephoneVlidateRule.rest(registerInfo.userIdentityCard) != true)
		{
			validateMsg = "电话号码不合法";
			$('#')
		}
		
		$.post({
			url:"/lender/registerCtrl/register",
			data:{"registerInfo" : JSON.stringify(registerInfo)},
			type: "post",
			dataType:"json",	
			success:function(data){
				console.log(data)
				if(data != null && data.result){
					setTimeout(function(){
						window.location.href="/page/login.html"
					},5000)
				}
			},
			error:function(error)
			{
				alert("System error")
			}
		})
	}
})