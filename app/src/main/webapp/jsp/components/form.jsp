<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div>
    <form action="${pageContext.request.contextPath}/controller" method="get" id="request-form">

        <div>
            <h4>Point:</h4>
        </div>
        <div>
            <div>
                <label for="x-input">X:</label>
                <input id="x-input" class="form-control mb-3" type="text" val="0" readonly>
            </div>
            <div id="x-error"> </div>
        </div>
        <div id="x-buttons">
            <button type="button" class="btn btn-info mx-auto" value="-3.0">-3.0</button>
            <button type="button" class="btn btn-info mx-auto" value="-2.0">-2.0</button>
            <button type="button" class="btn btn-info mx-auto" value="-1.0">-1.0</button>
            <button type="button" class="btn btn-info mx-auto" value="0.0">0.0</button>
            <button type="button" class="btn btn-info mx-auto" value="1.0">1.0</button>
            <button type="button" class="btn btn-info mx-auto" value="2.0">2.0</button>
            <button type="button" class="btn btn-info mx-auto" value="3.0">3.0</button>
            <button type="button" class="btn btn-info mx-auto" value="4.0">4.0</button>
            <button type="button" class="btn btn-info mx-auto" value="5.0">5.0</button>
        </div>

        <div>
            <div id="y-error"> </div>
            <div>
                <label for="y-input">Y [-3, 3]:</label> <br>
                <input id="y-input" class="form-control" type="text" value="0">
            </div>
        </div>


        <div>
            R:
        </div>
        <div id="error-container"></div>
        <div id="r-input">
            <input id="r-input-1" type="checkbox" value="1.0" name="1.0">
            <label for="r-input-1">1.0</label>
            <input id="r-input-2" type="checkbox" value="1.5" name="1.5">
            <label for="r-input-2">1.5</label>
            <input id="r-input-3" type="checkbox" value="2.0" name="2.0">
            <label for="r-input-3">2.0</label>
            <input id="r-input-4" type="checkbox" value="2.5" name="2.5">
            <label for="r-input-4">2.5</label>
            <input id="r-input-5" type="checkbox" value="3.0" name="3.0">
            <label for="r-input-5">3.0</label>
        </div>
        <div id="r-error"></div>

        <div>
            <input type="submit" id="submit" class="btn btn-primary"> 
        </div>
    </form>
</div>