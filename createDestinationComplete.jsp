<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;URL='SettlementConfirmAction'"/>
<link rel="stylesheet" href="./css/title.css">
<link rel="stylesheet" href="./css/message.css">
<link rel="stylesheet" href="./css/header.css">
<title>宛先情報入力完了</title>
</head>
<body>
<!-- CompleteActionからSUCCESSが返るとstrutsから遷移して表示される -->
<!-- 					↓↓ -->
<jsp:include page="header.jsp" />
<div id="contents">
	<h1>宛先情報入力完了画面</h1>
	<div class="success">
		宛先情報入力が完了しました。
	</div>
</div>
</body>
</html>