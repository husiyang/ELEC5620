var username;
var userid;
var role;
var avatar;
var chatroomid;

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

                  if(role === 0){
                      window.location.href = "/student";
                    // location.replace("http://localhost:8081/student"); //redirect to student main page
                  }else if(role === 1){
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

//////////////////////////////////////////////////////////////////////
//student main page
function showAddfriend(){
    document.getElementById("addfriend").style.display = "block";
}

function showCreate(){
    document.getElementById("newroom").style.display = "block";
}

function showedit(){
    document.getElementById("edit").style.display = "block";
    displayPrevEdit();
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
    var friendlist = document.getElementById("friendlist");
    friendlist.innerHTML = "";

    $.ajax({
        type:"GET",
        url: "/friendlist",
        data: {userid: userid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){ //返回好友json
                for(var i = 0; i < data.contact_student_id.length; i++){
                    var contact_student_id = data.contact_student_id.get(i); //需要确认！！！
                    var contact_avatar = data.contact_avatar.get(i);
                    var contact_username = data.contact_username.get(i);

                    //create list
                    var li = document.createElement("li");

                    var img = document.createElement("img");
                    img.setAttribute("src", contact_avatar);
                    img.setAttribute("class", "avatar");

                    li.appendChild(img);

                    li.setAttribute("class", "friend");
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
            data: form.serialize() + "&" +  "userid=" + userid,
            dataType:"json",
            success:function(data){
                console.log(data);
                if(data.msg == "success"){ //返回成功信息
                    document.getElementById("addfriend").style.display = "none";
                    alert("Add New Friend Success");
                }else{
                    alert("Something went wrong, please try again.");
                }
            }
        });
    });
});

//get friendlist for adding new chat room
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
            if(data.msg == "success"){ //返回好友json
                for(var i = 0; i < data.contact_student_id.length; i++){
                    var contact_student_id = data.contact_student_id.get(i); //需要确认！！！

                    //create list
                    var checkbox = document.createElement("input");
                    checkbox.setAttribute("type", checkbox);
                    checkbox.setAttribute("name", "contact_student_id");
                    checkbox.setAttribute("value", contact_student_id);

                    var label = document.createElement("label");
                    label.setAttribute("for", "contact_student_id");
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
            data: form.serialize() + "&" +  "userid=" + userid,
            dataType:"json",
            success:function(data){
                console.log(data);
                if(data.msg == "success"){ //返回成功信息
                    document.getElementById("newroom").style.display = "none";
                    alert("Create New Room Success");
                }else{
                    alert("Something went wrong, please try again.");
                }
            }
        });
    });
});

