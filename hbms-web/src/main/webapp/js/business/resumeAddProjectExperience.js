/**
 * Created by fellowlong on 2014/10/9.
 */
dataGridEdit({
  dataGridId: "#projectExperienceDg",
  dataGridInitData: function () {
    try {
      if ($('#resumeDg')) {
        var editingResume = $('#resumeDg').datagrid('getSelected');
        if (editingResume && editingResume.projectExperiences) {
          return editingResume.projectExperiences;
        }
      }
    } catch(e) {}
    return null;
  },
  dataGridTbId: "#projectExperienceDgTb",
  editWinId: "#projectExperienceEditWin",
  editWinWidth: 300,
  editWinHeight: 500,
  editWinBaseTitle: "项目经历",
  editWinTbId: "#projectExperienceEditWinTb",
  editWinFormId: "#projectExperienceEditForm",
  add: undefined,
  edit: undefined,
  remove: undefined,
  view: undefined
});