$(function () {
    $('#menu-error-floor-area').toggleClass('active');

    setDataToYearMonthSelectGrid();

    bindSelectChange();

    //    setModal();

    bindBtnReflection();

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
        $('#tbl-floor-area').DataTable().ajax.reload();
    });

    $("#filter-month").on("change", function () {
        $('#tbl-floor-area').DataTable().ajax.reload();
    });
}

function setGrid() {
    $('#tbl-floor-area').DataTable({
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
            url: '/api/tax/bldg-err-floor/find-data',
            contentType: "application/json; charset=utf-8",
            data: function (d) {
                d.year = $('#filter-year').val();
                d.month = $('#filter-month').val();
                return JSON.stringify(d);
            },
            //             success: function (response) {
            //                 console.log(JSON.stringify(response));
            //             },
            // error: function (xhr, textStatus, error) {
            //     console.log(xhr.responseText);
            //     console.log(xhr.statusText);
            //     console.log(textStatus);
            //     console.log(error);
            // }
        },
        columns: [
            { data: 'status' },
            { data: 'errWarnCont', "orderable": false },
            { data: 'bldgNm' },
            { data: 'bldgAdd' },
            { "orderable": false },
            { data: 'corr', "orderable": false },
        ],
        columnDefs: [
            {
                targets: 4,
                searchable: false,
                orderable: false,
                className: 'dt-body-center',
                render: function (data, type, full, meta) {
                    return '<button type="button" id="selection' + meta.row + '" onClick="showModal()" data-toggle="modal" data-target="#selectionModal" class="btn btn-sm btn-primary btn-datatable-size">選択</button>';
                }
            },
        ],
    });
}

function bindBtnReflection() {
    $("#btnReflection").on("click", function () {

        // error data
        //        var rqDtUpdate = {
        //            "accPeriod": { "year": 1, "month": 14 },
        //            "bldgErrList": [
        //                { "errWarnDtIds": "1,2,3", "bldgOrgDtId": "11", "bldgCorrDtId": "33", "bldgNm": "ビル名称(その他派遣)", "bldgAdd": "ビル住所(その他派遣)" },
        //                { "errWarnDtIds": "4", "bldgOrgDtId": "22", "bldgCorrDtId": "44", "bldgNm": "   ", "bldgAdd": "buildingAddress"}
        //            ]
        //        };

        // update data
        // var rqDtUpdate = {
        //     "accPeriod": { "year": 2020, "month": 4 },
        //     "bldgErrList": [
        //         { "errWarnDtIds": "1,2,3", "bldgOrgDtId": 11, "bldgCorrDtId": "33", "bldgNm": "ビル名称(その他派遣)", "bldgAdd": "ビル住所(その他派遣)" },
        //         { "errWarnDtIds": "4", "bldgOrgDtId": 22, "bldgCorrDtId": "44", "bldgNm": "ビル名称(その他派遣)02", "bldgAdd": "ビル住所(その他派遣)02"}
        //     ]
        // };

        var rqDtUpdate = {
            "accPeriod": { "year": 2020, "month": 4 },
            "bldgErrList": [
                { "errWarnDtIds": "3110", "bldgOrgDtId": 11, "bldgCorrDtId": "33", "bldgNm": "ビル名称(その他派遣)", "bldgAdd": "ビル住所(その他派遣)" },
                { "errWarnDtIds": "3112", "bldgOrgDtId": 22, "bldgCorrDtId": "44", "bldgNm": "ビル名称(その他派遣)02", "bldgAdd": "ビル住所(その他派遣)02" }
            ]
        };



        var dt = JSON.stringify(rqDtUpdate);

        $.ajax({
            type: 'POST',
            url: '/api/tax/bldg-err-floor/update',
            contentType: "application/json; charset=utf-8",
            data: dt,
            statusCode: {
                200: function (response) {
                    alert('1');
                    console.log(response);
                },
                400: function (response) {
                    alert('2');
                    console.log(response.responseJSON.msgList);
                },
                403: function (response) {
                    alert('3');
                    console.log(response);
                },
                500: function (response) {
                    alert('4');
                    console.log(response);
                }
            }
        });
    });
}