//get previous edit information
function displayPrevEdit(){
    $.ajax({
        type:"GET",
        url: "/getedit", //和后端统一
        data: {userid: userid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){ //返回成功信息,显示生日
                var birthday = data.birthday;
                var input =  document.getElementById("birthday");
                input.value = birthday;
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//edit form submittion
$(document).ready(function(){
    $(".editform").submit(function(e){
        e.preventDefault();

        var form = $(this);
        var url = "/edit"; //url需要更换为跟后端相连的
        $.ajax({
            type:"POST",
            url: url,
            data: form.serialize() + "&" +  "userid=" + userid,
            dataType:"json",
            success:function(data){
                console.log(data);
                if(data.msg == "success"){ //返回成功信息
                    document.getElementById("edit").style.display = "none";
                    alert("Edit Success");
                }else{
                    alert("Something went wrong, please try again.");
                }
            }
        });
    });
});

//load chatroom list
function refreshchat(){
    //clear chat list
    var chatlist = document.getElementById("chatlist");
    chatlist.innerHTML = "";

    $.ajax({
        type:"GET",
        url: "/chatlist",
        data: {userid: userid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){ //返回好友json
                for(var i = 0; i < data.chatroom_id.length; i++){
                    var chatroom_id = data.chatroom_id.get(i);//需要确认！！！

                    //create list
                    var li = document.createElement("li");

                    li.setAttribute("class", "chat");
                    li.setAttribute("onclick", "showChat(this)");
                    li.innerHTML = chatroom_id;

                    chatlist.appendChild("li");
                }
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//display chat area and chatroom
function showChat(chatroom){
    document.getElementById("chatarea").style.display = "block";
    chatroomid = chatroom.textContent;
    console.log(chatroomid);

    var title = document.getElementById("title");
    title.innerHTML = chatroomid;

    //get messages from chatroom
    $.ajax({
        type:"GET",
        url: "/getmessage",
        data: {chatroom_id: chatroomid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){ //返回成功信息
                var groupfriendlist = data.contact_student_id; //组内人员列表
                for(var i=0; i <groupfriendlist.length; i++){
                    //显示群内人员
                    var groupfriendlist = document.getElementById("groupfriendlist");
                    var li = document.createElement("li");
                    li.innerHTML = groupfriendlist.get(i);

                    groupfriendlist.appendChild(li);
                }

                var count = data.count;
                for(var i = 0; i < count; i++){
                    var message = data.message.get(i); //拿到每一个message
                    var message_id = message.message_id;
                    var content = message.content;
                    var type = message.type;
                    var sender_id = message.sender_id;

                    if(type == "text"){ //发送是文字时以如下方式显示，暂时没考虑如何发送/显示图片
                        var displayarea = document.getElementById("displayarea");
                        var line = document.createElement("p");

                        line.innerHTML = sender_id + ": " + content;
                        displayarea.appendChild(line);
                    }

                }
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });

}

function send(){
    //仅考虑发送的是文字
    var inputarea = document.getElementById("inputarea");
    var content = inputarea.value;
    if(content != ""){ //不可发送空白信息
        $.ajax({
            type:"POST",
            url: "/sendmessage",
            data: {chatroom_id: chatroomid, content: content, type: "text", sender_id: userid},
            dataType:"json",
            success:function(data){
                console.log(data);
                if(data.msg == "success" && data.mute != "true"){ //返回成功信息
                    var displayarea = document.getElementById("displayarea");
                    var line = document.createElement("p");
                    var img = document.createElement("img");

                    img.setAttribute("src", avatar);//头像显示！！！
                    img.setAttribute("class", "avatar");//头像的格式通过avatar class调整

                    line.appendChild(img);

                    //假定username 为 Tom,测试用
                    username = "Tom"; //需要删掉！！！

                    line.innerHTML = username + ": " + content;

                    displayarea.appendChild(line);

                    //清除inputarea value;
                    inputarea.value = "";
                }else if(data.msg == "success" && data.mute == "true"){
                    alert("Sorry you are being muted by manager!")
                }
                else{
                    alert("Something went wrong, please try again.");
                }
            }
        });
    }else{
        alert("You haven't text anything!")
    }
}

function closeChat(){
    document.getElementById("chatarea").style.display = "none";
    chatroomid = "";
}

//////////////////////////////////////////////////////////////////////
//manager page
function showViewRecords(){
    document.getElementById("view").style.display = "block";
}

function showMuteUsers(){
    document.getElementById("mute").style.display = "block";
}

function closeView(){
    document.getElementById("contact_uid").value = "";
    document.getElementById("view").style.display = "none";

}

function closeMute(){
    document.getElementById("studentid").value = "";
    document.getElementById("mute").style.display = "none";
}
//view chat history function
function submitView(){
    var inputstudentid = document.getElementById("contact_uid").value;
    //get chat history
    $.ajax({
        type:"GET",
        url: "/getchathistory",
        data: {contact_uid: inputstudentid},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){ //返回成功信息

                var count = data.count;
                for(var i = 0; i < count; i++){
                    var message = data.message.get(i); //拿到每一个message
                    var message_id = message.message_id;
                    var content = message.content;
                    var type = message.type;
                    var sender_id = message.sender_id;

                    if(type == "text"){ //发送是文字时以如下方式显示，暂时没考虑如何显示图片
                        var displayarea = document.getElementById("displayarea");
                        var line = document.createElement("p");

                        line.innerHTML = sender_id + ": " + content;
                        displayarea.appendChild(line);
                    }

                }
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//mute function, send input student id
function Mute(){
    var input = document.getElementById("studentid").value;
    $.ajax({
        type:"POST",
        url: "/mute",
        data: {contact_uid: input},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){ //返回成功信息
                alert("Mute Success");
            }
            else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//send image message function
function sendImg(source) {
    var displayarea = document.getElementById("displayarea");
    var file = source.files[0];
    if (window.FileReader) {
        var fr = new FileReader();
        fr.onloadend = function(e) {

            var avatar = document.createElement("img")
            var image = document.createElement("img")
            image.src = e.target.result;
            image.className = "sendImages"
            avatar.src = "/images/1.jpg"
            avatar.className = "avatar"
            displayarea.appendChild(avatar);
            displayarea.appendChild(image)
        };
        fr.readAsDataURL(file);
    }

    var formData = new FormData($("#imageForm")[0]);
    formData.append("file", selectimage);
    $.ajax({
        type: "POST",
        url: "/uploadImg",
        data: formData,
        processData : false,
        contentType : false ,
        cache: false,
        dataType: "json",
        success:function(data){
            console.log(data);
            if(data.msg == "success"){
                alert("File Sent Success");
            }else if(data.msg == "success" && data.mute == "true"){
                alert("Sorry you are being muted by manager!")
            }else{
                alert("Something went wrong, please try again.");
            }
        }
    });
}

//upoload avatar image function
function uploadAvatar(){
    let preview = document.getElementById('preview');
    let selectimage = document.getElementById('selectimage');

    selectimage.addEventListener("change", function() {
        preview.style.backgroundImage = '';
        let file = selectimage.files[0];
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function(event) {
            preview.src = event.target.result
        };
    });

    $("#generate").click(function () {
        var formData = new FormData($("#avatarForm")[0]);
        formData.append("file", selectimage.files[0]);
        console.log(formData)
        $.ajax({
            type: "POST",
            url: "/users/uploadAvatar",
            data: formData,
            processData : false,
            contentType : false ,
            cache: false,
            dataType: "json",
            success:function(data){
                console.log(data);
                if(data.state === 200){
                    alert("File Sent Success");
                    window.location.href = "/student";
                }else{
                    alert("Something went wrong, please try again.");
                }
            }
        });
    });

}
