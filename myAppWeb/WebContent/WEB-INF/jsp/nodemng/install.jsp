<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="Cache-Control" content="no-transform " />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="keywords" content="">
<meta name="description" content="">
<title>单据详细信息</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" href="css/css.css"/>
<script type="text/javascript" src="js/zepto.min.js"></script>
<script type="text/javascript">
function doSubmit(){
	   document.getElementById("form1").action="Status?ids="+${tjob.id};
	   document.getElementById("form1").submit();	
};
function goback(){
	document.getElementById("form1").action="index";
	document.getElementById("form1").submit();
}
</script>
</head>
<body>
<header id="title"><a href="#" class="back" onclick="goback()"></a>运单号：${orderResult.jobno} </header>
<form action="" id="form1" method="post">
		<div class="xuan_con">
			<div class="km">
				<div class="km_con">
					<input type="hidden" id="ids" value="${orderResult.status}">
					<span class="km_left">急&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单：</span> 
					<span class="km_right">${orderResult.jobno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</span> 
					<span class="km_right">${orderResult.status}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">提&nbsp;柜&nbsp;地：</span> 
					<span class="km_right">${orderResult.jobno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">装卸货地：</span> 
					<span class="km_right">${orderResult.jobno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">预约时间：</span> 
					<span class="km_right">${orderResult.plt}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">柜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">封&nbsp;条&nbsp;号：</span> 
					<span class="km_right">${orderResult.slno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">交仓地址：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">报关方式：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">司&nbsp;机&nbsp;本：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">体&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;积：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
				
				<div class="km_con">
					<span class="km_left">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</span> 
					<span class="km_right">${orderResult.cnno}</span>
				</div>
			</div>
		</div>

		 <section id="login">
				<input  type="hidden" name="openid" value="" /><a href="javascript:void(0);" onclick="doSubmit()" class="btnRegister">确认</a>	
		</section> 
</form>
</body>
