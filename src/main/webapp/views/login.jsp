<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script>
        function validate()
        {
            var login = document.form.login.value;
            var password = document.form.password.value;

            if (login==null || login=="")
            {
                alert("Username cannot be blank");
                return false;
            }
            else if(password==null || password=="")
            {
                alert("Password cannot be blank");
                return false;
            }
        }
    </script>
</head>
<body>
<div style="text-align:center"><h1>Login</h1> </div>
<br>
<form name="form" action="/login" method="post" onsubmit="return validate()">
    <!-- Do not use table to format fields. As a good practice use CSS -->
    <table align="center">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr> <!-- refer to the video to understand request.getAttribute() -->
            <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                    : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"></input><input
                    type="reset" value="Reset"></input></td>
        </tr>
        <tr>
            <td>If you are not registered yet <a href="/register"> Register here </a> </td>
        </tr>
    </table>
</form>

</body>
</html>
