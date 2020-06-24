var draw = true;
var pageLen = 10;
var originalPage = 0;
var originalPageLen = pageLen;

$(function () {

    $('#menu-error-other-dispatch').toggleClass('active');

    setDataToYearMonthSelectGrid();

    bindSelectChange();

    bindBldgSeachBtn();

    bindBldgAfterCorrSeachBtn();

    setGridPageChange();

    // setGridOrderChange();

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
        $('#tbl-other-dispatch').DataTable().ajax.reload();
    });

    $("#filter-month").on("change", function () {
        $('#tbl-other-dispatch').DataTable().ajax.reload();
    });
}

function bindBldgSeachBtn() {
    $("#btnBldgSearch").on("click", function () {
        $('#tbl-bdlg-modal').DataTable().ajax.reload();
    });
}

function bindBldgAfterCorrSeachBtn() {
    $("#btnAfterCorrSearch").on("click", function () {
        $('#tbl-bdlg-after-corr-modal').DataTable().ajax.reload();
    });
}



function setGrid() {
    $('#tbl-other-dispatch').DataTable({
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
        pageLength: pageLen,
        preDrawCallback: function (settings) {
            if (!draw) {
                draw = true;
                return false; // cancel draw
            }
        },
        ajax: {
            type: 'POST',
            url: '/api/tax/bldg-err-dispatch/find-data',
            contentType: "application/json; charset=utf-8",
            data: function (d) {
                d.year = $('#filter-year').val();
                d.month = $('#filter-month').val();
                return JSON.stringify(d);
            },
            // success: function (response) {
            //     console.log(JSON.stringify(response));
            // },
            // error: function (xhr, textStatus, error) {
            //     console.log(xhr.responseText);
            //     console.log(xhr.statusText);
            //     console.log(textStatus);
            //     console.log(error);
            // }
        },
        columns: [
            { data: 'status' },
            { data: 'errWarnCont', orderable: false },
            { data: 'bldgNm' },
            { data: 'bldgAdd' },
            { defaultContent: '', orderable: false }, // 選択(原本)
            { defaultContent: '', orderable: false }, // ビルコード(原本)
            { defaultContent: '', orderable: false }, // ビル名称(原本)
            { defaultContent: '', orderable: false }, // ビル住所(原本)
            { defaultContent: '', orderable: false }, // ビルコード(補正後)
            { defaultContent: '', orderable: false }, // ビル名称(補正後)
            { defaultContent: '', orderable: false }, // ビル住所(補正後)
            { defaultContent: '', orderable: false }, // 選択(補正後)
            { data: 'corr', orderable: false },
            { data: 'errWarnDtIds', orderable: false, visible: false }, // エラーデータID
            { defaultContent: '', orderable: false, visible: false, name: 'selectFlg' },  // ビル(原本)かつビル(補正後)選択したフラグ（選択された：1）
            { defaultContent: '', orderable: false, visible: false, name: 'bldgOrgDtId' },  // ビル(原本)のデータID
            { defaultContent: '', orderable: false, visible: false, name: 'bldgCorrDtId' },  // ビル(補正後)のデータID
        ],
        columnDefs: [
            {
                targets: 4,
                className: 'dt-body-center',
                render: function (data, type, full, meta) {
                    //return '<button type="button" id="selection' + meta.row + ' data-toggle="modal" data-target="#selectionBldgOrgModal" class="btn btn-sm btn-primary btn-datatable-size btnSelectBldgOrg">選択(原本)</button>';
                    return '<label type="button" id="selection' + meta.row + '" onClick="showBldgOrgModal(' + meta.row + ')" data-toggle="modal" class="btn btn-sm btn-primary btn-datatable-size">選択(原本)</label>';
                }
            },
            {
                targets: 8,
                className: 'dt-body-center',
                render: function (data, type, full, meta) {
                    // return '<button type="button" id="selection' + meta.row + ' data-toggle="modal" class="btn btn-sm btn-primary btn-datatable-size btnSelectBldgAfterCorr">選択(補正後)</button>';
                    return '<label type="button" id="selection' + meta.row + '" onClick="showBldgAfterCorrModal(' + meta.row + ')" data-toggle="modal" class="btn btn-sm btn-primary btn-datatable-size">選択(補正後)</label>';
                }
            },
        ],
    });
}

