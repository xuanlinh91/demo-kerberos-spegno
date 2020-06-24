$(function () {
    $('#menuUnaccepted').toggleClass('active');

    $('#btn-filter').click(function(e) {
        e.preventDefault();

        $('#tbl-unaccepted').DataTable().ajax.reload();
    });

    $('#tbl-unaccepted').DataTable({
        language: {
            url: '../i18n/datatables/lang_ja.json'
        },
        sScrollX: '100%',
        sScrollXInner: '100%',
        sScrollY: 'calc(100vh - 340px)',
        sScrollCollapse: true,
        processing: true,
        serverSide: true,
        pagingType: 'full_numbers',
        pageLength: 20,
        lengthMenu: [20, 50, 100],
        ajax: {
            url : '/api/unaccepted',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: function(d) {
                d.fiscalPeriod = $("#filter-year").val() + $("#filter-month").val();
                return JSON.stringify( d );
            },
        },
        // No default sorting (column 0 will be sorted ascending by default)
        order: [],
        columns: [
            { defaultContent: 0 }, // 問い合わせ用のチェックボックス
            { defaultContent: 1 }, //No
            { name: 'reminderExclusion', data: 'progressData.reminderExclusion' }, //催促除外
            { defaultContent: "123456" }, //問合せNo
            { defaultContent: "問合せステータス" }, //問合せステータス
            { name: 'judgement', data: 'progressData.judgement' },  //判定(問合せBox)
            { name: 'remark', data: 'progressData.remark' }, //処理状況(問合せBox)
            { name: 'baJudgement', data: 'progressData.baJudgement' }, //判定
            { name: 'processingStatus', data: 'progressData.processingStatus' }, //処理状況
            { name: 'baComment', data: 'progressData.baComment' }, //自由記入欄
            { name: 'updateUser', data: 'progressData.updateUser' }, //更新者
            { name: 'salesSlipNumber', data: 'reportData.salesSlipNumber' }, //伝票番号
            { defaultContent: "期末計上結果判定" }, //期末計上結果判定
            { name: 'accountingOrgName', data: 'reportData.accountingOrgName' },    //会計組織名
            { name: 'accountingOrgCode', data: 'reportData.accountingOrgCode' },    //会計組織コード
            { name: 'depaCode', data: 'reportData.depaCode' },  //部課コード
            { name: 'depaName', data: 'reportData.depaName' },  //部課名
            { name: 'remarks3', data: 'reportData.slipCreator' },   //伝票作成者
            { name: 'assignment', data: 'reportData.assignment' }, //所属
            { name: 'phoneNumber', data: 'reportData.phoneNumber' },    //電話番号
            { name: 'inscriptionYearMonthDay', data: 'reportData.inscriptionYearMonthDay' },    //検収年月日
            { name: 'slipDescription', data: 'reportData.slipDescription' },    //伝票摘要
            { name: 'traAmt', data: 'reportData.traAmt' },  //取引金額
            { name: 'dataTypeDetailedName', data: 'reportData.dataTypeDetailedName' }, //データ種別詳細名
            { name: 'slipType', data: 'reportData.slipType' }, //取引先コード
            { name: 'customerCode', data: 'reportData.customerCode' }, //取引先コード
            { name: 'traName', data: 'reportData.traName' }, //取引先名
            { name: 'mailAddress', data: 'reportData.mailAddress' },    //メールアドレス
            { name: 'addressBit', data: 'reportData.addressBit' },      //アドレスビット
            { name: 'referenceDate', data: 'reportData.referenceDate' },        //資料年月
            { name: 'dataTypeCode', data: 'reportData.dataTypeCode' },          //データ種別コード
            { name: 'dataTypeDetailedCode', data: 'reportData.dataTypeDetailedCode' },      //データ種別詳細コード
            { name: 'managementNumber', data: 'reportData.managementNumber' },              //キー
            { name: 'departmentMasterInfo', data: 'reportData.departmentMasterInfo' },      //部課マスタ情報
            { name: 'procYearMonthDay', data: 'reportData.unacceptedDataDate' },            //未検収・未承認データ年月日
            { name: 'contractRegistrationNumber', data: 'reportData.contractRegistrationNumber' },      //契約登録番号等
        ],
        columnDefs: [
            {
                targets: 0,
                orderable: false,
                className: 'select-checkbox',
            },
            {
                targets: 'col-ba-judgement',
                render: function ( data, type, row, meta ) {
                    return '<select id="judgement' + meta.row +'" onChange="saveData(event)"><option>Option 1</option><option>Option 2</option><option>Option 3</option></select>';
                }
            },
            {
                targets: 'col-ba-progress-status',
                render: function ( data, type, row, meta ) {
                    return '<input type="text" id="processingStatus' + meta.row + '" onblur="saveData(event)" value="' + data + '" /> ';
                }
            },
            {
                targets: 'col-ba-comment',
                render: function ( data, type, row, meta ) {
                    return '<input type="text" id="freeEntry' + meta.row + '" onblur="saveData(event)" value="' + data + '" /> ';
                }
            },
            {
                targets: 'no-sort',
                orderable: false,
            },
            {
                targets: 'no-search',
                searchable: false,
            },
        ],
    });
});
