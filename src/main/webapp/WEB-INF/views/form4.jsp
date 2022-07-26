<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@include file="../fragments/formHeader.jsp" %>
<div>
    <div>Krok <span>4</span>/4</div>
    <%--@elvariable id="donation" type="pl.coderslab.charity.entity.Donation"--%>
    <form:form action="form4" method="post" modelAttribute="donation">
    <div data-step="4" class="active form-group--inline">
        <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>
        <div>
            <div>
                <h4>Adres odbioru</h4>
                <div class="form-group form-group--inline">
                    <label> Ulica <form:input path="street" type="text" name="street" /> </label>
                </div>
                <div class="form-group form-group--inline">
                    <label> Miasto <form:input path="city" type="text" name="city" /> </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        Kod pocztowy <form:input path="zipCode" type="text" name="postcode" />
                    </label>
                </div>
            </div>

            <div class="form-section--column">
                <h4>Termin odbioru</h4>
                <div class="form-group form-group--inline">
                    <label> Data  <form:input type="date" path="pickUpDate" name="data" /> </label>
                </div>
                <div class="form-group form-group--inline">
                    <label> Godzina <form:input type="time" path="pickUpTime" name="time" /> </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>
                        Uwagi dla kuriera
                        <form:textarea path="pickUpComment" name="more_info" rows="5"></form:textarea>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <button type="button" class="btn prev-step">Wstecz</button>
            <button type="submit" class="btn">Dalej</button>
        </div>
    </div>
    </form:form>
<%@include file="../fragments/formFooter.jsp" %>