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
    let pilot = {
        name: document.getElementById("pilotName").value.toUpperCase(),
        isFlying: false
    };

    let glider = {
        registrationNumber: document.getElementById("gliderReg").value.toUpperCase(),
        raceNumber: document.getElementById("gliderRace").value.toUpperCase(),
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
        gliderPilot: pilot
    };

    if (glider.registrationNumber !== "" && pilot.name !== "") {
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
