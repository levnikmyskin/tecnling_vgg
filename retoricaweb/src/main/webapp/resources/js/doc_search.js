$(document).ready(function () {
    $('#docSearchForm').submit(function (event) {
        event.preventDefault();
        $.post($(this).attr('action'), $(this).serialize(), function (data) {
            $('#table_cont').html(data);
        })
    })
});