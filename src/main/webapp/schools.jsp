<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylesMenu.css">
    <title>Schools Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Schools</b></h1>
                </div>
                <div class="add-delete-boutons">
                    <a href="#" class="btn"><img src="static/images/Tables/add.png"><span>Add New School</span></a>
                    <a href="#" class="btn"><img src="static/images/Tables/deleteT.png"><span>Delete</span></a>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Capacity</th>
                    <th>Actions</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Little Nakamas</td>
                            <td>50</td>
                            <td>
                                <a title="Edit"><img src="static/images/Tables/edit.png"></a>
                                <a title="Delete"><img src="static/images/Tables/delete.png"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>