var draw = true;
var pageLen = 10;
var originalPage = 0;
var originalPageLen = pageLen;

$(function () {
    $('#menu-update-bldg-master').toggleClass('active');

    setDataToYearMonthSelectGrid();

    bindSelectChange();

    bindBldgSeachBtn();

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
        $('#tbl-bldg-master').DataTable().ajax.reload();
    });

    $("#filter-month").on("change", function () {
        $('#tbl-bldg-master').DataTable().ajax.reload();
    });
}

function bindBldgSeachBtn() {
    $("#btnBldgSearch").on("click", function () {
        $('#tbl-bdlg-modal').DataTable().ajax.reload();
    });
}

function setGrid() {

    $('#tbl-bldg-master').DataTable({
        language: {
            url: '../i18n/datatables/lang_ja.json'
        },
        sScrollX: '100%',
        sScrollXInner: '100%',
        sScrollY: 'calc(100vh - 340px)',
        sScrollCollapse: true,
        processing: true,
        serverSide: true,
        searching: false,
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
            url: '/api/tax/bldg-update-bldg/find-data',
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
            { data: 'companyCode' }, // 会社コード
            { data: 'companyName', orderable: false }, // 会社名称
            { data: 'id.companyBuidingCode' }, // 会社別ビルコード
            { data: 'buildingCode' }, // ビルコード
            { data: 'buildingName' }, // ビル名称
            { data: 'address' }, // ビル住所
            { defaultContent: '', orderable: false }, // 選択(原本)
            { data: 'buildingCodeCorrection', orderable: false }, // ビルコード(補正後)
            { data: 'buildingNameCorrection', orderable: false }, // ビル名称(補正後)
            { data: 'addressCorrection', orderable: false }, // ビル住所(補正後)
            { data: 'changedMonth' }, // 変更月
            { data: 'changedReason' }, // 変更理由
            { defaultContent: '', orderable: false, visible: false, name: 'selectFlg' },  // ビル(原本)選択したフラグ（選択された：1）
            { defaultContent: '', orderable: false, visible: false, name: 'bldgOrgDtId' },  // ビル(原本)のデータID
        ],
        columnDefs: [
            {
                targets: 6,
                className: 'dt-body-center',
                render: function (data, type, full, meta) {
                    return '<label type="button" id="selection' + meta.row + '" onClick="showBldgOrgModal(' + meta.row + ')" data-toggle="modal" class="btn btn-sm btn-primary btn-datatable-size">選択</label>';
                }
            },
        ],
    });
}

function setGridPageChange() {
}

function showBldgOrgModal(rowIndex) {

    if (!$.fn.DataTable.isDataTable('#tbl-bdlg-modal')) {
        setBldgModal();
    }
    else {
        $('#tbl-bdlg-modal').DataTable().ajax.reload();
    }

    $('#selectionBldgOrgModal').modal('show');
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
            url: '/api/tax/bldg-err-dispatch/find-bldg-after-corr',
            contentType: "application/json; charset=utf-8",
            data: function (d) {
                d.year = $('#filter-year').val();
                d.month = $('#filter-month').val();
                d.searchCond1 = $('#sBldgCd').val();
                d.searchCond2 = $('#sBldgName').val();
                d.searchCond3 = $('#sBldgAdd').val();

                return JSON.stringify(d);
            },
            //  success: function (response) {
            //      console.log(JSON.stringify(response));
            //  },
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

function selectBldgOrg(rowIndex) {
    alert(rowIndex);
}

function bindBtnReflection() {
    $("#btnReflection").on("click", function () {
        var rqDtUpdate = {
            "accPeriod": { "year": 2020, "month": 4 },
            "bldgList": [
                { "bldgOrgDtId": 1, "cmpBldgCd": "11", "changeMonth": "2018年度（自由入力）", "changeReason": "変更理由０１" },
                { "bldgOrgDtId": 2, "cmpBldgCd": "22", "changeMonth": "2019年度（自由入力）", "changeReason": "変更理由０2" },
            ]
        };

        var dt = JSON.stringify(rqDtUpdate);

        $.ajax({
            type: 'POST',
            url: '/api/tax/bldg-update-bldg/update',
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
                500: function (response) {
                    alert('4');
                    console.log(response);
                }
            }
        });
    });
}
