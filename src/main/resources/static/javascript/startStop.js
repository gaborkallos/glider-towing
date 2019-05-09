let startButtons = document.getElementsByClassName('startTow');
let stopButtons = document.getElementsByClassName("stopTow");

for (let i = 0; i < startButtons.length; i++) {
    startButtons[i].addEventListener('click', function () {
        console.log(startButtons[i].value);

    });
}


for (let i = 0; i < startButtons.length; i++) {
    stopButtons[i].addEventListener('click', function () {
        console.log(stopButtons[i].value);

    });
}


