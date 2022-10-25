var username;
var userid;
var role;
var avatar;

//login page register button
function register(){
    window.location.href = "/register";
    // location.replace("http://localhost:8081/register");
}

//login form submittion
$(document).ready(function(){
    $(".loginform").submit(function(e){
      e.preventDefault();

      var form = $(this);
      var url = "/users/login"; //url需要更换为跟后端相连的
      $.ajax({
          type:"POST",
          url: url,
          data: form.serialize(),
          dataType:"json",
          success:function(data){
              console.log(data);
              if(data.state === 200){ //返回成功信息，转到主界面或登陆界面
                  alert("Login Success");
                  var loginform = document.getElementById('loginform');
                  username = loginform.elements[0].value;

                //从数据库中得到用户id, 身份，avatar（或许需要）
                  userid = data.uid;
                  role = data.role;
                  avatar = data.avatar;

                  if(role == 0){
                      window.location.href = "/student";
                    // location.replace("http://localhost:8081/student"); //redirect to student main page
                  }else if(role == 1){
                      window.location.href = "/visitor";
                    // location.replace("http://localhost:8081/visitor"); //redirect to vistor main page
                  }else{
                      window.location.href = "/manager";
                    // location.replace("http://localhost:8081/manager"); //redirect to manager main page
                  }


              }else{
                  alert("Something went wrong, please try again.");
              }
          }
      });
  });
});

//register page login button
function login(){
    window.location.href = "/login";
    // location.replace("http://localhost:8081/login");
  }
//register form submittion
$(document).ready(function(){
  $(".registerform").submit(function(e){
    e.preventDefault();

    var form = $(this);
    var url = "/users/reg"; //url需要更换为跟后端相连的
    var registerform = document.getElementById('registerform');
    var studentid = registerform.elements[1].value;
    if(studentid !=""){
        console.log(studentid);
    }
    $.ajax({
        type:"POST",
        url: url,
        data: form.serialize(),
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.state === 200){ //返回成功信息，转到主界面或登陆界面
                alert("Register Success");
                console.log(data.studentid);
                if(data.studentid !== ""){
                    window.location.href = "/avatar";
                    // location.replace("http://localhost:8081/avatar"); //redirect to avatar
                }else{
                    window.location.href = "/login";
                    // location.replace("http://localhost:8081/login"); //redirect to login
                }
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
    });
});

//student main page
function showAddfriend(){
    document.getElementById("addfriend").style.display = "block";
}

function showCreate(){
    document.getElementById("newroom").style.display = "block";
}

function showedit(){
    document.getElementById("edit").style.display = "block";
}

function closeAddfriend(){
    document.getElementById("addfriend").style.display = "none";
}

function closeCreate(){
    document.getElementById("newroom").style.display = "none";
}

function closeEdit(){
    document.getElementById("edit").style.display = "none";
}

//load friend list
function refresh(){
    //clear friend list
    var friendlist = document.getElementById("refresh");
    friendlist.innerHTML = "";

    $.ajax({
        type:"GET",
        url: "/friendlist",
        data: {userid: userid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.message == "success"){ //返回好友json
                for(var i = 0; i < data.contact_student_id.length; i++){
                    var contact_student_id = data.contact_student_id.get(i); //需要确认！！！
                    var contact_avatar = data.contact_avatar.get(i);
                    var contact_username = data.contact_username.get(i);

                    //create list
                    var li = document.createAttribute("li");

                    var img = document.createAttribute("img");
                    img.setAttribute("src", contact_avatar);
                    img.setAttribute("class", "avatar");

                    li.appendChild(img);

                    li.setAttribute("class", "friend")
                    li.innerHTML = contact_username;

                    friendlist.appendChild("li");
                }
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//add friend form submittion
$(document).ready(function(){
    $(".addfriendform").submit(function(e){
      e.preventDefault();

      var form = $(this);
      var url = "/addfriend"; //url需要更换为跟后端相连的
      $.ajax({
          type:"POST",
          url: url,
          data: form.serialize(),
          dataType:"json",
          success:function(data){
              console.log(data);
              if(data.message == "success"){ //返回成功信息
                  alert("Add New Friend Success");
              }else{
                  alert("Something went wrong, please try again.");
              }
          }
      });
    });
});

//get friendlist for add new chat room
function getFriend(){
    var list = document.getElementById("loadfriendnewroom");
    list.innerHTML = "";

    $.ajax({
        type:"GET",
        url: "/friendlist",
        data: {userid: userid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.message == "success"){ //返回好友json
                for(var i = 0; i < data.contact_student_id.length; i++){
                    var contact_student_id = data.contact_student_id.get(i); //需要确认！！！

                    //create list
                    var checkbox = document.createAttribute("input");
                    checkbox.setAttribute("type", checkbox);
                    checkbox.setAttribute("name", friendid);
                    checkbox.setAttribute("value", contact_student_id);

                    var label = document.createAttribute("label");
                    label.setAttribute("for", friendid);
                    label.innerHTML = contact_student_id;

                    list.appendChild(checkbox);
                    list.appendChild(label);
                }
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//submit create room form
$(document).ready(function(){
    $(".newroomform").submit(function(e){
      e.preventDefault();

      var form = $(this);
      var url = "/newroom"; //url需要更换为跟后端相连的
      $.ajax({
          type:"POST",
          url: url,
          data: form.serialize(),
          dataType:"json",
          success:function(data){
              console.log(data);
              if(data.message == "success"){ //返回成功信息
                  alert("Create New Room Success");
              }else{
                  alert("Something went wrong, please try again.");
              }
          }
      });
    });
});

//get previous edit information
$(document).ready(function(){
      $.ajax({
          type:"GET",
          url: "/getedit", //和后端统一
          data: {userid: userid},
          dataType:"json",
          success:function(data){
              console.log(data);
              if(data.message == "success"){ //返回成功信息,显示生日
                  var birthday = data.birthday;
                  var input =  document.getElementById("birthday");
                  input.value = birthday;
              }else{
                  alert("Something went wrong, please try again.");
              }
          }
      });
});

//edit form submittion
$(document).ready(function(){
    $(".editform").submit(function(e){
      e.preventDefault();

      var form = $(this);
      var url = "/edit"; //url需要更换为跟后端相连的
      $.ajax({
          type:"POST",
          url: url,
          data: form.serialize(),
          dataType:"json",
          success:function(data){
              console.log(data);
              if(data.message == "success"){ //返回成功信息
                  alert("Edit Success");
              }else{
                  alert("Something went wrong, please try again.");
              }
          }
      });
    });
});
