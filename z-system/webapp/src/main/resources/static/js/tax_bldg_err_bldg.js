$(function () {
    $('#menuIncomplete').toggleClass('active');
    
    $('#tblIncomplete').DataTable({
        sScrollX: '100%',
        sScrollXInner: '100%',
        sScrollY: 'calc(100vh - 295px)',
        sScrollCollapse: true,
        processing: true,
        serverSide: true,
        "pagingType": "full_numbers",
        "searching": false,
        ajax: {
            type : 'POST',
            url : '/api/tax/bldg-err-bldg/find-data',
//            url : '/api/tax/bldg-err-dispatch/find-data',
            "contentType" : "application/json; charset=utf-8",
            "data": function ( d ) {
            	d.year = $('#year').val();
            	d.month = $('#month').val();
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
            { data: 'errorWarningContent' , "orderable": false},
            { data: 'buildingCode' },
            { data: 'buildingName' },
            { data: 'correspondence', "orderable": false },
            
        ],
        "columnDefs": [ 
        	{ "targets": 0,
                mRender : function(data, type, full) {
                  return '<input type="text" name="col1" value="'+data+'"/>'
                } 
            },
            { "targets": 1,
                mRender : function(data, type, full) {
                  return '<input type="text" name="col2" value="'+data+'"/>'
                } 
            } 
        ],
    });
    
    $("#year").on("change",function(){
        var val=$(this).val();
        var table = $('#tblIncomplete').DataTable();
        table.search('').draw();
    });
    
    $("#month").on("change",function(){
        var val=$(this).val();
        var table = $('#tblIncomplete').DataTable();
        table.search('').draw();
    });

});

