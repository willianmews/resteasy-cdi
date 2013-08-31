<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.8.0.min.js"/>"></script>
</head>
<body>
	<div id="wrapper">
		<strong><span>SALDO ATUAL:</span></strong>
		<span id="saldo"></span><br><br>
		<span >Valor da operação:</span>
		<input type="text" id="valorOperacao">
		<input type="button" value="Depositar" onclick="operation('deposit')">
		<input type="button" value="Sacar" onclick="operation('take')"><br><br>
		<strong><span>LOG:</span></strong><br>
		<span id="log"></span>
	</div>
	
	<script type="text/javascript">
	
	function operation(type){
		var value = $("#valorOperacao").val();
		var url = "rest/atm/";
		url = url + type + "/" + value;
		log("Chamando URL: " + url);
		$.ajax({
		  url: url,
		}).done(function ( result ) {
			log("Resultado da URL: " + result);
			$("#saldo").html(result);
		});
	}

	function log(value){
		var log = $("#log").html();
		log = log + "<br>" + value;
		$("#log").html(log);
	}
	
	$(document).ready(function() {
		var url = "rest/atm/balance";
		log("Chamando URL: " + url);
		$.ajax({
		  url: url,
		}).done(function ( result ) {
			log("Saldo inicial: " + result);
			$("#saldo").html(result);
		});
	});
	
	</script>
	
</body>
</html>
