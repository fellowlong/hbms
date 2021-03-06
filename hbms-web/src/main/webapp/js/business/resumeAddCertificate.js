/**
 * Created by fellowlong on 2014/10/9.
 */
dataGridEdit({
  dataGridId: "#certificateDg",
  dataGridInitData: function () {
    try {
      var editingResume = $('#resumeDg').datagrid('getSelected');
      if (editingResume && editingResume.certificates) {
        return editingResume.certificates;
      }
    } catch(e) {}
    return null;
  },
  dataGridTbId: "#certificateDgTb",
  editWinId: "#certificateEditWin",
  editWinWidth: 300,
  editWinHeight: 130,
  editWinBaseTitle: "证书",
  editWinTbId: "#certificateEditWinTb",
  editWinFormId: "#certificateEditForm",
  add: undefined,
  edit: undefined,
  remove: undefined,
  view: undefined
});