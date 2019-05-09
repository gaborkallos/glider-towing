let btn = document.getElementById("newData");
let errorModal = document.getElementById("errorModal");
let span = document.getElementsByClassName("close")[0];

span.onclick = function () {
    errorModal.style.display = "none";
};

window.onclick = function (event) {
    if (event.target == errorModal) {
        errorModal.style.display = "none";
    }
};

btn.addEventListener("click", function (ev) {
    let url = 'http://localhost:8080';

    let glider = {
        registrationNumber: document.getElementById("gliderReg").value.toUpperCase(),
        raceNumber: document.getElementById("gliderRace").value.toUpperCase(),
        pilotName: document.getElementById("pilotName").value.toUpperCase(),
        category: document.getElementById("category").value.toUpperCase(),
        isFlying: false
    };

    let tow = {
        registrationNumber: document.getElementById('towingReg').value.toUpperCase(),
        isFlying: false
    };

    let flight = {
        glider: glider,
        towingAirplane: tow,
    };

    if (glider.registrationNumber != "" && glider.pilotName != "") {
        fetch(url + "/airplane", {
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(flight),
            method: 'POST'
        })
            .then(res => console.log(res.status))
            .catch(error => console.log(error));

    } else {
        errorModal.style.display = "block";
        console.log(errorModal);
    }


});