// $('#tbl-other-dispatch').on('click', '.btnSelectBldgOrg', function () {
//     var val = $(this).closest('tr').find('td:eq(3)').text();
//     $("#hBldgMatchAddress").val(val);
//     if (!$.fn.DataTable.isDataTable('#tbl-bdlg-modal')) {
//         setBldgModal();
//     }
//     else {
//         $('#tbl-bdlg-modal').DataTable().ajax.reload();
//     }

//     $('#selectionBldgOrgModal').modal('show');

// });

// $('#tbl-other-dispatch').on('click', '.btnSelectBldgAfterCorr', function () {
//     if (!$.fn.DataTable.isDataTable('#tbl-bdlg-after-corr-modal')) {
//         setBldgAfterCorrModal();
//     }
//     else {
//         $('#tbl-bdlg-after-corr-modal').DataTable().ajax.reload();
//     }

//     $('#selectionBldgOrgAfterCorrModal').modal('show');
// });


function setGridPageChange() {

    $('#tbl-other-dispatch').on('page.dt', function (e, settings) {
        var table = $('#tbl-other-dispatch').DataTable();
        var info = table.page.info();
        //	    $('#pageInfo').html( 'Showing page: '+info.page+' of '+info.pages );
        //		alert('Showing page: '+info.page+' of '+info.pages);
        var r = confirm('Showing page: ' + info.page + ' of ' + info.pages);

        var table = $('#tbl-other-dispatch').DataTable();
        table.rows().eq(0).each(function (index) {
            if (0 == index) {
                var row = table.row(index);
                var data = row.data();
                console.log(data);

                return false;
            }
        });

        if (r == true) {
            originalPage = settings._iDisplayStart;
            originalPageLen = settings._iDisplayLength;
        }
        else {
            draw = false;

            // Reset the current page and current page length
            settings._iDisplayStart = originalPage;
            settings._iDisplayLength = originalPageLen;
            $('[name="example_length"]').val(originalPageLen);
        }

        //table.settings()[0].jqXHR.abort(); 

    });
}

function setGridOrderChange() {

    $('#tbl-other-dispatch').on('order.dt', function () {

        var table = $('#tbl-other-dispatch').DataTable();

        var order = table.order();
        if (order.length > 0) {
            var r = confirm('order page? ');
            var table = $('#tbl-other-dispatch').DataTable();
        }
    });
}

function setBldgModal() {
    $('#tbl-bdlg-modal').DataTable({
        language: {
            url: '../i18n/modal/lang_ja.json'
        },
        sScrollX: '100%',
        sScrollXInner: '100%',
        sScrollY: 'calc(100vh - 540px)',
        sScrollCollapse: true,
        processing: true,
        serverSide: true,
        searching: false,
        pagingType: 'full_numbers',
        order: [],
        ajax: {
            type: 'POST',
            url: '/api/tax/bldg-err-dispatch/find-bldg-origin',
            contentType: "application/json; charset=utf-8",
            data: function (d) {
                d.year = $('#filter-year').val();
                d.month = $('#filter-month').val();
                d.searchCond1 = $('#hBldgMatchAddress').val();
                d.searchCond2 = $('#sBldgCd').val();
                d.searchCond3 = $('#sBldgName').val();
                d.searchCond4 = $('#sBldgAdd').val();

                return JSON.stringify(d);
            },
            // success: function (response) {
            //     console.log(JSON.stringify(response));
            // },
            // error: function (xhr, textStatus, error) {
            //     console.log(xhr.responseText);
            //     console.log(xhr.statusText);
            //     console.log(textStatus);
            //     console.log(error);
            // }
        },
        columns: [
            { data: 'buildingCodeOrigin', orderable: false },
            { data: 'buildingNameOrigin', orderable: false },
            { data: 'address', orderable: false },
            { defaultContent: '', orderable: false },
            { data: 'dataId', orderable: false, visible: false },
        ],
        columnDefs: [
            {
                targets: 3,
                className: 'dt-body-center',
                render: function (data, type, row, meta) {
                    return '<button type="button" id="selection' + meta.row + '" onClick="selectBldgOrg(' + meta.row + ')" data-toggle="modal" data-target="#selectionBldgOrgModal" class="btn btn-sm btn-primary btn-datatable-size">選択</button>';
                }
            },
        ],
    });
}

