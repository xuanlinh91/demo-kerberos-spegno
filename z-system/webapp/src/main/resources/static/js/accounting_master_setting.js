$(function () {
    $('#menuMasterSetting').toggleClass('active');

    $('#tblMasterData').DataTable({
            sScrollX: '100%',
            sScrollXInner: '100%',
            sScrollY: 'calc(100vh - 305px)',
            sScrollCollapse: true,
//            ajax: {
//                type : 'GET',
//                url : '/api/',
//                datatype: 'json',
//                dataSrc: 'data'
//            },
//            columns: []
        });
});
