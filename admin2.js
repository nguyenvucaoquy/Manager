//decalre list acocunt
var listAccount = [];
var listDepartment = [];
var listposition = [];
// manual button reseta
getlistaccount();
getlistdepartment();
getlistposition();
function getlistposition() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/backend/position",
    dataType: "JSON",
    success: function (response) {
      console.log("response position", response);
      listposition = response;
      for (let i = 0; i < listposition.length; i++) {
        $("#id_position").append(
          `<option   value="${listposition[i].pos_ID}">${listposition[i].pos_Name}</option>`
        );
      }
    },
  });
}
function getlistdepartment(param) {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/backend/department",
    dataType: "json",
    success: function (response) {
      console.log("response department", response);
      listDepartment = response;
      for (let i = 0; i < listDepartment.length; i++) {
        $("#id_department").append(
          `<option value="${listDepartment[i].idShort}">${listDepartment[i].name}</option>`
        );
      }
    },
  });
}
function getlistaccount(param) {
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/api/backend/account`,
    dataType: "json",
    success: function (response) {
      console.log("response", response);
      listAccount = response;
      $("#ResultTable").empty();
      //jquery: append tempalte String similar plus string in java
      for (let i = 0; i < listAccount.length; i++) {
        $("#ResultTable").append(
          `<tr>
        <td>${listAccount[i].id}</td>
        <td>${listAccount[i].email}</td>
        <td>${listAccount[i].username}</td>
        <td>${listAccount[i].fullname}</td>
        <td>${listAccount[i].acc_Department}</td>
        <td>${listAccount[i].position}</td>
        <td>${listAccount[i].creatDate}</td>
        <td>
          <button type="button" class="btn btn-warning" onclick="EditAccount(${i})">Edit</button>
        </td>
        <td>
          <button type="button" class="btn btn-danger" onclick="DeleteAccount(${i})">Delete</button>
        </td>
      </tr>`
        );
      }
    },
  });
}

$("#reset_btn").click(function (e) {
  $("#id_ID").removeAttr("disabled");
  $("#id_ID").val(" ");
  $("#id_Email").removeAttr("disabled");
  $("#id_Email").val(" ");
  $("#id_Username").removeAttr("disabled");
  $("#id_Username").val(" ");
  $("#id_fullName").removeAttr("disabled");
  $("#id_fullName").val(" ");
  $("#id_department").val(" ");
  $("#id_position").val(" ");
  $("#id_date").val(" ");
});
// manual add new  button

$("#save_btn").click(function (e) {
  var i_id = $("#id_ID").val();
  var i_email = $("#id_Email").val();
  var i_username = $("#id_Username").val();
  var i_fullname = $("#id_fullName").val();
  var i_department = $("#id_department").val();
  var i_position = $("#id_position").val();
  var i_date = $("#id_date").val();

  var account_new = {
    username: i_username,
    department: i_department,
    email: i_email,
    position: i_position,
    first: i_fullname,
  };
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/backend/account",
    data: JSON.stringify(account_new),
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
      getlistaccount();
    },
  });
});
function DeleteAccount(index) {
  var result = confirm("You want dicide delete");
  if (result) {
    var v_id = listAccount[index].id;
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/api/backend/account/" + v_id,
      success: function (response) {
        getlistaccount();
      },
    });
  } else {
    return;
  }
}
function EditAccount(indexEdit) {
  var v_DepID;
  for (let i = 0; i < listDepartment.length; i++) {
    if (listDepartment[i].name === listAccount[indexEdit].acc_Department) {
      v_DepID = listDepartment[i].idShort;
    }
  }
  var v_PosID;
  for (let i = 0; i < listposition.length; i++) {
    if (listposition[i].pos_Name === listAccount[indexEdit].position) {
      v_PosID = listposition[i].pos_ID;
    }
  }
  $("#id_ID").attr("disabled", "disabled");
  $("#id_ID").val(listAccount[indexEdit].id);
  $("#id_Email").attr("disabled", "disabled");
  $("#id_Email").val(listAccount[indexEdit].email);
  $("#id_Username").attr("disabled", "disabled");
  $("#id_Username").val(listAccount[indexEdit].username);
  $("#id_fullName").attr("disabled", "disabled");
  $("#id_fullName").val(listAccount[indexEdit].fullname);
  $("#id_department").val(v_DepID);
  $("#id_position").val(v_PosID);
  $("#id_date").val(listAccount[indexEdit].creatDate);
}

$("#update_btn").click(function () {
  var id = $("#id_ID").val(); // user no edit
  var i_email = $("#id_Email").val();
  var i_username = $("#id_Username").val();
  var fullname = $("#id_fullName").val();
  var i_department = $("#id_department").val();
  var i_position = $("#id_position").val();
  var date = $("#id_date").val();
  var account_update = {
    department: i_department,
    position: i_position,
  };
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/backend/account/" + id,
    data: JSON.stringify(account_update),
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
      getlistaccount();
    },
  });
});
