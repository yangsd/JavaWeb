 function changeP(){
            var dg = $('#tt');
            dg.datagrid('loadData',[]);
            dg.datagrid({pagePosition:'bottom'});
            dg.datagrid('getPager').pagination({
                layout:['list','sep','first','prev','sep','manual','sep','next','last','sep','refresh']
            });
        }