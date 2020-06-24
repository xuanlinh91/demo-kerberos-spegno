$(function () {
    $('#menu-error-bldg-master').toggleClass('active');

    setDataToYearMonthSelectGrid();

    bindSelectChange();
});

function setDataToYearMonthSelectGrid() {
    $.get("/api/master/accounting-period", function (data, status) {
        var options = "";
        for (var i = 0; i < data.accountingPeriodYears.length; i++) {
            options += '<option value="' + data.accountingPeriodYears[i] + '">' + data.accountingPeriodYears[i] + '年度</option>';
        }
        $("#filter-year").html(options);

        options = "";
        for (var i = 0; i < data.accountingPeriodMonths.length; i++) {
            options += '<option value="' + data.accountingPeriodMonths[i] + '">' + data.accountingPeriodMonths[i] + '月</option>';
        }
        $("#filter-month").html(options);
        $("#filter-month").val(data.lastMonth);
    }).done(function () {
        setGrid();
    });
}

function bindSelectChange() {
    $("#filter-year").on("change", function () {
        $('#tbl-bldg-master').DataTable().ajax.reload();
    });

    $("#filter-month").on("change", function () {
        $('#tbl-bldg-master').DataTable().ajax.reload();
    });
}

function setGrid() {
    $('#tbl-bldg-master').DataTable({
        language: {
            url: '../i18n/datatables/lang_ja.json'
        },
        sScrollX: '100%',
        sScrollXInner: '100%',
        sScrollY: 'calc(100vh - 290px)',
        sScrollCollapse: true,
        processing: true,
        serverSide: true,
        searching: false,
        pageLength: 20,
        lengthMenu: [20, 50, 100],
        pagingType: 'full_numbers',
        order: [],
        ajax: {
            type: 'POST',
            url: '/api/tax/bldg-err-bldg/find-data',
            contentType: "application/json; charset=utf-8",
            data: function (d) {
                d.year = $('#filter-year').val();
                d.month = $('#filter-month').val();
                return JSON.stringify(d);
            },
            //            success: function (response) {
            //                console.log(JSON.stringify(response));
            //            },
            //            error: function(xhr, textStatus, error) {
            //                console.log(xhr.responseText);
            //                console.log(xhr.statusText);
            //                console.log(textStatus);
            //                console.log(error);
            //            }
        },
        columns: [
            { data: 'status' },
            { data: 'errWarnCont', "orderable": false },
            { data: 'bldgCd' },
            { data: 'bldgNm' },
            { data: 'corr', "orderable": false },
        ],
    });
}

