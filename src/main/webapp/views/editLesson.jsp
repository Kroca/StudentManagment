<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing Lesson</title>
    <h5>Edit the lesson</h5>
    <c:choose>
        <c:when test="${empty lesson}">
            <p>You didnt select lesson to edit</p>
        </c:when>
        <c:otherwise>
            <form name="form" action="updateLesson" method="post">
                <table align="center">
                    <tr>
                        <td>Course id</td>
                        <input type="hidden" name="lesson_id" value="${lesson.getId()}"/>
                        <td><input type="text" name="course_id" value="${lesson.getCourse_id()}"/></td>
                    </tr>
                    <tr>
                        <td>Date</td>
                        <td><input type="text" name="date" value="${lesson.getDate()}"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Confirm"></input></td>
                    </tr>
                </table>
            </form>
        </c:otherwise>
    </c:choose>
</head>
<body>

</body>
</html>
