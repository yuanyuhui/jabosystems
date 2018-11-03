<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="top">
		<div class="global-width">
			<img src="images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			<span class="usertype">【登录角色：<s:property
					value="#session.loginBean.positionId.nameCn" />】
			</span>
			<s:property value="#session.loginBean.name" />
			你好！欢迎访问青鸟办公管理系统！
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			<div class="nav" id="nav">
				<div class="t"></div>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">报销单管理</dt>
					<dd>
						<a href="bxlist.html" target="_self">查看报销单</a>
					</dd>
					<dd>
						<a href="claimVoucherToAddAction.action" target="_self">添加报销单</a>
					</dd>
				</dl>
				<dl class="open">
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">请假管理</dt>
					<dd>
						<a href="qjlist.html" target="_self">查看请假</a>
					</dd>
					<dd>
						<a href="qjsave.html" target="_self">申请请假</a>
					</dd>

				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">统计报表</dt>
					<dd>报销单月度统计</dd>
					<dd>报销单年度统计</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息中心</dt>
					<dd>信心收件箱</dd>
					<dd>信心发件箱</dd>
				</dl>
			</div>
			<form action="leaveQueryAction.action" id="myForm" method="post">
				<input type="hidden" name="curPage" value="1" id="curPage">
					<div class="action">
						<div class="t">请假列表</div>
						<div class="pages">
							开始时间：<input type="date"> 结束时间：<input type="date">
									<input type="submit" value="查询"> <!--增加报销单 区域 开始-->
										<table width="90%" border="0" cellspacing="0" cellpadding="0"
											class="list">
											<tr>
												<td>编号</td>
												<td>名称</td>
												<td>发起时间</td>
												<td>审批时间</td>
												<td>审批意见</td>
												<td>审批状态</td>
												<td>操作</td>
											</tr>

											<tr>
												<td>1</td>
												<td>请假<span>1</span>天
												</td>
												<td><span>2018-06-06 12:00</span></td>
												<td><span>2018-06-06 12:05</span></td>
												<td><span></span></td>
												<td><span>待审批</span></td>
												<td>
													<!--
                            	作者：offline
                            	时间：2018-06-06
                            	描述：根据权限和数据动态呈现
                            --> <a href="qidetails.html"><img
														src="images/search.gif" width="16" height="15" /></a> <a
													href="qjexamination.html"><img src="images/sub.gif"
														width="16" height="16" /></a>
												</td>
											</tr>

											<tr>
												<td colspan="6" align="left"><a href="#">首页</a> <a
													href="#">上一页</a> <a href="#">下一页</a> <a href="#">末页</a></td>
											</tr>
										</table> <!--增加报销单 区域 结束-->
						</div>
					</div>
			</form>
		</div>
	</div>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>
</html>