/**
 * Created by fellowlong on 2014/10/9.
 */
dataGridEdit({
  dataGridId: "#languageAbilityDg",
  dataGridInitData: function () {
    if ($('#resumeDg')) {
      var editingResume = $('#resumeDg').datagrid('getSelected');
      if (editingResume && editingResume.languageAbilities) {
        return editingResume.languageAbilities;
      }
    }
    return null;
  },
  dataGridTbId: "#languageAbilityDgTb",
  editWinId: "#languageAbilityEditWin",
  editWinWidth: 300,
  editWinHeight: 160,
  editWinBaseTitle: "语言能力",
  editWinTbId: "#languageAbilityEditWinTb",
  editWinFormId: "#languageAbilityEditForm",
  add: undefined,
  edit: undefined,
  remove: undefined,
  view: undefined
});