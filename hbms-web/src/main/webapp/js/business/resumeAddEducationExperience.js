/**
 * Created by fellowlong on 2014/10/9.
 */
dataGridEdit({
  dataGridId: "#educationExperienceDg",
  dataGridInitData: function () {
    if ($('#resumeDg')) {
      var editingResume = $('#resumeDg').datagrid('getSelected');
      if (editingResume && editingResume.educationExperiences) {
        return editingResume.educationExperiences;
      }
    }
    return null;
  },
  dataGridTbId: "#educationExperienceDgTb",
  editWinId: "#educationExperienceEditWin",
  editWinWidth: 300,
  editWinHeight: 190,
  editWinBaseTitle: "教育经历",
  editWinTbId: "#educationExperienceEditWinTb",
  editWinFormId: "#educationExperienceEditForm",
  add: undefined,
  edit: undefined,
  remove: undefined,
  view: undefined
});