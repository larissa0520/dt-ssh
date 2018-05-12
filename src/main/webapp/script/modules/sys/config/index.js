/**
 * 用户管理
 */
var vm = new Vue({
    el: '#dtApp',
    data: {},
    methods: {
        loadTable: function () {

            var columns = [
                {title: 'ID', field: 'id'},
                {title: '参数名', field: 'key'},
                {title: '参数值', field: 'value'},
                {title: '备注', field: 'remark'},
                {
                    title: '状态', field: 'status', formatter: function (value) {

                        switch (value) {
                            case 0:
                                return '<span class="label label-primary">禁用</span>';
                                break;
                            case 1:
                                return '<span class="label label-success">正常</span>';
                                break;

                        }

                    }
                },
                {
                    title: '操作', field: 'id', formatter: function (value, row, index) {
                        var edit = '<a href="form?edit&id=' + value + '" class="btn btn-success btn-xs">编辑</a>';
                        return edit;
                    }
                }
            ];

            var option = T.btTableOption;
            var allColumns = option.columns.concat(columns);//合并列
            option.columns = allColumns;
            option.url = 'list';

            $('#table').bootstrapTable(option);
        },

        deleteBatch: function () {
            T.deleteMoreItem('id');
        }
    }
});

vm.loadTable();