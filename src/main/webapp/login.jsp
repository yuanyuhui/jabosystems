<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>JBAO办公自动化登录页面</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<!-- <link href="css/jquery.idcode.css" type="text/css" rel="stylesheet"> -->
<style>
* {
	margin: 0px;
}

body {
	background-image: url("images/bg.gif");
	text-align: center;
	position: fixed;
}

#div1 {
	margin-top: 150px;
}

#div1 img {
	margin-top: -3px;
}

ul {
	margin-top: -133px;
	margin-left: -90px;
}

ul li {
	height: 30px;
	font-weight: bold;
}

.li_text {
	width: 140px;
}

label {
	margin-left: 65px;
	margin-top: -58px;
	position: absolute;
}

#idcode {
	position: absolute;
	margin-left: -76px;
	margin-top: 5px;
}

.li {
	text-align: right;
	margin-right: 590px;
}
</style>
</head>
<body>
	<div id="div1">
		<img src="images/login_01.gif"> <img src="images/login_02.gif">
		<form action="Employee/loginin" method="get">
			<ul>
				<li>工&nbsp;&nbsp;号&nbsp;<input type="text" name="eid"
					class="li_text"></li>
				<li>密&nbsp;&nbsp;码&nbsp;<input type="password" name="epwd"
					class="li_text"></li>
				<li>验证码：&nbsp;<input type="text" name="verify" class="li_text"
					id="Txtidcode" class="txtVerification"></li>

				<li class="li"><span id="idcode"></span> <input type="image"
					src="images/login_sub.gif">${MSG}</li>
			</ul>
			<label>严格区分大小写</label>
		</form>
	</div>

</body>
<!-- <script src="js/jquery-1.12.3.min.js"></script> -->
<!--//引用idcode插件-->
<!-- <script src="js/jquery.idcode.js"></script>
<script>
	$.idcode.setCode(); //加载生成验证码方法
	$("input[type=image]").click(function() {
		var IsBy = $.idcode.validateCode() //调用返回值，返回值结果为true或者false
		if (IsBy) {
			alert("验证码输入正确")
		} else {
			alert("请重新输入")
		}
	})
</script> -->
</html>