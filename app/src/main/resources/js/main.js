$(document).ready(function() {
    const NUMBER_REGEX = /^(\-)?[0-9]+(\.[0-9]{1,15})?$/

    const xButtons = $("#x-buttons button")
    const xInput = $("#x-input")

    const yInput = $("#y-input")
    const yErrorMessage = "Y must be in [-3, 3] and have no more than 15 digits after decimal"

    const rCheckboxes = $("#r-input input:checkbox")
    const rErrorMessage = "R must be selected"

    const submitButton = $("#submit")
    const clearButton = $("#clear")

    checkForErrors()

    if (!localStorage.getItem("results")) {
        localStorage.setItem("results", "")
    } else {
        populateTableWithLocalStorage()
    }

    xButtons.each(function() {
        $(this).on("click", (e) => {
            xInput.val($(this).val())
        })
    })

    $(yInput).on("input", function() {
        checkForErrors()
    })

    function isYValid() {
        let y = yInput.val()
        if (!NUMBER_REGEX.test(y)) return false
        y = parseFloat(y)
        if (!(y < 3 && y > -3)) return false
        return true
    }

    $(rCheckboxes).on("click", function () {
        if ($(this).is(":checked")) {
            $(rCheckboxes).not(this).prop("checked", false)
        }
        checkForErrors()
    })

    function isRValid() {
        return $("#r-input input:checkbox:checked").length == 1
    }

    function checkForErrors() {
        if (!isYValid()) $("#y-error").html(yErrorMessage)
        else $("#y-error").html("")
        if (!isRValid()) $("#r-error").html(rErrorMessage)
        else $("#r-error").html("")
    }

    function request(x, y, r) {
        $.ajax({
            url: "/app/controller",
            type: "POST",
            dataType: "html",
            data: {
                x: x,
                y: y,
                r: r,
            },
            success: addResults
        })
    }

    function convertFromEpochToCurrentTimezone(epochTime) {
        const options = {
            timeZone: Intl.DateTimeFormat().resolvedOptions().timeZone,
            year: "numeric",
            month: "long",
            day: "numeric",
            hour: "2-digit",
            minute: "2-digit",
            second: "2-digit",
            timeZoneName: "short"
        }
        const dateObject = new Date(Number(epochTime))

        return dateObject.toLocaleString("en-US", options)
    }

    function addResults(result) {
        const resultWithTime = $(result).append("<td id=\"time\">" + Date.now() + "</td>")
        localStorage.setItem("results", resultWithTime.prop("outerHTML") + (localStorage.getItem("results") ? "&" : "") + localStorage.getItem("results"))
        addToTable(resultWithTime.prop("outerHTML"))
    }

    function addToTable(html) {
        const epochTime = $(html).find("#time").text()
        const htmlWithTimezone = $(html).find("#time").text(convertFromEpochToCurrentTimezone(epochTime)).parent().prop("outerHTML")
        $("#results-body").html(htmlWithTimezone + $("#results-body").html());
    }

    function populateTableWithLocalStorage() {
        const storage = localStorage.getItem("results").split("&")
        for (const result of storage) {
            addToTable(result)
        }
    }

    function areInputsValid() {
        return isYValid() && isRValid()
    }

    function getInputs() {
        x = parseFloat(xInput.val())
        y = parseFloat(yInput.val())
        r = parseFloat($("#r-input input:checkbox:checked").val())
        
        return {x: x, y: y, r: r}
    }

    submitButton.on("click", function (e) {
        e.preventDefault()
        if (areInputsValid()) {
            const inputs = getInputs() 
            request(inputs.x, inputs.y, inputs.r)
        }
    })

    clearButton.on("click", function (e) {
        localStorage.setItem("results", "")
        $("#results-body").html("")
    })
})

