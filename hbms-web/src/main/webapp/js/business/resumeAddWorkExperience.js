/**
 * Created by fellowlong on 2014/10/9.
 */
dataGridEdit({
    dataGridId:"#workExperienceDg",
    dataGridInitData:function() {
      try {
        if($('#resumeDg')) {
          var editingResume = $('#resumeDg').datagrid('getSelected');
          if(editingResume && editingResume.workExperiences) {
            return editingResume.workExperiences;
          }
        }
      } catch(e) {}
      return null;
    },
    dataGridTbId:"#workExperienceDgTb",
    editWinId: "#workExperienceEditWin",
    editWinWidth:300,
    editWinHeight:320,
    editWinBaseTitle:"工作经历",
    editWinTbId: "#workExperienceEditWinTb",
    editWinFormId: "#workExperienceEditForm",
    add : undefined,
    edit : undefined,
    remove : undefined,
    view : undefined
  });