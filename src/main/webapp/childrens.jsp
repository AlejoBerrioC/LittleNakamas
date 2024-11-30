<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylesMenu.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Students Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Childrens</b></h1>
                </div>
                <div class="add-delete-boutons">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-children-modal"><img src="static/images/Tables/add.png"><span>Add New Children</span></button>
                    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#delete-children-modal"><img src="static/images/Tables/deleteT.png"><span>Delete</span></button>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Parent</th>
                    <th>Date Inscription</th>
                    <th>Section</th>
                    <th>Actions</th>
                    </thead>
                    <tbody>
                        <c:for var = "i" begin="0" end="${enfants.size()}">
                            <tr>
                                <td><c:out value="${enfants[i].numEnf}" /></td>
                                <td><c:out value="${enfant[i].prenEnf}" /></td>
                                <td><c:out value="${enfant[i].nomEnf}" /></td>
                                <td><c:out value="${enfant[i].ageEnf}" /></td>
                                <td><c:out value="${enfant[i].parentEnf.nomPar} + ${enfant[i].parentEnf.prePar}" /></td>
                                <td><c:out value="${dates[i].dateInscription}" /></td>
                                <td><c:out value="${enfant.affectedSection(enfant.ageEnf)}" /></td>
                                <td>
                                    <a title="Edit" data-toggle="modal" data-target="#edit-children-modal"><img src="static/images/Tables/edit.png"></a>
                                    <a title="Delete" data-toggle="modal" data-target="#delete-children-modal"><img src="static/images/Tables/delete.png"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    

    <!-- Add Children Modal -->
    <div id="add-children-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Add New Children</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Children Name</label>
                            <input type="text" class="form-control" placeholder="Enter Children Name">
                        </div>
                        <div class="form-group">
                            <label>Children Last Name</label>
                            <input type="text" class="form-control" placeholder="Enter Children Last Name">
                        </div>
                        <div class="form-group">
                            <label>Children Age</label>
                            <input type="text" class="form-control" placeholder="Enter Children Age">
                        </div>
                        <div class="form-group">
                            <label>Parent Telephone</label>
                            <input type="text" class="form-control" placeholder="Enter Parent Telephone">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add Student</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Delete Children Modal -->
    <div id="delete-children-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Delete Children</h3>
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
    <!--Edit Children Modal-->
    <div id="edit-children-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Edit Children</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Children Name</label>
                            <input type="text" class="form-control" placeholder="Enter Children Name">
                        </div>
                        <div class="form-group">
                            <label>Children Last Name</label>
                            <input type="text" class="form-control" placeholder="Enter Children Last Name">
                        </div>
                        <div class="form-group">
                            <label>Children Age</label>
                            <input type="text" class="form-control" placeholder="Enter Children Age">
                        </div>
                        <div class="form-group">
                            <label>Parent Telephone</label>
                            <input type="text" class="form-control" placeholder="Enter Parent Telephone">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Edit Children</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>