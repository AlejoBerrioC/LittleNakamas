<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/stylesMenu.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Employees Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Employees</b></h1>
                    <div class="add-delete-boutons">
                        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#delete-employee-modal"><img src="static/images/Tables/deleteT.png"><span>Delete</span></button>
                    </div>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Actions</th>
                    </thead>
                    <tbody>
                        <c:forEach var="employe" items="${employees}" >
                            <tr>
                                <td><c:out value="${employe.numEmp}"/></td>
                                <td><c:out value="${employe.preEmp}"/></td>
                                <td><c:out value="${employe.nomEmp}"/></td>
                                <td>
                                    <a title="Delete" data-toggle="modal" data-target="#delete-employee-modal"><img src="static/images/Tables/delete.png"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Delete Employee Modal -->
    <div id="delete-employee-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Delete Employee</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>