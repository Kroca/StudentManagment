<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home page</title>
</head>
<center><h2>Home Page</h2></center>

Welcome <c:out value="${login}" />
<c:choose>
    <c:when test="${empty schedule}">
        You have no classes.
    </c:when>
    <c:otherwise>
        <p> Your classes are below</p>
        <table>
            <c:forEach var="sch" items="${schedule}">
                <tr>
                    <td><c:out value="${sch.getLesson().getCourse().getSubject()}"></c:out></td>
                    <td><c:out value="${sch.getLesson().date}"></c:out></td>
                    <c:choose>
                        <c:when test="${role == 'admin'}" >
                            <td>
                                <form method="post" action="editLesson">
                                    <input type="hidden" name="lessonId" value="${sch.getLesson().getId()}"/>
                                    <input type="submit" value="Редактировать"/>
                                </form>
                            </td>
                            <td>
                                <form method="post" action="deleteLesson">
                                    <input type="hidden" name="lessonId" value="${sch.getLesson().getId()}"/>
                                    <input type="submit" value="Удалить"/>
                                </form>
                            </td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>


<p><span style="color:green"><%=(request.getAttribute("message") == null) ? ""
        : request.getAttribute("message")%></span></p>
<div style="text-align: right"><a href="/logout">Logout</a></div>
</body>
</html>
