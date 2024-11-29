<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylesLogin.css">
    <title>LogIn Page: Little Nakamas</title>
</head>

<body>
    <div class="container">

        <div class="login-box">
            <div class="logo-garderie">
                <img src="static/images/Index/logo_garderie.png" alt="logo-garderie">
            </div>
            <form name="login-form" method="post" action="index">
                <label for="name">Name:</label> <br/>
                <input type="text" id="name" name="name" length="16"> <br/>
                <label for="lastname">LastName:</label> <br/>
                <input type="text" id="lastname" name="lastname" length="16"> <br/>
                <label for="password">Password: </label> <br/>
                <input type="password" id="pass" name="pass" length="16"> <br/>
                <button type="button" id="login">LogIn</button>
            </form>
        </div>
        <div class="background">
            <h1>Little Nakamas</h1>
            <img src="static/images/Login-Aboutus/pngegg.png" alt="LittleNakamas">
        </div>
    </div>
</body>

</html>