<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylesMenu.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Parents Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Parents</b></h1>
                </div>
                <div class="add-delete-boutons">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-parent-modal"><img src="static/images/Tables/add.png"><span>Add New Parent</span></button>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                        <th>Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Actions</th>
                    </thead>
                    <tbody>
                        <c:forEach var="parent" items="${parents}">
                            <tr>
                                <td><c:out value="${parent.prePar}"/></td>
                                <td><c:out value="${parent.nomPar}"/></td>
                                <td><c:out value="${parent.numTel}"/></td>
                                <td>
                                    <a title="Edit" data-toggle="modal" data-target="#edit-parent-modal"
                                    data-parent-number="${parent.numTel}"
                                    data-parent-name="${parent.prePar}"
                                    data-parent-lastname="${parent.nomPar}">
                                        <img src="static/images/Tables/edit.png">
                                    </a>
                                    <a title="Delete" data-toggle="modal" data-target="#delete-parent-modal" data-parent-number="${parent.numTel}"><img src="static/images/Tables/delete.png"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Add Parent Modal -->
    <div id="add-parent-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="parents">
                    <div class="modal-header">
                        <h3 class="modal-title">Add New Parent</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Parent Name</label>
                            <input type="text" name="parent-name" class="form-control" placeholder="Enter Parent Name">
                        </div>
                        <div class="form-group">
                            <label>Parent Last Name</label>
                            <input type="text" name="parent-lastname" class="form-control" placeholder="Enter Parent Last Name">
                        </div>
                        <div class="form-group">
                            <label>Phone Number</label>
                            <input type="text" name="parent-number" class="form-control" placeholder="Enter Parent Phone Number">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add Parent</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Delete Parent Modal -->
    <div id="delete-parent-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="get" action="parentsDelete" id="delete-parent-form">
                    <div class="modal-header">
                        <h3 class="modal-title">Delete Parent</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                        <input type="hidden" name="parent-number" id="modal-parent-number"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Edit Parent Modal-->
    <div id="edit-parent-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="parentsEdit" id="edit-parent-form">
                    <div class="modal-header">
                        <h3 class="modal-title">Edit Parent</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="parent-old-number" id="modal-parent-old-number"/>
                        <div class="form-group">
                            <label>Parent Name</label>
                            <input type="text" name="parent-new-name" class="form-control" id="modal-parent-new-name">
                        </div>
                        <div class="form-group">
                            <label>Parent Last Name</label>
                            <input type="text" name="parent-new-lastname" class="form-control" id="modal-parent-new-lastname">
                        </div>
                        <div class="form-group">
                            <label>Phone Number</label>
                            <input type="text" name="parent-new-number" class="form-control" id="modal-parent-new-number">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Edit Parent</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        $(document).on('click', '[data-target="#delete-parent-modal"]', function () {
            var parentNumTel = $(this).data('parent-number');

            $('#modal-parent-number').val(parentNumTel);
        });

        $(document).on('click', '[data-target="#edit-parent-modal"]', function () {
            var parentNumTel = $(this).data('parent-number');
            var parentPren = $(this).data('parent-name');
            var parentNom = $(this).data('parent-lastname');

            $('#modal-parent-old-number').val(parentNumTel);
            $('#modal-parent-new-number').val(parentNumTel);
            $('#modal-parent-new-name').val(parentPren);
            $('#modal-parent-new-lastname').val(parentNom);
        });
    </script>
</body>

</html>