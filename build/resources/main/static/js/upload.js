'use strict'

let uploadForm = document.querySelector("#fileUploadForm");
let vname = document.querySelector("#title")
let desc = document.querySelector("#desc")
let uploadFormInput = document.querySelector("#fileUploadInput");
let downloadFile = document.querySelector("#downloadFileUrl");

function uploadFile(file) {
    let formData = new FormData();
    formData.append("file", file);

    let req = new XMLHttpRequest();
    req.open("POST", "http://localhost:1435/file/upload")

    
    req.send(formData);
}

uploadForm.addEventListener('submit', function (event) {
    const files = uploadFormInput.files;

    if (files.length !== 0 ) {
        uploadFile(files[0],vname,desc);
        event.preventDefault();
        
        setTimeout(function(){ window.location.href='/home';}, 1500);
    } else {
        alert('Please select a file')
    }

}, true);