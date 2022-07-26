<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../fragments/formHeader.jsp" %>
<div>
    <div>Krok <span>3</span>/4</div>
    <%--@elvariable id="donation" type="pl.coderslab.charity.entity.Donation"--%>
    <form:form action="form3" method="post" modelAttribute="donation">

    <!-- STEP 4 -->
    <div data-step="3" class="active form-group--inline">
        <h3>Wybierz organizacje, której chcesz pomóc:</h3>
        <c:forEach items="${institutions}" var="item">
        <div>
            <label>
                <input type="radio" name="institution" value="${item.id}" />
                <span class="checkbox radio"></span>
                <span class="description">
                  <div class="title">Fundacja "${item.name}"</div>
                  <div class="subtitle">${item.description}</div>
                </span>
            </label>
        </div>
        </c:forEach>
        <div class="form-group form-group--buttons">
            <button type="button" class="btn prev-step">Wstecz</button>
            <button type="submit" class="btn">Dalej</button>
        </div>
    </div>
    </form:form>

<%@include file="../fragments/formFooter.jsp" %>