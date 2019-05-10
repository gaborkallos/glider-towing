let startButtons = document.getElementsByClassName('startTow');
let stopButtons = document.getElementsByClassName("stopTow");
let url = 'https://glider-towing.herokuapp.com/';

for (let i = 0; i < startButtons.length; i++) {
    startButtons[i].addEventListener('click', function () {
        fetch(url, {
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(startButtons[i].value),
            method: 'PUT'
        })
            .then(res => console.log(res.status))
            .catch(error => console.log(error));

    });
}

for (let i = 0; i < stopButtons.length; i++) {
    stopButtons[i].addEventListener('click', function () {
        fetch(url, {
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(stopButtons[i].value),
            method: 'PUT'
        })
            .then(res => console.log(res.status))
            .catch(error => console.log(error));

    });
}


