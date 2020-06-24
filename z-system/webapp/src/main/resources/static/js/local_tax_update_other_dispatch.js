$(function () {
    $('#menu-update-other-dispatch').toggleClass('active');

    $('#tbl-other-dispatch').DataTable({
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
//        ajax: {
//            type : 'GET',
//            url : '/api/',
//            datatype: 'json',
//            dataSrc: 'data'
//        },
//        columns: [],
    });

});