function setBldgAfterCorrModal() {
    $('#tbl-bdlg-after-corr-modal').DataTable({
        language: {
            url: '../i18n/modal/lang_ja.json'
        },
        sScrollX: '100%',
        sScrollXInner: '100%',
        sScrollY: 'calc(100vh - 540px)',
        sScrollCollapse: true,
        processing: true,
        serverSide: true,
        searching: false,
        pagingType: 'full_numbers',
        order: [],
        ajax: {
            type: 'POST',
            url: '/api/tax/bldg-err-dispatch/find-bldg-after-corr',
            contentType: "application/json; charset=utf-8",
            data: function (d) {
                d.year = $('#filter-year').val();
                d.month = $('#filter-month').val();
                d.searchCond1 = $('#sAfterCorrBldgCd').val();
                d.searchCond2 = $('#sAfterCorrBldgName').val();
                d.searchCond3 = $('#sAfterCorrBldgAdd').val();

                return JSON.stringify(d);
            },
            // success: function (response) {
            //     console.log(JSON.stringify(response));
            // },
            // error: function (xhr, textStatus, error) {
            //     console.log(xhr.responseText);
            //     console.log(xhr.statusText);
            //     console.log(textStatus);
            //     console.log(error);
            // }
        },
        columns: [
            { data: 'buildingCodeOrigin', orderable: false },
            { data: 'buildingNameOrigin', orderable: false },
            { data: 'address', orderable: false },
            { defaultContent: '', orderable: false },
            { data: 'dataId', orderable: false, visible: false },
        ],
        columnDefs: [
            {
                targets: 3,
                className: 'dt-body-center',
                render: function (data, type, row, meta) {
                    return '<button type="button" id="selection' + meta.row + '" onClick="selectBldgAfterCorr(' + meta.row + ')" data-toggle="modal" data-target="#selectionBldgAfterCorrModal" class="btn btn-sm btn-primary btn-datatable-size">選択</button>';
                }
            },
        ],

    });
}

function showBldgOrgModal(rowIndex) {
    var table = $('#tbl-other-dispatch').DataTable();
    table.rows().eq(0).each(function (index) {
        if (rowIndex == index) {
            var row = table.row(index);
            var data = row.data();
            $("#hBldgMatchAddress").val(data.bldgAdd);
            if (!$.fn.DataTable.isDataTable('#tbl-bdlg-modal')) {
                setBldgModal();
            }
            else {
                $('#tbl-bdlg-modal').DataTable().ajax.reload();
            }

            $('#selectionBldgOrgModal').modal('show');
            return false;
        }
    });
}

function showBldgAfterCorrModal(rowIndex) {
    if (!$.fn.DataTable.isDataTable('#tbl-bdlg-after-corr-modal')) {
        setBldgAfterCorrModal();
    }
    else {
        $('#tbl-bdlg-after-corr-modal').DataTable().ajax.reload();
    }

    $('#selectionBldgOrgAfterCorrModal').modal('show');
}

function selectBldgOrg(rowIndex) {

    var table = $('#tbl-other-dispatch').DataTable();
    table.rows().eq(0).each(function (index) {
        if (rowIndex == index) {
            var row = table.row(index);
            var data = row.data();
            console.log(data);
            data.status = 'AAAAAAAAAA';
            data.errWarnCont = 'bbbbbbbb';
            data.bldhNm = 'ccccc';
            data.bldgAdd = 'dddddd';
            //table.row(row).data(data).draw();
            console.log(data);
            return false;
        }
    });

    //var index = 0;
    $("#tbl-other-dispatch tbody tr").each(function (index) {
        if (rowIndex == index) {
            $(this).find("td:eq(0)").html('aaaaaaa');
            $(this).find("td:eq(5)").html('ううううううう');
            $(this).find("td:eq(6)").html('あああああああ');
            $(this).find("td:eq(7)").html('ええええええええええ');

            $(this).find("td:eq(9)").html('ううううううう');
            $(this).find("td:eq(10)").html('あああああああ');
            $(this).find("td:eq(11)").html('ええええええええええ');
            return false;
        }

        //index++;
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
                { "errWarnDtIds": "3111", "bldgOrgDtId": 11, "bldgCorrDtId": "33", "bldgNm": "ビル名称(その他派遣)", "bldgAdd": "ビル住所(その他派遣)" },
                { "errWarnDtIds": "3112", "bldgOrgDtId": 22, "bldgCorrDtId": "44", "bldgNm": "ビル名称(その他派遣)02", "bldgAdd": "ビル住所(その他派遣)02" }
            ]
        };



        var dt = JSON.stringify(rqDtUpdate);

        $.ajax({
            type: 'POST',
            url: '/api/tax/bldg-err-dispatch/update',
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





