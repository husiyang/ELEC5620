const express = require("express");

const app = express();
var path = require('path');
app.use(express.static(path.join(__dirname, 'public')));
app.use('/images', express.static('images'));

app.get("/", function (req, res) {
  res.sendFile(__dirname + "/start.jsp");
});

app.get("/register", function (req, res) {
  res.sendFile(__dirname + "/register.jsp");
});

app.get("/login", function (req, res) {
  res.sendFile(__dirname + "/login.jsp");
});

app.get("/avatar", function (req, res) {
  res.sendFile(__dirname + "/avatar.jsp");
});

app.get("/student", function (req, res) {
  res.sendFile(__dirname + "/student.jsp");
});

app.listen(3000, function () {
  console.log("Server is running on localhost3000");
});
