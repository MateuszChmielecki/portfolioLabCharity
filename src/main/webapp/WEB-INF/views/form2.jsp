<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../fragments/formHeader.jsp" %>
<div>
    <div>Krok <span>2</span>/4</div>
<%--@elvariable id="donation" type="pl.coderslab.charity.entity.Donation"--%>
<form:form action="form2" method="post" modelAttribute="donation">
    <!-- STEP 2 -->
    <div data-step="1" class="active form-group--inline" >
        <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

        <div>
            <label>
                Liczba 60l worków:
                <form:input path="quantity" type="number" step="1" min="1" />
            </label>
        </div>

        <div class="form-group form-group--buttons">
            <button type="button" class="btn prev-step">Wstecz</button>
            <button type="submit" class="btn">Dalej</button>
        </div>
    </div>
</form:form>


<%@include file="../fragments/formFooter.jsp" %>