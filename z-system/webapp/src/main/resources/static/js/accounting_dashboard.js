$(function () {
    var dataTableData = [
        // 定額取引（自社請求側）
        {
            tableName: '#gkan',
            url: '/api/incomplete/',
            columnData: [
                { data: null },
                { data: null },
                { data: null },
                { data: null },
            ]
        },
        {
            tableName: '#non-gkan',
            url: '/api/incomplete/',
            columnData: [
                { data: null },
                { data: null },
                { data: null },
                { data: null },
            ]
        },
        {
            tableName: '#summary',
            url: '/api/incomplete/',
            columnData: [
                { data: null },
                { data: null },
                { data: null },
                { data: null },
            ]
        },
    ];

    $('#menuDashboard').toggleClass('active');

    $("#filter-year").on("change", function () {
        reloadAjax();
    });

    $("#filter-month").on("change", function () {
        reloadAjax();
    });

    for (let index = 0; index < dataTableData.length; index++) {
        var data = dataTableData[index];
        showDataTable(data);
    }

    function reloadAjax() {
        for (let index = 0; index < dataTableData.length; index++) {
            $(dataTableData[index].tableName).DataTable().ajax.reload();
        }
    }

    function showDataTable(data) {
        $(data.tableName).DataTable({
            language: {
                url: '../i18n/datatables/lang_ja.json',
            },
            processing: true,
            serverSide: true,
            searching: false,
            paging: false,
            ordering: false,
            ajax: {
                url : data.ajaxUrl,
                data: function (d) {
                    d.year = $('#filter-year').val();
                    d.month = $('#filter-month').val();
                    return JSON.stringify(d);
                }
            },
            columns: data.columnData,
        });
    }
});
