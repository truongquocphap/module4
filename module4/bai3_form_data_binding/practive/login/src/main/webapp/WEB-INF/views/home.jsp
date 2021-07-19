<%--
  Created by IntelliJ IDEA.
  User: truongquocphap
  Date: 7/16/21
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form:form action="login" method="post" modelAttribute="login">
    <fieldset>
      <legend>Login</legend>
      <table>
        <tr>
          <td><form:label path="account">Account:</form:label></td>
          <td><form:input path="account"  /></td>
        </tr>
        <tr>
          <td><form:label path="password">Password:</form:label></td>
          <td><form:input path="password"/></td>
        </tr>
        <tr>
          <td></td>
          <td><form:button>Login</form:button></td>
        </tr>
      </table>
    </fieldset>
  </form:form>
  </body>
</html>
