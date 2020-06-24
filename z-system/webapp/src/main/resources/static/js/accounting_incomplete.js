$(function () {
    var DEFAULT_SHEET_ID = $('#filter-sheetname').find('option:first-child').val();

    var responseData = [];

    var dataTableData = {
        // 定額取引（自社請求側）
        1: {
            url: '/api/incomplete/FlatRateTraInHbs',
            columnData: [
                { name: 'accountingReportDataId', data: 'reportData.accountingReportDataId' },
                { name: 'reminderExclusion', data: 'progressData.reminderExclusion' },
//                問合せNo
                { defaultContent: "123456" },
//                問合せステータス
                { defaultContent: "問合せステータス" },
                { name: 'judgement', data: 'progressData.judgement' },
                { name: 'processingStatus', data: 'progressData.processingStatus' },
                { name: 'baJudgement', data: 'progressData.baJudgement' },
                { name: 'processingStatus', data: 'progressData.baProcessingStatus' },
                { name: 'baComment', data: 'progressData.baComment' },
                { name: 'updateUser', data: 'progressData.updateUser' },
//                期末計上結果判定
                { defaultContent: "期末計上結果判定" },
                { name: 'flatRateTraInHbsStatus', data: 'reportData.flatRateTraInHbsStatus' },
                { name: 'flatRateTraInHbsOwnCompanyNameBldging', data: 'reportData.flatRateTraInHbsOwnCompanyNameBldging' },
                { name: 'flatRateTraInHbsOtherCompanyName', data: 'reportData.flatRateTraInHbsOtherCompanyName' },
                { name: 'flatRateTraInHbsContractRegistrationNumber', data: 'reportData.flatRateTraInHbsContractRegistrationNumber' },
                { name: 'flatRateTraInHbsContractSbj', data: 'reportData.flatRateTraInHbsContractSbj' },
                { name: 'flatRateTraInHbsBldgingSideOrgCode', data: 'reportData.flatRateTraInHbsBldgingSideOrgCode' },
                { name: 'flatRateTraInHbsBldgingSideOrgName', data: 'reportData.flatRateTraInHbsBldgingSideOrgName' },
                { name: 'flatRateTraInHbsBldgingSideSectionCode', data: 'reportData.flatRateTraInHbsBldgingSideSectionCode' },
                { name: 'flatRateTraInHbsBldgingSideSectionName', data: 'reportData.flatRateTraInHbsBldgingSideSectionName' },
                { name: 'flatRateTraInHbsPayingSideOrgCode', data: 'reportData.flatRateTraInHbsPayingSideOrgCode' },
                { name: 'flatRateTraInHbsPayingOrgName', data: 'reportData.flatRateTraInHbsPayingOrgName' },
                { name: 'flatRateTraInHbsPaymentSectionCode', data: 'reportData.flatRateTraInHbsPaymentSectionCode' },
                { name: 'flatRateTraInHbsPayingSideSectionName', data: 'reportData.flatRateTraInHbsPayingSideSectionName' },
                { name: 'flatRateTraInHbsCntDate', data: 'reportData.flatRateTraInHbsCntDate' },
                { name: 'flatRateTraInHbsFirstBldgingAmt', data: 'reportData.flatRateTraInHbsFirstBldgingAmt' },
                { name: 'flatRateTraInHbsMonthlyBldgingAmt', data: 'reportData.flatRateTraInHbsMonthlyBldgingAmt' },
                { name: 'flatRateTraInHbsLastBldgingAmt', data: 'reportData.flatRateTraInHbsLastBldgingAmt' },
                { name: 'flatRateTraInHbsBldgingSideAcptCntStatus', data: 'reportData.flatRateTraInHbsBldgingSideAcptCntStatus' },
                { name: 'flatRateTraInHbsPaymentSideAcptCntStatus', data: 'reportData.flatRateTraInHbsPaymentSideAcptCntStatus' },
                { name: 'flatRateTraInHbsContactPerson', data: 'reportData.flatRateTraInHbsContactPerson' },
                { name: 'flatRateTraInHbsTel', data: 'reportData.flatRateTraInHbsTel' },
                { name: 'flatRateTraInHbsContactPersonEmailAddress', data: 'reportData.flatRateTraInHbsContactPersonEmailAddress' },
                { name: 'flatRateTraInHbsInHouseContact', data: 'reportData.flatRateTraInHbsInHouseContact' },
                { name: 'flatRateTraInHbsInHouseContactTel', data: 'reportData.flatRateTraInHbsInHouseContactTel' },
                { name: 'flatRateTraInHbsEmailAddress', data: 'reportData.flatRateTraInHbsEmailAddress' },
                { name: 'flatRateTraInHbsDaysSinceCntDate', data: 'reportData.flatRateTraInHbsDaysSinceCntDate' },
                { name: 'area', data: 'progressData.area' },
                { name: 'processingGuide', data: 'progressData.processingGuide' },
            ]
        },
        // 定額取引（自社支払側）
        2: {
            url: '/api/incomplete/FlatRateTraOwn',
            columnData: [
                { name: 'accountingReportDataId', data: 'reportData.accountingReportDataId' },
                { name: 'reminderExclusion', data: 'progressData.reminderExclusion' },
//                問合せNo
                { defaultContent: "123456" },
//                問合せステータス
                { defaultContent: "問合せステータス" },
                { name: 'judgement', data: 'progressData.judgement' },
                { name: 'processingStatus', data: 'progressData.processingStatus' },
                { name: 'baJudgement', data: 'progressData.baJudgement' },
                { name: 'processingStatus', data: 'progressData.baProcessingStatus' },
                { name: 'baComment', data: 'progressData.baComment' },
                { name: 'updateUser', data: 'progressData.updateUser' },
//                期末計上結果判定
                { defaultContent: "期末計上結果判定" },
                { name: 'flatRateTraOwnPsStatus', data: 'reportData.flatRateTraOwnPsStatus' },
                { name: 'flatRateTraOwnPsOwnComanyNamePaymentSide', data: 'reportData.flatRateTraOwnPsOwnComanyNamePaymentSide' },
                { name: 'flatRateTraOwnPsOtherCompanyName', data: 'reportData.flatRateTraOwnPsOtherCompanyName' },
                { name: 'flatRateTraOwnPsContractRegistrationNumber', data: 'reportData.flatRateTraOwnPsContractRegistrationNumber' },
                { name: 'flatRateTraOwnPsContractSbj', data: 'reportData.flatRateTraOwnPsContractSbj' },
                { name: 'flatRateTraOwnPsBldgingSideOrgCode', data: 'reportData.flatRateTraOwnPsBldgingSideOrgCode' },
                { name: 'flatRateTraOwnPsBldgingSideOrgName', data: 'reportData.flatRateTraOwnPsBldgingSideOrgName' },
                { name: 'flatRateTraOwnPsBldgingSideSectionCode', data: 'reportData.flatRateTraOwnPsBldgingSideSectionCode' },
                { name: 'flatRateTraOwnPsBldgingSectionName', data: 'reportData.flatRateTraOwnPsBldgingSectionName' },
                { name: 'flatRateTraOwnPsPayerOrgCode', data: 'reportData.flatRateTraOwnPsPayerOrgCode' },
                { name: 'flatRateTraOwnPsPayingOrgName', data: 'reportData.flatRateTraOwnPsPayingOrgName' },
                { name: 'flatRateTraOwnPsPaymentDepaCode', data: 'reportData.flatRateTraOwnPsPaymentDepaCode' },
                { name: 'flatRateTraOwnPsPaymentDepaName', data: 'reportData.flatRateTraOwnPsPaymentDepaName' },
                { name: 'flatRateTraOwnPsCntDate', data: 'reportData.flatRateTraOwnPsCntDate' },
                { name: 'flatRateTraOwnPsInitialBillingAmt', data: 'reportData.flatRateTraOwnPsInitialBillingAmt' },
                { name: 'flatRateTraOwnPsMonthlyBillingAmt', data: 'reportData.flatRateTraOwnPsMonthlyBillingAmt' },
                { name: 'flatRateTraOwnPsFinalChargeAmt', data: 'reportData.flatRateTraOwnPsFinalChargeAmt' },
                { name: 'flatRateTraOwnPsBillingInitialAcptCntStatus', data: 'reportData.flatRateTraOwnPsBillingInitialAcptCntStatus' },
                { name: 'flatRateTraOwnPsPaymentSideFirstChkCntState', data: 'reportData.flatRateTraOwnPsPaymentSideFirstChkCntState' },
                { name: 'flatRateTraOwnPsContactPerson', data: 'reportData.flatRateTraOwnPsContactPerson' },
                { name: 'flatRateTraOwnPsContactPersonTel', data: 'reportData.flatRateTraOwnPsContactPersonTel' },
                { name: 'flatRateTraOwnPsContactPersonTelMailAddress', data: 'reportData.flatRateTraOwnPsContactPersonTelMailAddress' },
                { name: 'flatRateTraOwnPsOwnContactPerson', data: 'reportData.flatRateTraOwnPsOwnContactPerson' },
                { name: 'flatRateTraOwnPsOwnContactPersonTel', data: 'reportData.flatRateTraOwnPsOwnContactPersonTel' },
                { name: 'flatRateTraOwnPaymentOwnContactPersonTelMailAddress', data: 'reportData.flatRateTraOwnPaymentOwnContactPersonTelMailAddress' },
                { name: 'flatRateTraOwnPsBillingInitialAcptCntStatus', data: 'reportData.flatRateTraOwnPsBillingInitialAcptCntStatus' },
                { name: 'area', data: 'progressData.area' },
                { name: 'processingGuide', data: 'progressData.processingGuide' },
            ]
        },
        // 個別取引（自社請求側）
        3: {
            url: '/api/incomplete/IdvRateTraInHbs',
            columnData: [
                { name: 'accountingReportDataId', data: 'reportData.accountingReportDataId' },
                { name: 'reminderExclusion', data: 'progressData.reminderExclusion' },
//                問合せNo
                { defaultContent: "123456" },
//                問合せステータス
                { defaultContent: "問合せステータス" },
                { name: 'judgement', data: 'progressData.judgement' },
                { name: 'processingStatus', data: 'progressData.processingStatus' },
                { name: 'baJudgement', data: 'progressData.baJudgement' },
                { name: 'processingStatus', data: 'progressData.baProcessingStatus' },
                { name: 'baComment', data: 'progressData.baComment' },
                { name: 'updateUser', data: 'progressData.updateUser' },
//                期末計上結果判定
                { defaultContent: "期末計上結果判定" },
                { name: 'idvRateTraInHbsStatus', data: 'reportData.idvRateTraInHbsStatus'},
                { name: 'idvRateTraInHbsSynapse', data: 'reportData.idvRateTraInHbsSynapse'},
                { name: 'idvRateTraInHbsOwnCompanyNameBldgingSide', data: 'reportData.idvRateTraInHbsOwnCompanyNameBldgingSide'},
                { name: 'idvRateTraInHbsOtherCompanyName', data: 'reportData.idvRateTraInHbsOtherCompanyName'},
                { name: 'idvRateTraInHbsContractRegistrationNumber', data: 'reportData.idvRateTraInHbsContractRegistrationNumber'},
                { name: 'idvRateTraInHbsContractSbj', data: 'reportData.idvRateTraInHbsContractSbj'},
                { name: 'idvRateTraInHbsBldgingSideOrgCode', data: 'reportData.idvRateTraInHbsBldgingSideOrgCode'},
                { name: 'idvRateTraInHbsBlgingSideOrgName', data: 'reportData.idvRateTraInHbsBlgingSideOrgName'},
                { name: 'idvRateTraInHbsBldgingSideSectionCode', data: 'reportData.idvRateTraInHbsBldgingSideSectionCode'},
                { name: 'idvRateTraInHbsBlgingSideSectionName', data: 'reportData.idvRateTraInHbsBlgingSideSectionName'},
                { name: 'idvRateTraInHbsPayingSideOrgCode', data: 'reportData.idvRateTraInHbsPayingSideOrgCode'},
                { name: 'idvRateTraInHbsPayingOrgName', data: 'reportData.idvRateTraInHbsPayingOrgName'},
                { name: 'idvRateTraInHbsPaymentSectionCode', data: 'reportData.idvRateTraInHbsPaymentSectionCode'},
                { name: 'idvRateTraInHbsPayingSideSectionName', data: 'reportData.idvRateTraInHbsPayingSideSectionName'},
                { name: 'idvRateTraInHbsTraType', data: 'reportData.idvRateTraInHbsTraType'},
                { name: 'idvRateTraInHbsRoughIdentification', data: 'reportData.idvRateTraInHbsRoughIdentification'},
                { name: 'idvRateTraInHbsCntDate', data: 'reportData.idvRateTraInHbsCntDate'},
                { name: 'idvRateTraInHbsServiceStartDate', data: 'reportData.idvRateTraInHbsServiceStartDate'},
                { name: 'idvRateTraInHbsServiceCloseDate', data: 'reportData.idvRateTraInHbsServiceCloseDate'},
                { name: 'idvRateTraInHbsTradingDay', data: 'reportData.idvRateTraInHbsTradingDay'},
                { name: 'idvRateTraInHbsBillingNumber', data: 'reportData.idvRateTraInHbsBillingNumber'},
                { name: 'idvRateTraInHbsPaymentNumber', data: 'reportData.idvRateTraInHbsPaymentNumber'},
                { name: 'idvRateTraInHbsAmt', data: 'reportData.idvRateTraInHbsAmt'},
                { name: 'idvRateTraInHbsContactPerson', data: 'reportData.idvRateTraInHbsContactPerson'},
                { name: 'idvRateTraInHbsContactPersonTel', data: 'reportData.idvRateTraInHbsContactPersonTel'},
                { name: 'idvRateTraInHbsContactPersonEmailAddress', data: 'reportData.idvRateTraInHbsContactPersonEmailAddress'},
                { name: 'idvRateTraInHbsInHouseContact', data: 'reportData.idvRateTraInHbsInHouseContact'},
                { name: 'idvRateTraInHbsInHouseContactTel', data: 'reportData.idvRateTraInHbsInHouseContactTel'},
                { name: 'idvRateTraInHbsEmailAddress', data: 'reportData.idvRateTraInHbsEmailAddress'},
                { name: 'idvRateTraInHbsDaysSinceCntDate', data: 'reportData.idvRateTraInHbsDaysSinceCntDate'},
                { name: 'area', data: 'progressData.area' },
                { name: 'processingGuide', data: 'progressData.processingGuide' },
            ]
        },
        // 個別取引（自社支払側）
        4: {
            url: '/api/incomplete/IdvRateTraOwnPs',
            columnData: [
                { name: 'accountingReportDataId', data: 'reportData.accountingReportDataId' },
                { name: 'reminderExclusion', data: 'progressData.reminderExclusion' },
//                問合せNo
                { defaultContent: "123456" },
//                問合せステータス
                { defaultContent: "問合せステータス" },
                { name: 'judgement', data: 'progressData.judgement' },
                { name: 'processingStatus', data: 'progressData.processingStatus' },
                { name: 'baJudgement', data: 'progressData.baJudgement' },
                { name: 'processingStatus', data: 'progressData.baProcessingStatus' },
                { name: 'baComment', data: 'progressData.baComment' },
                { name: 'updateUser', data: 'progressData.updateUser' },
                { name: 'noBillingSideParticipationNoAmount', data: 'progressData.noBillingSideParticipationNoAmount' },
//                期末計上結果判定 ※G間は「請求番号」？、契約登録番号？
                { defaultContent: "期末計上結果判定" },
                { name: 'idvRateTraOwnPsStatus', data: 'reportData.idvRateTraOwnPsStatus'},
                { name: 'idvRateTraOwnPsSynapse', data: 'reportData.idvRateTraOwnPsSynapse'},
                { name: 'idvRateTraOwnPsOwnCompanyNamePaymentSide', data: 'reportData.idvRateTraOwnPsOwnCompanyNamePaymentSide'},
                { name: 'idvRateTraOwnPsOtherCompanyName', data: 'reportData.idvRateTraOwnPsOtherCompanyName'},
                { name: 'idvRateTraOwnPsContractRegistrationNumber', data: 'reportData.idvRateTraOwnPsContractRegistrationNumber'},
                { name: 'idvRateTraOwnPsContractSbj', data: 'reportData.idvRateTraOwnPsContractSbj'},
                { name: 'idvRateTraOwnPsBldgingSideOrgCode', data: 'reportData.idvRateTraOwnPsBldgingSideOrgCode'},
                { name: 'idvRateTraOwnPsBldgingSideOrgName', data: 'reportData.idvRateTraOwnPsBldgingSideOrgName'},
                { name: 'idvRateTraOwnPsBldgingSideSectionCode', data: 'reportData.idvRateTraOwnPsBldgingSideSectionCode'},
                { name: 'idvRateTraOwnCompanyPaymentSideBldgingSectionName', data: 'reportData.idvRateTraOwnCompanyPaymentSideBldgingSectionName'},
                { name: 'idvRateTraOwnPsPayerOrgCode', data: 'reportData.idvRateTraOwnPsPayerOrgCode'},
                { name: 'idvRateTraOwnPsPayingOrgName', data: 'reportData.idvRateTraOwnPsPayingOrgName'},
                { name: 'idvRateTraOwnPsPaymentDepaCode', data: 'reportData.idvRateTraOwnPsPaymentDepaCode'},
                { name: 'idvRateTraOwnPsPaymentDepaName', data: 'reportData.idvRateTraOwnPsPaymentDepaName'},
                { name: 'idvRateTraOwnPsTraType', data: 'reportData.idvRateTraOwnPsTraType'},
                { name: 'idvRateTraOwnPsRoughIdentification', data: 'reportData.idvRateTraOwnPsRoughIdentification'},
                { name: 'idvRateTraOwnPsCntDate', data: 'reportData.idvRateTraOwnPsCntDate'},
                { name: 'idvRateTraOwnPsServiceStartDate', data: 'reportData.idvRateTraOwnPsServiceStartDate'},
                { name: 'idvRateTraOwnPsTradingDay', data: 'reportData.idvRateTraOwnPsTradingDay'},
                { name: 'idvRateTraOwnPsBillingNumber', data: 'reportData.idvRateTraOwnPsBillingNumber'},
                { name: 'idvRateTraOwnPsPaymentNumber', data: 'reportData.idvRateTraOwnPsPaymentNumber'},
                { name: 'idvRateTraOwnPsAmt', data: 'reportData.idvRateTraOwnPsAmt'},
                { name: 'idvRateTraOwnPsContactPerson', data: 'reportData.idvRateTraOwnPsContactPerson'},
                { name: 'idvRateTraOwnPsContactPersonTel', data: 'reportData.idvRateTraOwnPsContactPersonTel'},
                { name: 'idvRateTraOwnPsContactPersonEmailAddress', data: 'reportData.idvRateTraOwnPsContactPersonEmailAddress'},
                { name: 'idvRateTraOwnPsInHouseContact', data: 'reportData.idvRateTraOwnPsInHouseContact'},
                { name: 'idvRateTraOwnPsInHouseContactTel', data: 'reportData.idvRateTraOwnPsInHouseContactTel'},
                { name: 'idvRateTraOwnPsEmailAddress', data: 'reportData.idvRateTraOwnPsEmailAddress'},
                { name: 'idvRateTraOwnPsDaysSinceCntDate', data: 'reportData.idvRateTraOwnPsDaysSinceCntDate'},
                { name: 'idvRateTraOwnPsRemarks', data: 'reportData.idvRateTraOwnPsRemarks'},
                { name: 'area', data: 'progressData.area' },
                { name: 'processingGuide', data: 'progressData.processingGuide' },
            ]
        }
    };

    $('#menuIncomplete').toggleClass('active');

    showDataTable(DEFAULT_SHEET_ID);

    $('#btn-decision').prepend('<input type="checkbox" class="form-check-input button-check" id="check-decision">');

    $('#btn-decision').click(function() {
        var checkBox = $('#check-decision')
        checkBox.prop("checked", !checkBox.prop("checked"));
    });

    $('#btn-filter').click(function(e) {
        e.preventDefault();

        var sheetId = $('#filter-sheetname').val();
        showDataTable(sheetId);
    });

    function prepareTargetTable(subReportId) {
        $('#filter-sheetname > option').each(function() {
            var optionVal = $(this).val();
            $('#datatable' + optionVal).DataTable().destroy();

            if (optionVal === subReportId) {
                $('#datatable' + optionVal).show();
            } else {
                $('#datatable' + optionVal).hide();
            }
        })
    }

    function showDataTable(subReportId) {
        var data = dataTableData[subReportId];
        prepareTargetTable(subReportId);

        var table = $('#datatable' + subReportId).DataTable({
            language: {
                url: '../i18n/datatables/lang_ja.json'
            },
            sScrollX: '100%',
            sScrollXInner: '100%',
            sScrollY: 'calc(100vh - 285px)',
            sScrollCollapse: true,
            processing: true,
            serverSide: true,
            pageLength: 20,
            lengthMenu: [20, 50, 100],
            pagingType: 'full_numbers',
            ajax: {
                url : data.url,
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: function(d) {
                    d.subReportNo = subReportId;
                    d.fiscalPeriod = $('#filter-year').val() + $('#filter-month').val();
                    return JSON.stringify( d );
                },
                complete: function(r) {
                    $('#datatable' + subReportId + '_check-all').prop('checked', false);

                    responseData = r.responseJSON.data;

                    $('#btn-save').off('click').on('click', function() {
                        $('#datatable' + subReportId).DataTable.$('tr.odd, tr.even').each(function() {
                            var accountingReportDataId = $(this).find('td:first-child').html();
                            var reminderExclusion = $(this).find('#reminderExclusion' + accountingReportDataId).is(':checked') ? 1 : 0;

                            var requestData = {
                                baComment: $(this).find('#baComment' + accountingReportDataId).val(),
                                baJudgement: parseInt($(this).find('#baJudgement' + accountingReportDataId).val()),
                                baProcessingStatus: $(this).find('#baProcessingStatus' + accountingReportDataId).val(),
                                reminderExclusion: reminderExclusion,
                            }

                            saveRowData(accountingReportDataId, requestData);
                        });
                    });

                    $('#btn-cancel').off('click').on('click', function() {
                        for (var i = 0; i < responseData.length; i++) {
                            var accountingReportDataId = responseData[i].reportData.accountingReportDataId;
                            var progressData = responseData[i].progressData;

                            $('#baComment' + accountingReportDataId).val(progressData.baComment);
                            $('#baJudgement' + accountingReportDataId).val(progressData.baJudgement);
                            $('#baProcessingStatus' + accountingReportDataId).val(progressData.baProcessingStatus);
                            $('#reminderExclusion' + accountingReportDataId).prop('checked', progressData.reminderExclusion);
                        }
                    });
                },
            },
            columns: data.columnData,
            // No default sorting
            order: [],
            columnDefs: [
                {
                    targets: 1,
                    render: function(data, type, row, meta) {
                        return '<input type="checkbox" id="reminderExclusion' + row.reportData.accountingReportDataId + '" name="reminderExclusion' + row.reportData.accountingReportDataId + '" ' + (row.progressData.reminderExclusion ? 'checked' : '' ) + ' />';
                    }
                },
                {
                    targets: 6,
                    render: function(data, type, row, meta) {
                        return '<select id="baJudgement' + row.reportData.accountingReportDataId + '" name="baJudgement' + row.reportData.accountingReportDataId + '" class="form-control form-control-sm" value="' + row.progressData.baJudgement + '"><option value="1">Option 1</option><option value="2">Option 2</option><option value="3">Option 3</option></select>';
                    }
                },
                {
                    targets: 7,
                    render: function(data, type, row, meta) {
                        return '<input type="text" id="baProcessingStatus' + row.reportData.accountingReportDataId + '" name="baProcessingStatus' + row.reportData.accountingReportDataId + '" class="form-control form-control-sm" value="' + row.progressData.baProcessingStatus + '" /> ';
                    }
                },
                {
                    targets: 8,
                    render: function(data, type, row, meta) {
                        return '<input type="text" id="baComment' + row.reportData.accountingReportDataId + '" name="baComment' + row.reportData.accountingReportDataId + '" class="form-control form-control-sm" value="' + row.progressData.baComment + '" /> ';
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
            aoColumnDefs: [{
                bSortable: false,
                aTargets: [1],
            }],
            initComplete: function(settings, json) {
                $('#datatable' + subReportId + '_filter')
                    .prepend('<button id="btn-save" type="button" class="btn btn-sm btn-primary btn-fixed-size mr-3">保存する</button>')
                    .prepend('<button id="btn-cancel" type="button" class="btn btn-sm btn-secondary btn-fixed-size mr-2">キャンセル</button>');
            },
        });

        $('#datatable' + subReportId + '_check-all').off('click').on('click', function() {
            var cols = table.column(1).nodes(),
                state = this.checked;

            for (var i = 0; i < cols.length; i += 1) {
                cols[i].querySelector('input[type="checkbox"]').checked = state;
            }
        });
    }

    function saveRowData(id, requestData) {
        $.ajax({
            cache: false,
            url: '/api/incomplete/' + id,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(data) {
//                console.log('Success!');
                for (var i = 0; i < responseData.length; i++) {
                    if (responseData[i].reportData.accountingReportDataId == id) {
                        responseData[i].progressData.baComment = requestData.baComment;
                        responseData[i].progressData.baJudgement = requestData.baJudgement;
                        responseData[i].progressData.baProcessingStatus = requestData.baProcessingStatus;
                        responseData[i].progressData.reminderExclusion = requestData.reminderExclusion;
                        break;
                    }
                }
            },
            fail: function() {
//                console.log('Failed!');
            }
        });
    }
});
