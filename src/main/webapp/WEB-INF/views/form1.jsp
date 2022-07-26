<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../fragments/formHeader.jsp" %>
<div class="form--steps-container">
    <div class="form--steps-counter">Krok <span>1</span>/4</div>
<%--@elvariable id="donation" type="pl.coderslab.charity.entity.Donation"--%>
<form:form action="form1" method="post" modelAttribute="donation">
    <!-- STEP 1: class .active is switching steps -->
    <div data-step="1" class="active">
        <h3>Zaznacz co chcesz oddać:</h3>
        <c:forEach items="${categories}" var="item">
            <div class="form-group form-group--checkbox">
                <label>
                    <input path="categories" type="checkbox"
                           name="categories"
                           value="${item.id}"
                    />
                    <span class="checkbox"></span>
                    <span class="description"
                    ><c:out value="${item.name}"></c:out></span
                    >
                </label>
            </div>
        </c:forEach>
        <div class="form-group form-group--buttons">
            <button type="submit" class="btn">Dalej</button>
        </div>
    </div>
</form:form>


<%@include file="../fragments/formFooter.jsp" %>