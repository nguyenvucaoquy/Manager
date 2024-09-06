function changeLogin() {
  window.open("Login.html", "_self");
}
function ReLogin() {
  window.open("Login.html", "_self");
}
function HandleChagepage() {
  console.log("register login");
  // fucntion redied
  window.open("Register.html", "_self");
}
function admintologout() {
  window.open("Login.html", "_self");
}
function resetForm() {
  console.log("register login");
  // fucntion redied
  var fullname2 = (document.getElementById("FullNameID").value = "");
  var email = (document.getElementById("EmailID").value = "");
  var password = (document.getElementById("PasswordID").value = "");
  var cpassword = (document.getElementById("CPasswordID").value = "");
  var brithday = (document.getElementById("BirthDayID").value = "");
}
function createNewUser() {
  var v_fullname = document.getElementById("FullNameID").value;
  var v_email = document.getElementById("EmailID").value;
  var v_password = document.getElementById("PasswordID").value;
  var v_cpassword = document.getElementById("CPasswordID").value;
  var v_brithday = document.getElementById("BirthDayID").value;

  if (v_password != v_cpassword) {
    alert("password no trung lap");
  } else {
    var user = {
      Full_name: v_fullname,
      Email: v_email,
      Password: v_password,
      date: v_brithday,
    };
    alert("Đăng ký thành công ");
    window.open("Login.html", "_self");
    var json = JSON.stringify(user);
    localStorage.setItem("user", json);
  }
}
var g = JSON.parse(localStorage.getItem("user"));
$("#nono").append(`<p>${g.Full_name}</p>`);
console.log(g);
function handlecheck() {
  var v_vEmail = document.getElementById("checkEmail").value;
  var v_vPassword = document.getElementById("checkPassWord").value;
  var a = JSON.parse(localStorage.getItem("user"));

  if (v_vEmail == a.Email && v_vPassword == a.Password) {
    window.open("Admin.html", "_self");
  } else {
    alert("khong thanh cong");
    return;
  }
}
var isLoggedInrr = false;

function logout() {
  if (!isLoggedInrr) {
    $("#logggg").append(
      ` <button type="button" class="btn btn-default btn-sm" onclick="admintologout()">
      <span class="glyphicon glyphicon-log-out"></span> Log out
    </button>`
    );
    isLoggedInrr = true;
    console.log(isLoggedInrr);
  } else {
    $("#logggg").remove();
    $("#logggg").empty();
    isLoggedInrr = false;
    console.log(isLoggedInrr);
  }
}
