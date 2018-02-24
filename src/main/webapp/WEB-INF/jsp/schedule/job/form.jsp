<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>容灾管理系统</title>
<link rel="shortcut icon" href="images/logo.ico">

<link href="${pageContext.request.contextPath}/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
   
<!-- bootstrap table -->
<link href="${pageContext.request.contextPath}/libs/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

<!-- zTree -->
<link href="${pageContext.request.contextPath}/libs/zTree_v3/css/metroStyle/metroStyle.css" rel="stylesheet" />
  
<!-- 自定义css -->
<link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">


</head>
<body class="my-content">

	<div id="dtApp" v-cloak>
		<div class="panel panel-default">
			<div class="panel-heading">{{ title }}</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
					   	<div class="col-sm-2 control-label">bean名称</div>
					   	<div class="col-sm-10">
					      <input type="text" class="form-control" v-model="job.beanName" placeholder="spring  bean名称,如:testTask"/>
					    </div>
					</div>
					<div class="form-group">
					   	<div class="col-sm-2 control-label">方法名称</div>
					   	<div class="col-sm-10">
					      <input type="text" class="form-control" v-model="job.methodName" placeholder="方法名称"/>
					    </div>
					</div>
					<div class="form-group">
					   	<div class="col-sm-2 control-label">参数</div>
					   	<div class="col-sm-10">
					      <input type="text" class="form-control" v-model="job.params" placeholder="参数"/>
					    </div>
					</div>
					<div class="form-group">
					   	<div class="col-sm-2 control-label">cron表达式</div>
					   	<div class="col-sm-10">
					      <input type="text" class="form-control" v-model="job.cronExpression" placeholder="如：0 0 12 * * ?"/>
					    </div>
					</div>
					<div class="form-group">
					   	<div class="col-sm-2 control-label">备注</div>
					   	<div class="col-sm-10">
					      <input type="text" class="form-control" v-model="job.remark" placeholder="备注"/>
					    </div>
					</div>
					
					<div class="hr-line-dashed"></div>
					<div class="form-group pull-right">
						<div class="col-sm-12">
							<button type="button" class="btn btn-primary" @click="saveOrUpdate" >确定</button>
							<a href="index" class="btn btn-white">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	
	<!-- 全局js -->
    <script src="${pageContext.request.contextPath}/libs/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/libs/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/libs/vue.min.js"></script>

	
	<!--浮层-->
	<script src="${pageContext.request.contextPath}/libs/layer/layer.min.js"></script>
    <!-- zTree -->
    <script src="${pageContext.request.contextPath}/libs/zTree_v3/js/jquery.ztree.all.min.js"></script>
    
    <!-- FastJson -->
    <script src="${pageContext.request.contextPath}/libs/FastJson-1.0.min.js"></script>
    
	<!-- 全局通用js配置 -->
	<script src="${pageContext.request.contextPath}/script/common.js"></script>
	
	<!-- 模块 -->
	<script src="${pageContext.request.contextPath}/script/modules/schedule/job/form.js"></script>
</body>
</html>