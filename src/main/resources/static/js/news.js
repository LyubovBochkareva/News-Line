$(document).ready(function () {
    onPageSelected(1, 10);
});

var currentPage;
var countElem;


function getPage() {
    $.ajax({
        url: "/news",
        type: 'GET',
        data: {
            page: currentPage,
            size: countElem
        }
        ,
        success: function (data) {
            window.scrollTo(0, 0);
            document.getElementById("container").innerHTML = "";
            data.content.forEach(function (item) {
                var container = $("#container");
                var date = new Date(`${item.publicationDate}`);
                options = {
                    year: 'numeric', month: 'numeric', day: 'numeric',
                    hour: 'numeric', minute: 'numeric',
                    hour12: false
                };

                var dateFormat = new Intl.DateTimeFormat('en-GB', options);
                container.append(`
                  <div>
                    <p> ${item.heading} </p>
                    <p> ${dateFormat.format(date)} </p>
                    <p> ${item.text} </p>
                  
                    `);
                if (item.filename !== null) {
                    container.append(`<img name="img" src="/img/${item.filename}"/>`);
                }
                container.append(`
                   <br/></div>
                    `);
            });

            var pagination = document.querySelector(".pagination");
            var page = "";
            var pagesCount = data.pagesCount;
            for (var i = 1; i <= pagesCount; i++) {
                page += "<span onclick='onPageSelected(" + i + "," + countElem + ")' data-page=" + countElem + ">" + " " + i + "</span>";
            }
            pagination.innerHTML = page;
        }
    })
}

document.getElementById("itemsOnPage").addEventListener("click", onPageSelected);

function onPageSelected(page, itemsOnPage) {
    itemsOnPage = document.getElementById("itemsOnPage").value;
    if (countElem !== itemsOnPage) {
        page = 1;
    }
    currentPage = page;
    countElem = itemsOnPage;
    getPage();
}


$("#btnSubmit").click(function (event) {
    event.preventDefault();
    var form = $('#addNews')[0];
    var data = new FormData(form);
    $("#btnSubmit").prop("disabled", true);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/news/add",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function () {
            document.getElementById("confirmation").innerHTML = "";
            document.getElementById("messageError").innerHTML = "";
            var messageOk = $("#confirmation");
            messageOk.append("Ok! News added!");
            getPage();
            jQuery('#addNews')[0].reset();
            $('#btnSubmit').attr('disabled', false);
        },
        error: function (xhr, status, error) {
            document.getElementById("confirmation").innerHTML = "";
            document.getElementById("messageError").innerHTML = "";
            var err = xhr.responseText;
            $('#btnSubmit').attr('disabled', false);
            var messageEr = $("#messageError");
            messageEr.append(err);
        }
    });
});